package xAuto.controller;

/**
 * Created by admssa on 26.04.2016.
 */

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import xAuto.domain.Car;
import xAuto.domain.Driver;
import xAuto.domain.Order;
import xAuto.service.CarService;
import xAuto.service.DriverService;
import xAuto.service.OrderService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
@SessionAttributes("user")
public class DashboardController {
    public static final Logger log = Logger.getLogger(DashboardController.class);
    private static final String DRIVERS_LIST = "driversList";
    private static final String ALLCARS_LIST = "allCarsList";
    private static final String NEW_ORDERS = "newOrders";
    private static final String OLD_ORDERS = "oldOrders";
    private static final String ERROR = "error";



    @Autowired
    DriverService driverService;

    @Autowired
    CarService carService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String adminpanel(Model model, HttpSession session) {

        //send drivers to html
        model.addAttribute(DRIVERS_LIST,driverService.getAllDrivers());

        //send newOrders & oldOrders to html
        List<Order> newOrders = new ArrayList<Order>();
        List<Order> oldOrders = new ArrayList<Order>();
        for (Order order : orderService.getAllOrders()) {
            if(order.isOrderIsOpen()) {


                newOrders.add(order);

            }
            else {oldOrders.add(order);}
        }


        model.addAttribute(NEW_ORDERS,newOrders);
        model.addAttribute(OLD_ORDERS,oldOrders);

        //send allCars
        model.addAttribute(ALLCARS_LIST,carService.getAllCars());



        return "dashboard";
}
    @RequestMapping(value = "/addDriver", method = RequestMethod.POST)
    public String addDriver(@ModelAttribute Driver driver, BindingResult result) {

        driverService.addDriver(driver);

        return "redirect:dashboard#drivers";
    }

    @RequestMapping(value = "/updateDriver", method = RequestMethod.POST)
    public String updateDriver(@ModelAttribute Driver driver, BindingResult result) {

        driverService.updateDriver(driver);

        return "redirect:dashboard#drivers";
    }

    @RequestMapping(value = "/deleteDriver", method = RequestMethod.POST)
    public String deleteDriver(@RequestParam(value = "delDriverId") int driverId) {

        Driver driver = driverService.getDriver(driverId);
        driverService.deleteDriver(driver);

        return "redirect:dashboard#drivers";
    }

//    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
//    public String addRequest( ) {
//
//        MailSender mailSender = new MailSender();
//        try {
//            mailSender.generateAndSendEmail();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:dashboard";
//    }


    @RequestMapping(value = "/carAdd", method = RequestMethod.POST)
    public String addRequest(@ModelAttribute Car car, @RequestParam(value = "carDriverId") int carDriverId, BindingResult result) {

        Car oldCar;
        Car newCar = carService.addCar(car);
        Driver driver = driverService.getDriver(carDriverId);

        if(driver.getCar()!=null) {
            oldCar = driver.getCar();
            oldCar.setCarDriver(null);
            carService.updateCar(oldCar);
        }
        driver.setCar(newCar);
        driverService.updateDriver(driver);


        return "redirect:dashboard#cars";
    }

    @RequestMapping(value = "/carUpdate", method = RequestMethod.POST)
    public String carUpdate(@ModelAttribute Car car, @RequestParam(value = "carDriverId") int carDriverId, BindingResult result) {

        Car oldCar;
        Driver oldCarDriver;

        Driver driver = driverService.getDriver(carDriverId);


        if(driver.getCar()!=null) {
            oldCarDriver = carService.getCar(car.getCarId()).getCarDriver();
            oldCar = driver.getCar();
            oldCarDriver.setCar(oldCar);
            carService.updateCar(oldCar);
            driverService.updateDriver(oldCarDriver);

        }


        driver.setCar(car);
        driverService.updateDriver(driver);
        carService.updateCar(car);

        return "redirect:dashboard#cars";
    }

    @RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
    public String deleteCar(@RequestParam(value = "delCarId") int carId) {

       Car car = carService.getCar(carId);

//        Driver driver = driverService.getDriver()
        Model model = null;

        for ( Driver driver : driverService.getAllDrivers() ) {
            if (driver.getCar()!=null){
                if(driver.getCar().getCarId()==carId) {
                    driver.setCar(null);
                    driverService.updateDriver(driver);
                }
            }
        }
        for (Order order : orderService.getAllOrders()) {
            if(order.getOrderCar()!=null) {
                if (order.getOrderCar().getCarId() == carId) {
                    model.addAttribute(ERROR, "Неможливо видалити автомобіль");
                    return "redirect:dashboard#cars";

                }
            }
        }

        carService.deleteCar(car);
        return "redirect:dashboard#cars";
    }

    @RequestMapping(value = "/setOrderCar", method = RequestMethod.POST)
    public String setOrderCar(@RequestParam(value = "carSelect") int carId,  @RequestParam(value = "orderId") int orderId) {

        Car car = carService.getCar(carId);
        Order order = orderService.getOrder(orderId);

        car.setBusyTimeStart(order.getOrderTimeStart());
        car.setBusyTimeOver(order.getOrderTimeOver());

        carService.updateCar(car);

        order.setOrderCar(car);
        order.setOrderIsOpen(false);
        orderService.updateOrder(order);

        MailSender mailSender = new MailSender();
        try {
            mailSender.generateAndSendEmail(order,1);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return "redirect:dashboard";
    }

    private String epochConvertor(long stringDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");

        Date date = new Date(stringDate);
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String formatted = format.format(date);

        return formatted;
    }

}
