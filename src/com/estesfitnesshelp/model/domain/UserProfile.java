
package com.estesfitnesshelp.model.domain;

import java.io.Serializable;
/*
 * class UserProfile holds the initial information for the user
 * 
 * @author: Will Estes
 */
public class UserProfile implements Serializable{
	
	/*Serializable - Using the default serialVersionUID*/
	private static final long serialVersionUID = -7276827824157887422L;	
	/*User ID*/
	private int userNumber;       
	/*Select User Name*/
	private String userName;      
	/*User Password*/
	private String password;      
	/*Age of user*/
	private int age;              
	/*Email Address*/
	private String emailAddress;  
	/*height in inches*/
	private double height;        
	/*weight in pounds*/
	private double weight;        

	/*Constructor*/
	public UserProfile(String userName, String password, int age, String emailAddress,
			double height, double weight){
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.emailAddress = emailAddress;
		this.height = height;
		this.weight = weight;
	}
	
	/*Gets the user number
	 * @return userNumber*/
	public int getUserNumber() {
		return userNumber;
	}
	
	/*Gets the user name
	 * @return userName*/
	public String getUserName() {
		return userName;
	}

	/*Sets the userName
	 * @param userName  the userName desired*/
	public void setUserName(String userName) {
		this.userName = userName;
		System.out.println("User Name set to " + userName);
	}

	/*Gets the password of the user
	 * @return password*/
	public String getPassword() {
		return password;
	}

	/*Sets the password of the user
	 * @param password  desired password*/
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*Gets the age of the user
	 * @return age*/
	public int getAge() {
		return age;
	}

	/*Sets the age of the user
	 * @param age  age of the user*/
	public void setAge(int age) {
		this.age = age;
		System.out.println("Age set to " + age);
	}

	/*Gets the email address
	 * @return emailAddress*/
	public String getEmailAddress() {
		return emailAddress;
	}

	/*Sets the email address of the user
	 * @param emailAddress  Email of the user*/
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("Email Address set to " + emailAddress);
	}

	/*Gets the height of the user
	 * @return height*/
	public double getHeight() {
		return height;
	}

	/*Set the height of the user
	 * @param height  Height of the user*/
	public void setHeight(double height) {
		this.height = height;
		System.out.println("Height set to " + height);
	}

	/*Get the weight of the user
	 * @return weight*/
	public double getWeight() {
		return weight;
	}

	/*Set the weight of the user
	 * @param weight  Weight of the user*/
	public void setWeight(double weight) {
		this.weight = weight;
		System.out.println("Weight set to " + weight);
	}
	
	/*Validates that the info entered is valid
	 * @return   true if valid, false otherwise*/
	public boolean validate() {
		if(userName == null) return false;
		if(age <= 0 || age >= 150) return false;
		if(emailAddress == null) return false;
		if(height <= 0 || height >= 96) return false;
		if(weight <= 0 || weight >= 1000.0) return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	public String toString()
	{
	  StringBuffer strBfr = new StringBuffer();
	  strBfr.append("Username :");
	  strBfr.append(userName);
	  strBfr.append("\nEmailAddress :");
	  strBfr.append(emailAddress);
	  strBfr.append("\nAge :");
	  strBfr.append(age);
	  strBfr.append("\nHeight :");
	  strBfr.append(height);
	  strBfr.append("\nWeight :");
	  strBfr.append(weight);
	
	  return strBfr.toString();
	}	
	
} //End UserProfile
