package com.sgic.java.util;

import com.sun.source.tree.TryTree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment2 {
	public static String checkValidEmail(String email) {
		String emailPattern = "[^a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(email);

		if (!matcher.matches()) {
			return "Email is invalid";

		} else {
			return "Email is valid";
		}
	}

	public static String changeNullToString(String input) {
		return input == null ? "" : input;
	}

	public static String convertStringToDate(String dateInput) throws ParseException {
		SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

		Date date = inputFormat.parse(dateInput);

		String formattedDate = outputFormat.format(date);

		return formattedDate;
	}

	public static <E extends Number> E addNumbers(E num1, E num2){
		if (num1 instanceof Integer) {
			return (E) Integer.valueOf(num1.intValue() + num2.intValue());
		} else if (num1 instanceof Double) {
			return (E) Double.valueOf(num1.doubleValue() + num2.doubleValue());
		} else if (num1 instanceof Float) {
			return (E) Float.valueOf(num1.floatValue() + num2.floatValue());
		} else if (num1 instanceof Long) {
			return (E) Long.valueOf(num1.longValue() + num2.longValue());
		} else {
			throw new IllegalArgumentException("Unsupported numeric type");
		}
	}

	public static void main(String[] args){
			Scanner input = new Scanner(System.in);
			System.out.println("Enter your Email :");
			String email = input.nextLine();
			String result = checkValidEmail(email);
			System.out.println(result);

			System.out.println("Enter any argument1 :");
			String argument1 = input.nextLine();
			System.out.println("Enter any argument2 :");
			String argument2 = input.nextLine();
			System.out.println("Result1: " + changeNullToString(argument1));
			System.out.println("Result2: " + changeNullToString(argument2));

			try {
				System.out.println("Enter a Date in format MM/dd/yyyy :");
				String dateInput = input.nextLine();
				String convertedDate = convertStringToDate(dateInput);

				System.out.println(dateInput);
				System.out.println(convertedDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}


			int resultInt = addNumbers(10, 25);
			double resultDouble = addNumbers(3.4, 2.8);
			float resultFloat = addNumbers(8.0f, 5.5f);

			System.out.println("Integer Result: " + resultInt);
			System.out.println("Double Result: " + resultDouble);
			System.out.println("Float Result: " + resultFloat);

	}
}