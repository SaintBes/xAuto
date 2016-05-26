package xAuto.controller;


import xAuto.domain.Adressess;
import xAuto.domain.Order;
import xAuto.domain.User;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

/**
 * Created by admssa on 20.05.2016.
 */
public class MailSender {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;




    public MailSender() {

            }


    public void generateAndSendEmail(Order order, int messageDst) throws AddressException, MessagingException {

        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "25");
        mailServerProperties.put("mail.smtp.auth", "false");
        mailServerProperties.setProperty("mail.mime.charset", "UTF-8");
      mailServerProperties.put("mail.smtp.starttls.enable", "false");
        System.out.println("Mail Server Properties have been setup successfully..");

        if(messageDst==1) {
            // Step2
            System.out.println("\n\n 2nd ===> get Mail Session..");
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(order.getOrderClient().getClietnEmail()));
            generateMailMessage.setSubject("Заказ автомобиля " + order.getOrderId());
            String emailBody = "\n По Вашей заявке назначен автомобиль: " + order.getOrderCar().getCarName()
                    + "\n Номер: " + order.getOrderCar().getCarNumber()
                    + "\n Время отправления: " + epochConvertor(order.getOrderTimeStart())
                    + "\n Водитель: " + order.getOrderCar().getCarDriver().getDriverName() + " тел." + order.getOrderCar().getCarDriver().getDriverPhone() + "";
            generateMailMessage.setContent(emailBody, "text/plain; charset=\"UTF-8\"");
            System.out.println("Mail Session has been created successfully..");
        }
        else {
            System.out.println("\n\n 2nd ===> get Mail Session..");
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("lutsenko@uim.kiev.ua"));  ///Поменять єту херню
            generateMailMessage.setSubject("Новая заявка " + order.getOrderId());
            String emailBody = "\n Сотрудник: " + order.getOrderClient().getClientName()
                    + "\n тел: " + order.getOrderClient().getClientPhone()
                    + "\n Время отправления: " + epochConvertor(order.getOrderTimeStart())
                    + "\n Время Возврата: " + epochConvertor(order.getOrderTimeOver()) +"";
            generateMailMessage.setContent(emailBody, "text/plain; charset=\"UTF-8\"");
            System.out.println("Mail Session has been created successfully..");
        }


        // Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");
        transport.connect("mail.uim.kiev.ua", "xauto@uim.kiev.ua", "xauto1715");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();

    }

    private String epochConvertor(long stringDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");

        Date date = new Date(stringDate);
//        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String formatted = format.format(date);

        return formatted;
    }


}
