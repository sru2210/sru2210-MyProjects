package com.revature.project.dao;
import java.util.List;

import com.revature.project.exceptions.InvalidException;
import com.revature.project.exceptions.InvalidIsbnException;
import com.revature.project.exceptions.InvalidUserException;
import com.revature.project.model.LibraryManagement.Library;
import com.revature.project.model.LibraryManagement.Users;
public interface LibraryDao
{
	public void addBook(Library library)throws InvalidIsbnException,Exception;
	public void delBook()throws InvalidException,Exception;
	public Library listBookByIsbn(List listofIsbn)throws InvalidException,Exception;
	public List<Library> listBooks() throws InvalidException,Exception;
	public void issueBook()throws InvalidException,Exception;
	public void updateBook()throws InvalidException,Exception;
	
	public void bkDetails()throws InvalidException,Exception;
	public void checkAdmin(String user,String pass)throws Exception;
	
	
	public void addUser()throws InvalidUserException,Exception;
	public void deleteUser()throws InvalidException,Exception;
	public List<Users> listAll()throws InvalidException,Exception;
	public Users listByUserId(List listofId) throws InvalidException,Exception;
	public void updateUser()throws InvalidException,Exception;
}
