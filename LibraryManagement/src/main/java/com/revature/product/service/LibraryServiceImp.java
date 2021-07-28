package com.revature.product.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.project.dao.LibraryDao;
import com.revature.project.dao.LibraryDaoImp;
import com.revature.project.exceptions.InvalidException;
import com.revature.project.model.LibraryManagement.Library;
import com.revature.project.model.LibraryManagement.Users;

public class LibraryServiceImp implements LibraryService {

	Logger logger=Logger.getLogger("LibraryServiceImp.class");
	LibraryDao libraryDaoImp = new LibraryDaoImp();

	public void addBook(Library library) throws Exception {
		logger.info("In LibraryServiceImp----addBook method");
		libraryDaoImp.addBook(library);
	}

	public void delBook() throws Exception {
		logger.info("In LibraryServiceImp----delBook method");
		libraryDaoImp.delBook();
	}

	public Library listBookByIsbn(List listofIsbn) throws Exception {
		logger.info("In LibraryServiceImp----listBook method");
		Library book=new Library();
		book=libraryDaoImp.listBookByIsbn(listofIsbn);
		return book;
	}
	
	public List<Library> listBooks() throws Exception
	{
		logger.info("In LibraryServiceImp----listBooks method");
		List<Library>listBooks=new ArrayList<Library>();
		listBooks=libraryDaoImp.listBooks();
		return listBooks;
				
	}

	public void issueBook() throws Exception {
		logger.info("In LibraryServiceImp----issueBook method");
		libraryDaoImp.issueBook();
	}
	
	public void updateBook() throws Exception {
		logger.info("In LibraryServiceImp----updateBook method");
		libraryDaoImp.updateBook();
	}
	public void bkDetails() throws Exception {
		logger.info("In LibraryServiceImp----bkdetails method");
		libraryDaoImp.bkDetails();
	}


	public void checkAdmin(String user, String pass) throws Exception {
		logger.info("In LibraryServiceImp----checkAdmin method");
		libraryDaoImp.checkAdmin(user, pass);
	}
	public void deleteUser() throws InvalidException,Exception {
		logger.info("In LibraryServiceImp----delteUser method");
		 libraryDaoImp.deleteUser();
	
	}

	public void addUser() throws Exception {
		logger.info("In LibraryServiceImp----adduser(insert) method");
		libraryDaoImp.addUser();
	}

	public Users listByUserId(List listofId) throws Exception
	{
		Users user=new Users();
		logger.info("In LibraryServiceImp----listByUserId method");
		user=libraryDaoImp.listByUserId(listofId);
		return user;
	}
	public List<Users> listAll() throws Exception {
		logger.info("In LibraryServiceImp----listUsers method");
		List<Users>listUsers=new ArrayList<Users>();
		listUsers=libraryDaoImp.listAll();
		return listUsers;
	}
	
	public void updateUser() throws Exception {
		logger.info("In LibraryServiceImp----updateusers(update) method");
		libraryDaoImp.updateUser();
	}

}
