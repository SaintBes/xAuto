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
import xAuto.service.CarService;
import xAuto.service.DriverService;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class DashboardController {
    public static final Logger log = Logger.getLogger(DashboardController.class);
    private static final String DRIVERS_LIST = "driversList";

    @Autowired
    DriverService driverService;

    @Autowired
    CarService carService;

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String adminpanel(Model model, HttpSession session) {
        model.addAttribute(DRIVERS_LIST,driverService.getAllDrivers());


        return "dashboard";
}
    @RequestMapping(value = "/addDriver", method = RequestMethod.POST)
    public String addRequest(@ModelAttribute Driver driver, BindingResult result) {

        driverService.addDriver(driver);

        return "dashboard";
    }

    @RequestMapping(value = "/carAdd", method = RequestMethod.POST)
    public String addRequest(@ModelAttribute Car car, BindingResult result) {

//        driverService.getDriver(car.getCarDriver().getDriverId()); здесь я закончил
        carService.addCar(car);



        return "dashboard";
    }

}
