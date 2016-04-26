package xAuto.controller;

/**
 * Created by admssa on 26.04.2016.
 */

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class DashboardController {
    public static final Logger log = Logger.getLogger(DashboardController.class);

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String adminpanel(Model model, HttpSession session) {

        return "dashboard";
}
}
