package com.storware.calculator;

import com.storware.calculator.chat.UserChat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(CalculatorApplication.class, args);

		UserChat userChat = appContext.getBean(UserChat.class);
		userChat.start();
	}

}
