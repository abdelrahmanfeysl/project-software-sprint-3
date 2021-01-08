package com.notfication;

//import com.notfication.repo.NotificationFunctionsImplementation;
import com.notfication.Application.ConsoleApplicationImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class NotificationApplication {
	private static ConsoleApplicationImplementation app;

@Autowired
	public NotificationApplication(@RequestBody ConsoleApplicationImplementation x) {
		this.app = x;
	}

	public static void main(String[] args) {

		SpringApplication.run(NotificationApplication.class, args);


		app.printMenu();

	}
	
}
