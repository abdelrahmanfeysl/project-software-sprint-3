package com.notfication.services;

import com.notfication.model.FormattedNotification;
import com.notfication.model.NotificationTemplate;
import com.notfication.repo.FormattedNotificationFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormattedNotificationServices {

    FormattedNotificationFunctions formattedNotificationFunctions;
    NotificationTemplateServices notifyImplementation;
    @Autowired
    public FormattedNotificationServices(@Qualifier("finalRepo") FormattedNotificationFunctions formattedNotificationFunctions,
                                         @RequestBody NotificationTemplateServices notifyImplementation) {

        this.formattedNotificationFunctions = formattedNotificationFunctions;
        this.notifyImplementation = notifyImplementation;

    }




    public FormattedNotificationServices() {

    }
    public String formattingNotification(NotificationTemplate template, FormattedNotification notification) {
        String message = "";
        String content = template.getContent();
        String newContent = "";
        String ph1 = notification.getPlaceholder1();
        String ph2 = notification.getPlaceholder2();
        int x = content.indexOf("x");
        int y = content.indexOf("z");
        if(x==-1 && y==-1)
        {
            message="error in content format ";
        }
        else
        {
            newContent = content.substring(0,x) + ph1 + content.substring(x+1,y) + ph2 + content.substring(y+1,content.length());
            message += ("The used Template ID : " + template.getId() + " --- ");
            message += ("Language : " + template.getLanguage() + " --- ");
            message += ("Content : " + newContent + " --- ");
            notification.setFormattedContent(message);
        }

        return message;
    }
    public List<FormattedNotification> getAll(){

        List<FormattedNotification> f = this.formattedNotificationFunctions.findAll();

        return f;
    }



    public void add(FormattedNotification notification){
        //templates.add(template);
        FormattedNotification newNotification = new FormattedNotification(notification.id,
                notification.templateID,notification.channel,
                /*notification.formattedContent,*/notification.placeholder1,notification.placeholder2);

        NotificationTemplate template = notifyImplementation.getTemplate(notification.templateID);
        newNotification.formattedContent = formattingNotification(template,notification);
        this.formattedNotificationFunctions.save(newNotification);
    }
    public void delete(int notificationID){

        //templates.remove(templateID);
        this.formattedNotificationFunctions.deleteById(notificationID);
    }
    public void update(int notificationID,FormattedNotification notification){

        List<FormattedNotification> f = this.formattedNotificationFunctions.findAll();
        this.formattedNotificationFunctions.deleteAll();
        f.remove(notificationID);
        f.add(notificationID,notification);
        /*int i=0;
        while (n.size()!= 0){
            this.notificationFunctions.save(n.get(i));
            i++;
        }*/
        this.formattedNotificationFunctions.saveAll(f);
    }
    public FormattedNotification get(int notificationID){
        //return templates.get(templateID);
        int i = notificationID-1;
        List<FormattedNotification> f = this.formattedNotificationFunctions.findAll();
        FormattedNotification notification = f.get(i);
        return notification;

    }
}
