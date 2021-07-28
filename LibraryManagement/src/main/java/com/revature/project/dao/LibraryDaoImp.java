package com.revature.project.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.project.DBUtil.DBUtil;
import com.revature.project.exceptions.InvalidException;
import com.revature.project.exceptions.InvalidIsbnException;
import com.revature.project.exceptions.InvalidUserException;
import com.revature.project.model.LibraryManagement.Library;
import com.revature.project.model.LibraryManagement.Users;

public class LibraryDaoImp implements LibraryDao 
{
	Logger logger=Logger.getLogger("LibraryDaoImp.class");
	Scanner sc=new Scanner(System.in);
	public void addBook(Library library) throws Exception
	{
		logger.info("In LibraryDaoImp----addBook method");
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=con.prepareStatement("insert into book values(?,?,?,?)");
		if(library.getIsbn()>10000)
		{
		pst.setLong(1, library.getIsbn());
		pst.setString(2, library.getTitle());
		pst.setString(3, library.getAuthor());
		pst.setInt(4, library.getPrice());
		pst.execute();
		System.out.println("Book is added to the stock");
		}
		else
		{
			throw new InvalidIsbnException("Enter valid Isbn number of book");
		}
	} 
	public void checkAdmin(String user,String pass) throws Exception
	{
		logger.info("In LibraryDaoImp----checkAdmin method");
		Connection con=DBUtil.getConnection();
		Statement st = con.createStatement();
		String query = ("select * from login");
		String user1=new String();
		String pass1=new String();
		ResultSet rs = st.executeQuery(query);
		if(rs.next()) 
		{ 
		 user1= rs.getString("user"); 
		 pass1 = rs.getString("pass");
		}
		if(user.equals(user1)&&pass.equals(pass1))
		{
			System.out.println("Admin Logged in Successfully");
		}
		else
		{
			throw new InvalidException("Enter valid id or pass!!");
		}
	}
	
