package com.revature.project.model.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.project.controller.LibraryController;
import com.revature.project.exceptions.InvalidException;
import com.revature.project.model.LibraryManagement.Users;

public class userUpdate
{
	Logger logger=Logger.getLogger("userUpdate.class");
	static List<Integer>listofId=new ArrayList<Integer>();
	public void users(LibraryController lc) throws InvalidException,Exception
	{
		logger.info("In userUpdate----");
		Scanner scanner=new Scanner(System.in);
		System.out.println();
		List<Users>listUsers=new ArrayList<Users>();
		boolean s=true;
		while(s)
		{
			System.out.println("\n\n=======User Details=======");
			System.out.println("0 Back To Main Application\n1 To addUser\n2 To deleteUser\n3 List OfUsers\n4 updateUser\n5 BooksDetails taken by user\n6 Details of particular User");
			int adminChoice=scanner.nextInt();
			switch(adminChoice)
			{
				case 1:
				{
					logger.info("In userUpdate----addUser method");
					lc.addUser();
					break;
				}
		
				case 2:
				{
					logger.info("In userUpdate----deleteUser method");
					lc.deleteUser();
					break;
				}
				case 3:
				{
					logger.info("In userUpdate----listOfUsers method");
					 listUsers=lc.listAll();
					//lc.listAll();
					System.out.println(listUsers);
					for(int i=0;i<listUsers.size();i++)
					{
						listofId.add(listUsers.get(i).getId());
					}
					break;
			
				}
				case 4:
				{
					logger.info("In userUpdate----Updateuser method");
					lc.updateUser();
					break;
				}
				case 5:
				{
					logger.info("In userUpdate----Details of book borrowed by student method");
					lc.bkDetails();
					break;
				}
				case 6:
				{
					Users user=new Users();
					logger.info("In userUpdate----Details of Particular user");
					user=lc.listByUserId(listofId);
					System.out.println(user);
					break;
				}
				case 0:
				{
					logger.info("In userUpdate----Directing to Main Application");
					System.out.println("Directing to Main Application");
					s=false;
					break;
				}
				
			}
		}
		}
}
