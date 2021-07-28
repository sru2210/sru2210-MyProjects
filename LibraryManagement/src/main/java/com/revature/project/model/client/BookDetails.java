package com.revature.project.model.client;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.project.controller.LibraryController;
import com.revature.project.model.LibraryManagement.Library;
import com.revature.project.model.LibraryManagement.Users;


public class BookDetails
{
	Logger logger=Logger.getLogger("BookDetails.class");
	static List<Long>listofIsbn=new ArrayList<Long>();
	public void books(LibraryController libraryController) throws Exception
	{
		logger.info("In BookDetails----");
		Scanner sc=new Scanner(System.in);
		System.out.println();
		boolean s=true;
		
		while(s)
		{
			System.out.println("\n\n=======Book Details=======");
			System.out.println("0 back To Main Application\n1 To addBook\n2 To deleteBook\n3 List OfBook\n4 To updateBook\n5 To list details of particular books");
			List<Library>listBooks=new ArrayList<Library>();
			int adminChoice=sc.nextInt();
			switch(adminChoice)
			{
				case 1:
				{
					System.out.println("Enter book details - isbn,title,author,price");
					Library library=new Library();
					long isbn=sc.nextLong();
					sc.nextLine();
					String title=sc.nextLine();;
					String author=sc.nextLine();;
					int price=sc.nextInt();
					library.setIsbn(isbn);
					library.setTitle(title);
					library.setAuthor(author);
					library.setPrice(price);
					logger.info("In BookDetails----addBook method");
					libraryController.addBook(library);
					break;
				}
		
				case 2:
				{
					logger.info("In BookDetails----deleteBook method");
					libraryController.delBook();
					break;
				}
				case 3:
				{
					logger.info("In BookDetails----listBooks method");
					listBooks=libraryController.listBooks();
					System.out.println(listBooks);
					for(int i=0;i<listBooks.size();i++)
					{
						listofIsbn.add(listBooks.get(i).getIsbn());
					}
					break;
				}
				case 4:
				{
					logger.info("In BookDetails----updateBook method");
					libraryController.updateBook();
					break;
				}
				case 5:
				{
					logger.info("In BookDetails----listBookByIsbn method");
					Library book=new Library();
					book=libraryController.listBookByIsbn(listofIsbn);
					System.out.println(book);
					break;
				}
				case 0:
				{
					logger.info("In BookDetails----Directing to Main Application");
					System.out.println("Directing to Main Application");
					s=false;
					break;
				}
				}
		}
			
	
	}

}
