package com.revature.project.controller;
import com.revature.project.model.LibraryManagement.Users;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.product.service.LibraryService;
import com.revature.product.service.LibraryServiceImp;
import com.revature.project.exceptions.InvalidException;
import com.revature.project.model.LibraryManagement.Library;
import com.revature.project.model.LibraryManagement.Users;

public class LibraryController
{
	Logger logger=Logger.getLogger("LibraryController.class");
	LibraryService libraryServiceImp=new LibraryServiceImp();
	 public void addBook(Library library) throws Exception
	 {
		 logger.info("In LibraryController----addBook method");
			libraryServiceImp.addBook(library);
	 }
	 public void checkAdmin(String user,String pass) throws Exception
	 {
		 logger.info("In LibraryController----checkAdmin method");
		 libraryServiceImp.checkAdmin(user, pass);
	  }
	 public void addUser() throws Exception
	 {
		 logger.info("In LibraryController----addUser method");
		libraryServiceImp.addUser();
	  }
	 public void deleteUser() throws InvalidException,Exception
	 {
		 logger.info("In LibraryController----deleteUser method");
		libraryServiceImp.deleteUser();
	  }
	 public void updateUser() throws Exception
	 {
		 logger.info("In LibraryController----updateUser method");
		 libraryServiceImp.updateUser();
	 }
	 public List<Users> listAll() throws Exception
	 {
		 logger.info("In LibraryController----ListallUsers method");
		 List<Users>listUsers=new ArrayList<Users>();
		listUsers=libraryServiceImp.listAll();
		return listUsers;
	  }
	 public Library listBookByIsbn(List listofIsbn) throws Exception
	 {
		 logger.info("In LibraryController----ListBookByIsbn method");
		 Library book=new Library();
		 book=libraryServiceImp.listBookByIsbn(listofIsbn);
		 return book;
	 }
	 public void bkDetails() throws Exception
	 {
		 logger.info("In LibraryController----Details of books method");
		 libraryServiceImp.bkDetails();
	 }
	 public  void delBook() throws Exception
	 {
		 logger.info("In LibraryController----delBook method");
			libraryServiceImp.delBook();
	 }
	 public  Users listByUserId(List listofId) throws Exception
	 {
		 logger.info("In LibraryController----listByUserId method");
		Users user=new Users();	
		 user=libraryServiceImp.listByUserId(listofId);
		 return user;
	 }
	 public List<Library> listBooks() throws Exception
	 {
		 logger.info("In libraryServiceImp-----listBooks method");
		 List<Library>listBooks=new ArrayList<Library>();
			listBooks=libraryServiceImp.listBooks();
			return listBooks;

	 }
	 public  void issueBook() throws Exception
	 {
		 logger.info("In LibraryController----issueBook method");
			libraryServiceImp.issueBook();
	 }
	 public void updateBook() throws Exception
	 {
		 logger.info("In LibraryController----updateBook method");
		 libraryServiceImp.updateBook();
	 }
	 
}




