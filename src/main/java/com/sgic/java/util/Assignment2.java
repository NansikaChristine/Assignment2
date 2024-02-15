package com.sgic.java.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment2 {
	public static @NotNull String checkValidEmail(String email){
		String emailPattern = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(email);

		if(!matcher.matches()){
			return "Email is invalid";}
		else {
			return "Email is valid";
		}
	}
	@Contract(value = "!null -> param1", pure = true)
	public static @NotNull String changeNullToString(String input) {
		return input == null ? "": input ;
	}
	public static Date convertStringToDate(String date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try{
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
        }

    }
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your Email :");
		String email = input.nextLine();
		String result = checkValidEmail(email);
		System.out.println(result);

		System.out.println("Enter any argument1 :");
		String argument1 = input.nextLine();
		System.out.println("Enter any argument2 :");
		String argument2 = input.nextLine();
		argument1 = changeNullToString(argument1);
		System.out.println("Result1: " + argument1);
		argument2 = changeNullToString(argument2);
		System.out.println("Result2: " + argument2);

		System.out.println("Enter a Valid String Date:");
		String dateInput = input.nextLine();
		Date convertDateFormat = convertStringToDate(dateInput);
		if (convertDateFormat != null) {
			System.out.println("Converted Date: " + convertDateFormat);
		} else {
			System.out.println("Error converting the date.");
		}
    }
}