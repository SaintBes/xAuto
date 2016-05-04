package xAuto.controller;

import com.google.gson.Gson;
import org.apache.log4j.Logger;


import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import xAuto.domain.Client;
import xAuto.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by admssa on 25.04.2016.
 */
@Controller
@SessionAttributes("user")
public class IndexController {
    public static final Logger log = Logger.getLogger(IndexController.class);



       @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
        public String hello(HttpServletRequest request, ModelMap model, HttpSession session) {


            return "index";

        }

    }


