package com.notfication.services;

import com.notfication.model.NotificationTemplate;
import com.notfication.repo.NotificationTemplateFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationTemplateServices {


    NotificationTemplateFunctions notificationTemplateFunctions;
    @Autowired
    public NotificationTemplateServices(@Qualifier("repo") NotificationTemplateFunctions notificationTemplateFunctions) {
        this.notificationTemplateFunctions = notificationTemplateFunctions;
    }
    public NotificationTemplateServices() {

    }

    public List<NotificationTemplate> getAllTemplates(){
        //return templates;
        List<NotificationTemplate> n= this.notificationTemplateFunctions.findAll();
        return n;
    }
    public void addTemplate(NotificationTemplate template){
       //templates.add(template);
       this.notificationTemplateFunctions.save(template);
    }
    public void deleteTemplate(int templateID){

        //templates.remove(templateID);
        this.notificationTemplateFunctions.deleteById(templateID);
    }
    public void updateTemplate(int templateID,NotificationTemplate template){

        List<NotificationTemplate> n= this.notificationTemplateFunctions.findAll();
        this.notificationTemplateFunctions.deleteAll();
        n.remove(templateID);
        n.add(templateID,template);
        /*int i=0;
        while (n.size()!= 0){
            this.notificationFunctions.save(n.get(i));
            i++;
        }*/
        this.notificationTemplateFunctions.saveAll(n);
    }
    public NotificationTemplate getTemplate(int templateID){
        //return templates.get(templateID);
        int i = templateID-1;
        List<NotificationTemplate> n= this.notificationTemplateFunctions.findAll();
        NotificationTemplate temp = n.get(i);
        return temp;

    }

    /*
    private final NotificationFunctions notificationFunctions;

    @Autowired
    public NotificationServices(@Qualifier("NotificationRepo") NotificationFunctions notificationFunctions) {
        this.notificationFunctions = notificationFunctions;
    }
    public void add(NotificationTemplate template){
        notificationFunctions.addTemplate(template);
    }
    public void delete(int templateID){
        notificationFunctions.deleteTemplate(templateID);
    }
    public void update(NotificationTemplate template){
        notificationFunctions.updateTemplate(template);
    }
    public NotificationTemplate get(int templateID){
        return notificationFunctions.getTemplate(templateID);
    }
    public List<NotificationTemplate> getAllTemplates(){
        return notificationFunctions.getAll();
    }*/

}
