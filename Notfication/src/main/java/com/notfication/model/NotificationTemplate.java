package com.notfication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "NotficationTemplates")

public class NotificationTemplate{
@Id
//@GeneratedValue (strategy = GenerationType.SEQUENCE)
	public  int id;
    @Column(name = "Subject")
	public  String subject;
    @Column(name = "Content")
	public  String content;
    @Column(name = "Language")
	public  String language;
	@Column(name = "Type")
    public String type;



	public NotificationTemplate(int id,
								@JsonProperty("subject") String subject,
								@JsonProperty("content") String content,
								@JsonProperty("lang") String  language,
								@JsonProperty("type") String  type) {
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.language = language;
		this.type = type;

	}

	public NotificationTemplate() {

	}


	public int getId() {
		return this.id;
	}
	public String getSubject() {
		return this.subject;
	}
	public String getLanguage() {
		return this.language;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "NotificationTemplate :  \n" +
				"id : " + id + "\n" +
				"subject : " + subject + "\n" +
				"content : " + content + "\n" +
				"language : " + language + "\n" +
				"Type : " + type + "\n";
	}
}
