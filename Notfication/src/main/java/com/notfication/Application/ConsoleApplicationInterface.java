package com.notfication.Application;

import com.notfication.model.FormattedNotification;
import com.notfication.model.NotificationTemplate;
import com.notfication.repo.FormattedNotificationFunctions;
import com.notfication.services.FormattedNotificationServices;
import com.notfication.services.NotificationTemplateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ConsoleApplicationInterface {
    FormattedNotificationFunctions formattedNotificationFunctions = null;
    FormattedNotificationServices notificationServices = null;
    NotificationTemplateServices templateServices = null;
    int doneEmails =0;
    int doneSMS=0;
    @Autowired
    public void ConsoleApplicationImplementation(@Qualifier("finalRepo") FormattedNotificationFunctions formattedNotificationFunctions,
                                                 @RequestBody FormattedNotificationServices notificationServices,
                                                 @RequestBody  NotificationTemplateServices templateServices);
    public void ConsoleApplicationImplementation();
    public void printMenu();
    public List<NotificationTemplate> getAllConfirm(List<NotificationTemplate> allTemplates);
    public List<NotificationTemplate> getAllBooking(List<NotificationTemplate> allTemplates);
    public List<NotificationTemplate> getAllForgetPassword(List<NotificationTemplate> allTemplates);

    public List<FormattedNotification> getAllEmails(List<FormattedNotification> allNotifications);
    public List<FormattedNotification> getAllSms(List<FormattedNotification> allNotifications);
}


