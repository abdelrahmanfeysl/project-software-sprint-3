package com.notfication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FormattedNotfication")
public class FormattedNotification {
    @Id
    public  int id;
    @Column(name = "templateID")
    public int templateID;
    @Column(name = "content")
    public String formattedContent;
    @Column(name = "channel")
    public String channel;
    @Column(name = "ph1")
    public String placeholder1;
    @Column(name = "ph2")
    public String placeholder2;


    public FormattedNotification(@JsonProperty("id")int id,
                                 @JsonProperty("templateID")int templateID,
                                 @JsonProperty("channel")String channel,
                                 /*@JsonProperty("content")String formattedContent,*/
                                 @JsonProperty("ph1")String placeholder1,
                                 @JsonProperty("ph2")String placeholder2) {
        this.id = id;
        this.templateID = templateID;
        this.channel = channel;
        /*this.formattedContent=formattedContent;*/
        this.placeholder1 = placeholder1;
        this.placeholder2 = placeholder2;

    }

    public FormattedNotification() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemplateID() {
        return templateID;
    }

    public void setTemplateID(int templateID) {
        this.templateID = templateID;
    }

    public String getFormattedContent() {
        return formattedContent;
    }

    public void setFormattedContent(String formattedContent) {
        this.formattedContent = formattedContent;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPlaceholder1() {
        return placeholder1;
    }

    public void setPlaceholder1(String placeholder1) {
        this.placeholder1 = placeholder1;
    }

    public String getPlaceholder2() {
        return placeholder2;
    }

    public void setPlaceholder2(String placeholder2) {
        this.placeholder2 = placeholder2;
    }

    @Override
    public String toString() {
        return "FormattedNotification : \n" +
                "id : " + id + "\n" +
                "templateID : " + templateID  + "\n" +
                "formattedContent : " + formattedContent + "\n"+
                "channel : " + channel + "\n" +
                "placeholder1 : " + placeholder1 + "\n" +
                "placeholder2 : " + placeholder2 + "\n";
    }
}
