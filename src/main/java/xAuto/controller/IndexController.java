package xAuto.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;


import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import xAuto.domain.Adressess;
import xAuto.domain.Client;
import xAuto.domain.Order;
import xAuto.domain.RequestForm;
import xAuto.service.AdressessService;
import xAuto.service.ClientService;
import xAuto.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by admssa on 25.04.2016.
 */
@Controller
@SessionAttributes("user")
public class IndexController {
    public static final Logger log = Logger.getLogger(IndexController.class);


    @Autowired
    OrderService orderService;

    @Autowired
    ClientService clientService;

    @Autowired
    AdressessService adressessService;

       @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
        public String hello(HttpServletRequest request, ModelMap model, HttpSession session) {


            return "index";

        }


    @RequestMapping(value = "/addRequest", method = RequestMethod.POST)
    public String addRequest(@ModelAttribute RequestForm requestForm, BindingResult result) {

        Client client = clientService.getClientByEmail(requestForm.getEmail());
        if (requestForm.getPhoneNumber()!=null) {
            client.setClientPhone(requestForm.getPhoneNumber());
            clientService.updateClient(client);
        }


        Order order = new Order();
        order.setOrderIsOpen(true);
        order.setOrderClient(client);
        order.setOrderTimeStart(dateConvertor(requestForm.getDate_timepicker_start()));
        order.setOrderTimeOver(dateConvertor(requestForm.getDate_timepicker_end()));



        String jsonLine = requestForm.getAddrJson();
        Type itemsListType = new TypeToken<List<Adressess>>() {}.getType();
        List<Adressess> listItemsDes = new Gson().fromJson(requestForm.getAddrJson(),itemsListType);

//        for (Adressess listItemsDe : listItemsDes) {
//            order.getOrderAddresses().add(listItemsDe);
//            adressessService.addAdressess(listItemsDe);
//            listItemsDe.setOrder(order);
//
////
//        }

        order.setOrderAddresses(listItemsDes);
        order = orderService.addOrder(order);

        for (Adressess adressess : order.getOrderAddresses()) {
            adressess.setOrder(orderService.getOrder(or));
        }






        for (Adressess adressess : order.getOrderAddresses()) {
            System.out.println("++++++++++++++"+adressess.getAdressess() + " "+ order.getOrderId());
        }


        return "index";
    }

    private long dateConvertor(String stringDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");


        Date   date = null;
        try {
            date = (Date) format.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long epoch = date.getTime();

        return epoch;
    }
    }


