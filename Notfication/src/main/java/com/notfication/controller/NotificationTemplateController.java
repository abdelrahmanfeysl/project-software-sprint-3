package com.notfication.controller;

import com.notfication.model.NotificationTemplate;


import java.util.List;


//import com.notfication.repo.NotificationFunctionsImplementation;

import com.notfication.services.NotificationTemplateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api/notificationTemplate")
@RestController

public class NotificationTemplateController {

	NotificationTemplateServices notifyImplementation;
	@Autowired
	public NotificationTemplateController(@RequestBody NotificationTemplateServices notifyImplementation) {
		this.notifyImplementation = notifyImplementation;
	}
	@GetMapping
	public List<NotificationTemplate> getAll(){
		return notifyImplementation.getAllTemplates();
	}

	@PostMapping
	public void add(@RequestBody NotificationTemplate notificationTemplate){
		notifyImplementation.addTemplate(notificationTemplate);
	}

	@GetMapping(path = "{id}")
	public NotificationTemplate getById(@PathVariable("id") int id)
	{
		return notifyImplementation.getTemplate(id);
	}


	@DeleteMapping(path = "{id}")
	public void deleteById(@PathVariable("id") int id)
	{
		notifyImplementation.deleteTemplate(id);
	}


	@PutMapping(path = "{id}")
	public void update(@PathVariable("id") int id, @RequestBody NotificationTemplate notificationTemplate){
		notifyImplementation.updateTemplate(id,notificationTemplate);
	}
	/*private final NotificationFunctionsImplementation notifyImplementation;
	@Autowired
	public NotificationController(@RequestBody NotificationFunctionsImplementation notifyImplementation) {
		this.notifyImplementation = notifyImplementation;
	}
	@GetMapping
	public List<NotificationTemplate> getAll(){
		return notifyImplementation.getAll();

	}

	@PostMapping
	public void add(@RequestBody NotificationTemplate notificationTemplate){
		notifyImplementation.addTemplate(notificationTemplate);
	}

	@GetMapping(path = "{id}")
	public NotificationTemplate getById(@PathVariable("id") int id)
	{
		return notifyImplementation.getTemplate(id);
	}


	@DeleteMapping(path = "{id}")
	public void deleteById(@PathVariable("id") int id)
	{
		notifyImplementation.deleteTemplate(id);
	}


	@PutMapping(path = "{id}")
	public void update(@PathVariable("id") int id, @RequestBody NotificationTemplate newNotfi){
		notifyImplementation.updateTemplate(newNotfi);
	}*/
}
