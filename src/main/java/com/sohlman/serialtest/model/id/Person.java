package com.sohlman.serialtest.model.id;

import java.io.Serializable;

import com.sohlman.serialtest.model.PersonInterface;

public class Person implements PersonInterface, Serializable{
	private static final long serialVersionUID = 1847007075949612099L;
	public Person(String firstName, String lastName) {
		_firstName = firstName;
		_lastName = lastName;
	}
	
	public String toString() {
		return String.format("Name: %s %s", _firstName, _lastName);
	}
	
	private String _firstName;
	private String _lastName;
}
