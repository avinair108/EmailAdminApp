package emailapp;

import java.util.Scanner;

public class EmailApp {

	public static void main(String[] args) {
		
		String userfirstName;
		String userlastName;
		
		Scanner input = new Scanner(System.in);
		
		// prompt user to enter first and last name
		System.out.println("Enter employee's first name:");
		userfirstName = input.nextLine();
		System.out.println("Enter employee's last name:");
		userlastName = input.nextLine();
		
		// clear spaces
		String firstName = userfirstName.replace(" ","");
		String lastName = userlastName.replace(" ","");
		
		// calls Email constructor
		Email a1 = new Email(firstName, lastName);
		
		// calls display method
		a1.showInfo();
		
		int menuChoice = 0;
		
		while (menuChoice !=3) {
			// prompt option to reset password or email
			System.out.println("Troubleshooting Menu\n--------------------\n1: Reset Password \n2: Reset Email \n3: Confirm Employee Details");
			
			menuChoice = input.nextInt();
			input.nextLine();
			
			if(menuChoice == 1) {
				System.out.println("Enter new password:");
				String changedPassword = input.nextLine();
				a1.changePassword(changedPassword);
				a1.showInfo();
			}else if(menuChoice == 2) {
				System.out.println("Enter new email:");
				String changedEmail = input.nextLine();
				a1.setAlternateEmail(changedEmail);
				a1.showInfo();
			}else {
				System.out.println("Employee account for " + firstName + " " + lastName + " has been successfully created.");
			}	
		}
		
	}

}
