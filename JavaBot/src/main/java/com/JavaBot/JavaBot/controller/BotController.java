package com.JavaBot.JavaBot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JavaBot.JavaBot.dto.ChatGptRequest;
import com.JavaBot.JavaBot.dto.ChatGptResponse;

@RestController
@RequestMapping("/bot")
public class BotController {
	
	@Value("${openai.model}")
	private String model;
	
	@Value(("${openai.model}"))
	private String apiURL;
	
 @GetMapping("/chat")
public String chat(@RequestParam("prompt")String prompt) {
	ChatGptRequest = new ChatGptRequest(model, prompt);
Template.postForObject("apiURL",request,ChatGptResponse.class);
return ChatGptResponse.getChoices().get(0).getMessages().getContent();
		

}
}
