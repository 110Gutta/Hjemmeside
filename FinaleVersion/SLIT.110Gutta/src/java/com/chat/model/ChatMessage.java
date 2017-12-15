package com.chat.model;

//request -> message setting.
public class ChatMessage {
	private Request Request;
	private String message;

	public void setMessageType(Request v) {
		this.Request = v;
	}

	public Request getMessageType() {
		return Request;
	}

	public void setMessage(String v) {
		this.message = v;
	}

	public String getMessage() {
		return this.message;
	}
}
