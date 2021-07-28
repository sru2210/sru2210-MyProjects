package com.revature.product.service;
import com.revature.project.model.LibraryManagement.Users;

import java.util.List;

import com.revature.project.exceptions.InvalidException;
import com.revature.project.model.LibraryManagement.Library;


	public interface LibraryService
	{
		
		public void addBook(Library library) throws Exception;
		public void checkAdmin(String user,String pass)throws Exception;
		public void addUser()throws Exception;
		public void deleteUser()throws InvalidException,Exception;
		public List<Users> listAll() throws Exception;
		public Users listByUserId(List listofId) throws InvalidException,Exception;
		public void updateUser() throws Exception;
		public void bkDetails() throws Exception;
		public void delBook() throws Exception;
		public Library listBookByIsbn(List listofIsbn) throws Exception;
		public List<Library> listBooks() throws Exception;
		public void issueBook() throws Exception;
		public void updateBook() throws Exception;

	}

