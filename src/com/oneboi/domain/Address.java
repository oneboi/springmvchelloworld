package com.oneboi.domain;

import java.io.Serializable;

public class Address  implements  Serializable{
 
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Address [text=" + text + "]";
	}
	
	
}
