package com.revature.project.model.client;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.project.controller.LibraryController;
import com.revature.project.exceptions.InvalidException;
import com.revature.project.model.LibraryManagement.Library;

public class MainLib 
{
	public static void main(String[] args) throws InvalidException,Exception
	{
		Logger logger=Logger.getLogger("MainLib.class");
		Scanner scanner=new Scanner(System.in);
		String user=new String();
		String pass=new String();
		LibraryController libraryController=new LibraryController();
		logger.info("In LibraryManagement----Admin Login");
		System.out.println("------LIBRARY MANAGEMENT SYSTEM--------");
		System.out.println("\n-----------Admin login-----------");
		System.out.println("Enter admin id");
		user=scanner.nextLine();
		System.out.println("Enter admin pass");
		pass=scanner.nextLine();
		
		logger.info("To checkadmin method....");
		libraryController.checkAdmin(user,pass);
		//boolean s=true;
		
		while(true)
		{
		System.out.println("\nThe functions that can do by admin\n0 To Exit\n1 UsersDetails\n2 BooksDetails\n3 IssueBook");
		int adminChoice=scanner.nextInt();
		switch(adminChoice)
		{
			case 0:
			{
				System.out.println("You were logged out");
				System.exit(0);
				break;
			}
			case 1:
			{
				userUpdate u=new userUpdate();
				u.users(libraryController);	
				break;
			}
			
			case 2:
			{
				BookDetails b=new BookDetails();
				b.books(libraryController);
				break;
			}			
			case 3:
			{
				libraryController.issueBook();
				break;
			}
		
			default:
			{
				throw new InvalidException("Choose valid choice!!");
			}
		}
		}

}
}