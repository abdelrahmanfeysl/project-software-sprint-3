package com.notfication.Application;

import com.notfication.model.FormattedNotification;
import com.notfication.model.NotificationTemplate;
import com.notfication.repo.FormattedNotificationFunctions;
import com.notfication.services.FormattedNotificationServices;
import com.notfication.services.NotificationTemplateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ConsoleApplicationImplementation implements ConsoleApplicationInterface {

    FormattedNotificationFunctions formattedNotificationFunctions;
    FormattedNotificationServices notificationServices;
    NotificationTemplateServices templateServices;
    int doneEmails =0;
    int doneSMS=0;
    @Autowired
    public void ConsoleApplicationImplementation(@Qualifier("finalRepo") FormattedNotificationFunctions formattedNotificationFunctions,
                                            @RequestBody FormattedNotificationServices notificationServices,
                                            @RequestBody  NotificationTemplateServices templateServices) {
        this.formattedNotificationFunctions = formattedNotificationFunctions;
        this.notificationServices = notificationServices;
        this.templateServices = templateServices;

    }
    public void ConsoleApplicationImplementation() {
    }
    public void printMenu()

    {
        System.out.println("\nPlease Choose the type of notification");
        System.out.println("1- Confirming email \n2- Forget your Password \n3- Booking an item \n4- Exit");
        List<NotificationTemplate> templates = templateServices.getAllTemplates();
        List<FormattedNotification> notifications = notificationServices.getAll();
        List<NotificationTemplate> confirm = getAllConfirm(templates);
        List<NotificationTemplate> booking = getAllBooking(templates);
        List<NotificationTemplate> password = getAllForgetPassword(templates);
        NotificationTemplate userTemplate;
        int choice=0;

        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int i=0;
        while (choice<4)
        {
            choice=scanner.nextInt();
            if (choice == 1)
            {
                if(confirm.size()==0)
                    System.out.println("there is no confirm email templates " + confirm.size());
                else
                {
                    System.out.print("Please enter your user name : ");
                    String ph1= sc.nextLine();
                    System.out.print("Please enter your email : ");
                    String ph2= sc.nextLine();
                    userTemplate= confirm.get(0);
                    FormattedNotification newNotification = new FormattedNotification(notifications.size()+1,
                            userTemplate.id,"email", ph1,ph2);
                    newNotification.formattedContent = notificationServices.formattingNotification(userTemplate,newNotification);
                    notifications.add(newNotification);
                    notificationServices.add(newNotification);

                }

            }
            else if (choice == 2)
            {
                if(password.size()==0)
                    System.out.println("there is no forget passwords templates ");
                else
                {
                    System.out.print("Please enter your User name : ");
                    String ph1= sc.nextLine();
                    System.out.print("Please enter your email : ");
                    String ph2= sc.nextLine();
                    userTemplate= password.get(0);
                    FormattedNotification newNotification = new FormattedNotification(notifications.size()+1,
                            userTemplate.id,"email", ph1,ph2);
                    newNotification.formattedContent = notificationServices.formattingNotification(userTemplate,newNotification);
                    notifications.add(newNotification);
                    notificationServices.add(newNotification);

                }

            }
            else if(choice ==3)
            {
                if(booking.size()==0)
                    System.out.println("there is no booking templates ");
                else
                {
                    System.out.print("Please enter your user name : ");
                    String ph1= sc.nextLine();
                    System.out.print("Please enter your item : ");
                    String ph2= sc.nextLine();
                    userTemplate= booking.get(0);
                    FormattedNotification newNotification = new FormattedNotification(notifications.size()+1,
                            userTemplate.id,"sms", ph1,ph2);
                    newNotification.formattedContent = notificationServices.formattingNotification(userTemplate,newNotification);
                    notifications.add(newNotification);
                    notificationServices.add(newNotification);

                }

            }

        }
        System.out.println("OUT");
        List<FormattedNotification> email = getAllEmails(notifications);
        int noEmails = email.size();
        List<FormattedNotification> sms = getAllSms(notifications);
        int noSMS = sms.size();
        int choose =0;
        System.out.println("1 -Dequeue Emails \n");
        int j=0;
        for(; j <email.size(); j=j+2)
        {
            FormattedNotification temp = email.get(j);
            email.remove(j);
            System.out.println(temp);
            doneEmails++;
            notificationServices.delete(temp.id);
        }
        if(noEmails == doneEmails)
        {
            System.out.println("All emails sent successfully ");
        }
        else if (email.size()==0)
        {
            System.out.println("No notification to be sent");
        }
        else
        {
            System.out.println((noEmails-doneEmails)+" emails failed to be sent : " );

        }
        System.out.println("2- Dequeue SMS \n");

        for(j=0; j <sms.size(); j=j+2)
        {
            FormattedNotification temp = sms.get(j);
            sms.remove(j);
            System.out.println(temp);
            doneSMS++;
            notificationServices.delete(temp.id);
        }
        if(noSMS == doneSMS && sms.size()==0) {
            if(sms.size()==0)
            {
                System.out.println("No notification in the queue");
            }
            else
            {
                System.out.println("All sms sent successfully ");

            }
        }
        else
        {
            System.out.println((noSMS-doneSMS) + " sms are filed to sent ");


        }





        

    }
    public List<NotificationTemplate> getAllConfirm(List<NotificationTemplate> allTemplates){
        ArrayList<NotificationTemplate> confirm = new ArrayList<>();

        for (NotificationTemplate notification : allTemplates) {
            String type = notification.type.toLowerCase();
            if (type.equals("confirm email")) {
                confirm.add(notification);
            }
        }
        return confirm;
    }
    public List<NotificationTemplate> getAllBooking(List<NotificationTemplate> allTemplates){
        ArrayList<NotificationTemplate> book = new ArrayList<>();

        for (NotificationTemplate notification : allTemplates) {
            String booking = notification.type.toLowerCase();
            if (booking.equals("booking")) {
                book.add(notification);
            }
        }
        return book;
    }
    public List<NotificationTemplate> getAllForgetPassword(List<NotificationTemplate> allTemplates){
        ArrayList<NotificationTemplate> password = new ArrayList<>();

        for (NotificationTemplate notification : allTemplates) {
            String forgetPassword = notification.type.toLowerCase();
            if (forgetPassword.equals("forget password")){
                password.add(notification);
            }
        }
        return password;
    }

    public List<FormattedNotification> getAllEmails(List<FormattedNotification> allNotifications){
        ArrayList<FormattedNotification> emails = new ArrayList<>();

        for (FormattedNotification notification : allNotifications) {
            if (notification.channel.equals("email") || notification.channel.equals("EMAIL") || notification.channel.equals("Email")) {
                emails.add(notification);
            }
        }
        return emails;
    }
    public List<FormattedNotification> getAllSms(List<FormattedNotification> allNotifications)
    {
        ArrayList<FormattedNotification> sms = new ArrayList<>();

        for (FormattedNotification notification : allNotifications) {
            if (notification.channel.equals("sms") || notification.channel.equals("SMS") || notification.channel.equals("Sms")){
                sms.add(notification);
            }
        }
        return sms;
    }
}
