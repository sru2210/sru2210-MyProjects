package com.revature.project.dao;

import org.junit.Test;

import com.revature.project.DBUtil.DBUtil;
import com.revature.project.controller.LibraryController;
import com.revature.project.model.LibraryManagement.Library;
import com.revature.project.model.LibraryManagement.Users;
import com.revature.project.model.client.BookDetails;
import com.revature.project.model.client.userUpdate;

import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class LibraryDaoImpTest {

	@Test
	public void testCheckAdmin() throws Exception {
		LibraryDaoImp libraryDaoImp=new LibraryDaoImp();
	String user=null;
	String pass=null;
	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	String query="select * from login";
	ResultSet resultSet=st.executeQuery(query);
	while(resultSet.next())
	{
		user=resultSet.getString(1);
		pass=resultSet.getString(2);
	}
	
	assertEquals("admin",user);
	assertEquals("admin",pass);
	}

	@Test
	public void testAddUser() throws Exception {
	LibraryDaoImp libraryDaoImp=new LibraryDaoImp();
	long beforeAdd=0;
	long afterAdd=0;
	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	String query="select * from user";
	ResultSet resultSet=st.executeQuery(query);
	
	while(resultSet.next())
	{
		beforeAdd++;
	}
	libraryDaoImp.addUser();
	ResultSet rs=st.executeQuery(query);
	while(rs.next())
	{
		afterAdd++;
	}
	
	assertNotSame(beforeAdd,afterAdd);	
	}

	
	@Test
	public void testDeleteUser() throws Exception {
		LibraryDaoImp libraryDaoImp=new LibraryDaoImp();
	long beforeDelete=0;
	long afterDelete=0;
	ResultSet resultSet=null;
	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	resultSet=st.executeQuery("select * from user");
	while(resultSet.next())
	{
		beforeDelete++;
	}
	libraryDaoImp.deleteUser();
	resultSet=st.executeQuery("select * from user");
	while(resultSet.next())
	{
		afterDelete++;
	}
	assertNotSame(beforeDelete,afterDelete);
	}

	@Test
	public void testUpdateUser() throws Exception {
		LibraryDaoImp libraryDaoImp=new LibraryDaoImp();
		Scanner sc=new Scanner(System.in);
	String user=null,email=null;
	String query=null;
	long phnNo=0;
	Boolean flag=false;
	String updatedUser=null,updatedEmail=null;
	long updatedPhnNo=0;
	ResultSet resultSet=null;
	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	System.out.println("Enter id of user to update");
	query="select * from user where id="+(sc.nextInt());
	 resultSet=st.executeQuery(query);
	while(resultSet.next())
	{
		user=resultSet.getString(2);
		email=resultSet.getString(3);
		phnNo=resultSet.getLong(4);
	}
	libraryDaoImp.updateUser();
	resultSet=st.executeQuery(query);
	while(resultSet.next())
	{
		updatedUser=resultSet.getString(2);
		updatedEmail=resultSet.getString(3);
		updatedPhnNo=resultSet.getLong(4);
	}
	if(!user.equals(updatedUser)||!email.equals(updatedEmail)||phnNo!=updatedPhnNo)
		flag=true;
	assertTrue(flag);
	}

	@Test
	public void testListByUserId() throws Exception {
		boolean flag=false;
		LibraryController lc=new LibraryController();
		userUpdate u=new userUpdate();
		LibraryDaoImp libraryDaoImp=new LibraryDaoImp();
		Users user=new Users();
		Connection con=DBUtil.getConnection();
		Statement st=con.createStatement();
		String query="select * from user";
		u.users(lc);
		ResultSet resultSet=st.executeQuery(query);
		if(resultSet.next())
			flag=true;
		assertTrue(flag);
	}

	@Test
	public void testListAll() throws Exception {
		boolean flag=false;
	List<Users>userList=new ArrayList<Users>();
	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	String query="select * from user";
	ResultSet resultSet=st.executeQuery(query);
	if(resultSet.next())
		flag=true;

	assertTrue(flag);
	}

	@Test
	public void testBkDetails() throws Exception {
		boolean flag=false;
	LibraryDaoImp libraryDaoImp=new LibraryDaoImp();
	Connection con=DBUtil.getConnection();
		Statement st=con.createStatement();
		String query="select * from user join issuebk on user.id=issuebk.id"; 
		libraryDaoImp.bkDetails();
		ResultSet resultSet=st.executeQuery(query);
		if(resultSet.next())
			flag=true;

	assertTrue(flag);
	}

	@Test
	public void testDelBook() throws Exception {
		LibraryDaoImp libraryDaoImp=new LibraryDaoImp();
	long beforeDelete=0;
	long afterDelete=0;
	ResultSet resultSet=null;
	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	resultSet=st.executeQuery("select * from book");
	while(resultSet.next())
	{
		beforeDelete++;
	}
	libraryDaoImp.delBook();
	resultSet=st.executeQuery("select * from book");
	while(resultSet.next())
	{
		afterDelete++;
	}
	assertNotSame(beforeDelete,afterDelete);
	}


	public void testListBooks() throws Exception {
		boolean flag=false;
	List<Library>bookList=new ArrayList<Library>();
	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	String query="select * from book";
	ResultSet resultSet=st.executeQuery(query);
	
	if(resultSet.next())
		flag=true;
	assertTrue(flag);
	}

	@Test
	public void testListBookByIsbn() throws Exception {
	
	boolean flag=false;
	LibraryController lc=new LibraryController();
	BookDetails b=new BookDetails();
	LibraryDaoImp libraryDaoImp=new LibraryDaoImp();
	Library library=new Library();
	Connection con=DBUtil.getConnection();
	Statement st=con.createStatement();
	String query="select * from book";
	b.books(lc);
	ResultSet resultSet=st.executeQuery(query);
	if(resultSet.next())
		flag=true;
	assertTrue(flag);
	}

	

	

}