	public void addUser() throws InvalidUserException,Exception
	{
		logger.info("In LibraryDaoImp----addUser(insert) method");
		Connection con=DBUtil.getConnection();
		System.out.println("========Add new user========");
		System.out.println("Enter user id");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter user name");
		String name=sc.nextLine();
		System.out.println("Enter user email id");
		String email=sc.nextLine();
		System.out.println("Enter user phnNo");
		long phnNo=sc.nextLong();
		if(id>0&&name!=null)
		{
		String query="insert into user values(?,?,?,?)";
		PreparedStatement preparedStatement=con.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, email);
		preparedStatement.setLong(4, phnNo);
		preparedStatement.execute();
		System.out.println("User added successfully...");
		}
		else 
		{
			throw new InvalidUserException("Enter valid id and name of the user");
		}
	}
	
	
	public void deleteUser() throws InvalidException,Exception
	{
		logger.info("In LibraryDaoImp----deleteUser method");
		Connection con=DBUtil.getConnection();
		System.out.println("\nEnter the user's id to delete");
		int userId=sc.nextInt();
		String query="delete from user where id="+userId;
		PreparedStatement preparedStatement=con.prepareStatement(query);
		boolean b=preparedStatement.execute();
			System.out.println("Successfully user deleted");
		
	}
	
	public void updateUser() throws InvalidException,Exception
	{
		logger.info("In LibraryDaoImp----UpdateUser method");
		Connection con=DBUtil.getConnection();
		System.out.println("\nEnter the attribute to update \n1 userName\n2 emailId\n3 phnNo");
		int adminChoice=sc.nextInt();
		System.out.println("Enter the user's id to update");
		int id=sc.nextInt();
		if(adminChoice==1)
		{
			System.out.println("Enter new name to update");
			sc.nextLine();
			String newName=sc.nextLine();
			String query="update user set name=? where id=?";
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1, newName);
			preparedStatement.setInt(2, id);
			int executeResult=preparedStatement.executeUpdate();
			if(executeResult>0)
				System.out.println("User's name is updated");
			else
				System.out.println("Invalid id!!");
		}
		if(adminChoice==2)
		{
			System.out.println("Enter new emailId to update");
			sc.nextLine();
			String newEmailId=sc.nextLine();
			String query="update user set email=? where id=?";
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1, newEmailId);
			preparedStatement.setInt(2, id);
			int executeResult=preparedStatement.executeUpdate();
			if(executeResult>0)
				System.out.println("Email Id is updated");
			else
				System.out.println("Invalid user id!!");
		}
		if(adminChoice==3)
		{
			System.out.println("Enter new phnNo to update");
			sc.nextLine();
			String newPhnNo=sc.nextLine();
			String query="update user set phnNo=? where id=?";
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1, newPhnNo);
			preparedStatement.setInt(2, id);
			int executeResult=preparedStatement.executeUpdate();
			if(executeResult>0)
				System.out.println("Phone Number is updated");
			else
				System.out.println("Invalid user id!!");
		}
		
	}
	
	public Users listByUserId(List listofId) throws InvalidException,Exception
	{
		logger.info("In LibraryDaoImp----listByUserId method");
		Users user=new Users();
		Connection con=DBUtil.getConnection();
		Statement st=con.createStatement();
			System.out.println("Enter the id of user");
			int userId=sc.nextInt();
			if(!listofId.contains(userId))
			{
			String query="select * from user where id="+userId;
			PreparedStatement preparedStatement=con.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery(query);
			while(resultSet.next())
			{
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmailId(resultSet.getString(3));
				user.setPhnNo(resultSet.getLong(4));
			}
			}
			else
				throw new InvalidException("Enter valid ID..Entered Id is not registered");
			return user;
		}
		
	
	public List<Users> listAll() throws InvalidException,Exception
	{
		logger.info("In LibraryDaoImp----listUsers method");
		Connection con=DBUtil.getConnection();
		List<Users>listUsers=new ArrayList<Users>();
			

		Statement st=con.createStatement();
		String query="select * from user";
		ResultSet resultSet=st.executeQuery(query);
		System.out.println("The list of users are");
		int i=0;
		while(resultSet.next())
		{
			Users user=new Users();
			user.setId(resultSet.getInt(1));
			user.setName(resultSet.getString(2));
			user.setEmailId(resultSet.getString(3));
			user.setPhnNo(resultSet.getLong(4));
			logger.info("resultSet...in list of users");
			listUsers.add(user);
		}
		
		return listUsers;
	}
	
	public void bkDetails() throws InvalidException,Exception
	{
		logger.info("In LibraryDaoImp----bkDetails method");
		Connection con=DBUtil.getConnection();
		System.out.println("\nEnter the user's id to get the details of book borrowed");
		int userId=sc.nextInt();
		String query="select u.name,u.email,i.isbn,i.issuedate,i.returndate from user u join issuebk i on u.id=i.id where u.id=?";
		
		PreparedStatement preparedStatement=con.prepareStatement(query);
		preparedStatement.setInt(1,userId);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			System.out.println("\nUser name: "+resultSet.getString(1));
			System.out.println("User email:"+resultSet.getString(2));
			System.out.println("Book IsbnNo:"+resultSet.getLong(3));
			System.out.println("Issue Date:"+resultSet.getString(4));
			System.out.println("Return Date:"+resultSet.getString(5));
		}
	}
	
	public void delBook() throws InvalidException,Exception
	{
		logger.info("In LibraryDaoImp----delBook method");
		Connection con=DBUtil.getConnection();
		System.out.println();
		System.out.println("Enter the book's isbn to delete");
		long p=sc.nextLong();
		String query="delete from book where isbn="+p;
		PreparedStatement preparedStatement=con.prepareStatement(query);
		int executeResult=preparedStatement.executeUpdate();
		if(executeResult>0)
			System.out.println("Selected book is deleted");
		else
			throw new InvalidException("Book is not deleted...Error!!");
	}
	public List<Library> listBooks() throws InvalidException,Exception
	{
		logger.info("In LibraryDaoImp----listBooks method");
		Connection con=DBUtil.getConnection();
		List<Library>listBooks=new ArrayList<Library>();
			

		Statement st=con.createStatement();
		String query="select * from book";
		ResultSet resultSet=st.executeQuery(query);
		System.out.println("The list of books are");
		int i=0;
		while(resultSet.next())
		{
			Library library=new Library();
			library.setIsbn(resultSet.getLong(1));
			library.setTitle(resultSet.getString(2));
			library.setAuthor(resultSet.getString(3));
			library.setPrice(resultSet.getInt(4));
			listBooks.add(library);
		}
		
		return listBooks;
	}
	
	
	public Library listBookByIsbn(List listofIsbn) throws InvalidException,Exception
	{
		logger.info("In LibraryDaoImp----listBookByIsbn method");
		Library library=new Library();
		Connection con=DBUtil.getConnection();
		Statement st=con.createStatement();
			System.out.println("Enter book isbn");
			long isbn=sc.nextLong();
			if(!listofIsbn.contains(isbn))
			{
			String query="select isbn,title,author,price from book where isbn="+isbn;
			PreparedStatement preparedStatement=con.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery(query);
			while(resultSet.next())
			{
				library.setIsbn(resultSet.getLong(1));
				library.setTitle(resultSet.getString(2));
				library.setAuthor(resultSet.getString(3));
				library.setPrice(resultSet.getInt(4));
			}
			}
			else
				throw new InvalidException("Enter valid Isbn of book...Entered number is not present");
			return library;
		}
	
	public void issueBook() throws InvalidException,Exception
	{
		logger.info("In LibraryDaoImp----issueBook method");
		LocalDate issue=java.time.LocalDate.now();
		LocalDate retur= issue.plusDays(15);
		String issueDate=issue.toString();
		String returnDate=retur.toString();
		Connection con=DBUtil.getConnection();
		System.out.println();
		System.out.println("Enter the isbn number of book borrowed by user");
		long isbn=sc.nextLong();
		sc.nextLine();
		System.out.println("Enter the user id");
		int id=sc.nextInt();;
				String query="insert into issuebk values(?,?,?,?)";
				PreparedStatement preparedStatement=con.prepareStatement(query);
				preparedStatement.setLong(1,isbn);
				preparedStatement.setInt(2,id);
				preparedStatement.setString(3,issueDate);
				preparedStatement.setString(4,returnDate);
				preparedStatement.execute();
				System.out.println("Book issued");
				System.out.println("And details are\nUserId is"+id+"\nIssue date is "+issueDate+"\nReturn date is "+returnDate);				
		}
		
	public void updateBook() throws InvalidException,Exception
	{
		logger.info("In LibraryDaoImp----updateBook method");
		Connection con=DBUtil.getConnection();
		System.out.println("\nEnter the attribute to update \n1 BookName\n2 Author");
		int adminChoice=sc.nextInt();
		System.out.println("Enter the book's isbn to update");
		int isbn=sc.nextInt();
		if(adminChoice==1)
		{
			System.out.println("Enter correct title to update");
			sc.nextLine();
			String updateTitle=sc.nextLine();
			String query="update user set title=? where isbn=?";
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1, updateTitle);
			preparedStatement.setInt(2, isbn);
			int executeResult=preparedStatement.executeUpdate();
			if(executeResult>0)
				System.out.println("Title of book is updated");
			else
				System.out.println("Invalid isbn!!");
		}
		if(adminChoice==2)
		{
			System.out.println("Enter correct authors to update");
			sc.nextLine();
			String updateAuthor=sc.nextLine();
			String query="update user set author=? where isbn=?";
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1, updateAuthor);
			preparedStatement.setInt(2, isbn);
			int executeResult=preparedStatement.executeUpdate();
			if(executeResult>0)
				System.out.println("Author of book is updated");
			else
				System.out.println("Invalid isbn!!");
		}
		
		
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


