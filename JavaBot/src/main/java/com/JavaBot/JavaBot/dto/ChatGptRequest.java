package com.JavaBot.JavaBot.dto;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;
 
import lombok.Data;


@Data
public class ChatGptRequest {
private String model;
private List<Message> messages;
public ChatGptRequest(String model, String prompt) {
	
	this.model = model;
	this.messages = new ArrayList<>();
	this.messages.add(new Message("user", prompt));
}


}
