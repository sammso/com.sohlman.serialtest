package com.sohlman.serialtest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.sohlman.serialtest.model.PersonInterface;

public class Main {
	public static void main(String[] args) {
		
		if (args.length==5) {
			if (args[0].equalsIgnoreCase("write")) {
				String type = args[1];
				String fileNameAndPath=args[2];
				String firstName=args[3];
				String lastName=args[4];
				
				PersonInterface person = create(type, firstName, lastName);
				
				if (person!=null) {
					writePerson(person, fileNameAndPath);
				}		
			}
		}
		else if (args.length==2) {
			if (args[0].equalsIgnoreCase("read")) {
				String fileNameANdPath=args[1];
				
				System.out.println(readPerson(fileNameANdPath));	
			}			
		}
	}

	private static void writePerson(PersonInterface person, String fileName) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(fileName);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(person);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (Exception ex) {
					// Ignore
				}

			}
		}
	}

	private static PersonInterface readPerson(String fileName) {
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		PersonInterface person = null;
		try {
			fileInputStream = new FileInputStream(fileName);
			objectInputStream = new ObjectInputStream(fileInputStream);
			person = (PersonInterface)objectInputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (Exception ex) {
					// Ignore
				}
			}
		}
		return person;
	}
	
	private static PersonInterface create(String type, String firstName, String lastName) {
		
		Class<?> clazz;
		try {
			clazz = Class.forName(String.format("com.sohlman.serialtest.model.%s.Person", type));
			Constructor<?> constructor = clazz.getConstructor(String.class, String.class);
			return (PersonInterface)constructor.newInstance(firstName,lastName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
