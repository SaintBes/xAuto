package xAuto.controller;

/**
 * Created by admssa on 26.04.2016.
 */

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import xAuto.domain.Car;
import xAuto.domain.Driver;
import xAuto.domain.Order;
import xAuto.service.CarService;
import xAuto.service.DriverService;
import xAuto.service.OrderService;

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

        //send newOrders to html
        List<Order> newOrders = new ArrayList<Order>();
        for (Order order : orderService.getAllOrders()) {
            if(order.isOrderIsOpen()) {

                System.out.println("+++++++++++"+epochConvertor(order.getOrderTimeStart()));
                newOrders.add(order);

            }
        }

        for (Order newOrder : newOrders) {
            System.out.println(newOrder.getOrderClient().getClientName());
        }
        model.addAttribute(NEW_ORDERS,newOrders);

        //send allCars
        model.addAttribute(ALLCARS_LIST,carService.getAllCars());



        return "dashboard";
}
    @RequestMapping(value = "/addDriver", method = RequestMethod.POST)
    public String addRequest(@ModelAttribute Driver driver, BindingResult result) {

        driverService.addDriver(driver);

        return "redirect:dashboard";
    }

    @RequestMapping(value = "/carAdd", method = RequestMethod.POST)
    public String addRequest(@ModelAttribute Car car, BindingResult result) {

//        driverService.getDriver(car.getCarDriver().getDriverId()); здесь я закончил
        carService.addCar(car);



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
