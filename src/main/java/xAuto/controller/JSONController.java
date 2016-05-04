package xAuto.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import xAuto.domain.Client;
import xAuto.service.ClientService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admssa on 04.05.2016.
 */
@Controller
@SessionAttributes("user")
public class JSONController {

   private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    ClientService clientService;

            @RequestMapping(value = "/allClients", method =  RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<String> getAllClients(Model model) {

         List<String> clientsEmails = new ArrayList<String>();
                for (Client client : clientService.getAllClients()) {
                    clientsEmails.add(client.getClietnEmail());
                }

                return clientsEmails;
    }


}