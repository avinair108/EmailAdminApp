package emailapp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String alternateEmail;
	// company can change these values as needed
	private int mailBoxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String companyTag = "examplecompany.com";

	// constructor for first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("EMAIL CREATED FOR: " + this.firstName + " " + this.lastName);

		// call method asking for department and return the department
		this.department = setDepartment();
		if (department == "")
		{
			System.out.println("No Department selected");
		}
		else {
			System.out.println("Selected Department is " + department);
		}
		
		// call method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("This is your generated password: " + this.password);
		
		// combine elements into an email
		if (this.department == "") {
			email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companyTag;
		}
		else {
			email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companyTag;
		}
		System.out.println("Your generated email is: " + email);
	}
	// ask for department
	private String setDepartment() {
		System.out.println("DEPARTMENT CODE NUMBERS\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code: ");
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		if (departmentChoice == 1) {
			return "sales";
		} else if (departmentChoice == 2) {
			return "dev";
		} else if (departmentChoice == 3) {
			return "acct";
		} else {
			return "";
		}
	}

	// generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int randomVal = (int) (Math.random() *passwordSet.length());
			password[i] = passwordSet.charAt(randomVal);
		}
		return new String(password);
	}

	// set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}

	// set alternate email
	public void setAlternateEmail(String alt) {
		this.alternateEmail = alt;
	}

	// change password
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
	
	// get methods for capacity, alternate email, and alt password
	public int getMailboxCapacity() {return mailBoxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	// display method
	public void showInfo() {
		System.out.println("\nEMPLOYEE NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nPASSWORD: " + password +
				"\nMAILBOX CAPACITY: " + mailBoxCapacity + " mb\n");
	}

}




