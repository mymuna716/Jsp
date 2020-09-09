package com.impelsys.dao;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.impelsys.model.*;;

public class StudentDAO
{
  private static Connection con; 
  private static PreparedStatement stmt;

public static void getConnection()
  {	 	
	  String JdbcURL = "jdbc:mysql://localhost:3306/test1" ;
      String Username = "root";
      String password = "root1";
       con = null;      
      try 
      {
    	 Class.forName("com.mysql.jdbc.Driver");   // Driver should be registered
    	 // con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test1","root","");  
         con = DriverManager.getConnection(JdbcURL, Username, password);

      } 
      catch (Exception e) 
      {
         e.printStackTrace();
      }


  }
  public static void closeConnection()
  {
	  try{
		  if(con.isClosed()==false)
	          con.close();   // closing the connection
	  }
	  catch(Exception e)
	  { e.printStackTrace();	 }
  }  

  public static ArrayList<String> getAllBranch()
  {
	  ArrayList<String> allbranch=new ArrayList<String>();	  
	  try
	  {
	  getConnection();
      stmt=con.prepareStatement("select distinct branch from schoolstudents");       
	  ResultSet rs=stmt.executeQuery();  
	  while(rs.next())
		  {  
		    	allbranch.add(rs.getString(1))	; 		
		  }  
	     closeConnection();	 
	     return allbranch;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return null; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return null; }  	  
  }
  public static ArrayList<StudentModel> getStudentsByBranch(String branch)
  {
	  ArrayList <StudentModel> students=new ArrayList<StudentModel>();
	  StudentModel temp; 

	  try
	  {
	  getConnection();
      stmt=con.prepareStatement("select rollno, name, fathername , degree from schoolstudents where branch=?"); 
      stmt.setString(1, branch);
	  ResultSet rs=stmt.executeQuery();  
	 // System.out.println(branch);
	  while(rs.next())
		  {  		   
		//  System.out.println(rs.getInt(1)+ rs.getString(2)+rs.getString(3)+rs.getString(4)+branch);
		  temp=new StudentModel(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),branch);	
		  students.add(temp); 		  

		  }  
	     closeConnection();	 
	     return students;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return null; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return null; }  	  
  }
  public static StudentModel getStudentsByRoll(int roll)
  {
	  StudentModel temp=null;	  	  
	  try
	  {
	  getConnection();
      stmt=con.prepareStatement("select rollno, name, fathername , degree,branch from schoolstudents where rollno=?"); 
      stmt.setInt(1, roll);
	  ResultSet rs=stmt.executeQuery(); 
	  boolean flag=false;
	 // System.out.println(branch);
	  if(rs.next())
		  {  		
		//System.out.println(rs.getInt(1)+ rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));

		  temp=new StudentModel(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));	
          flag=true;
		  }  
	     closeConnection();	 
	     if(flag==true)
	       return temp;
	     else
	    	 return null;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return null; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return null; }  	  
  }
  public static boolean updateStudentByRoll(StudentModel temp)
  {

	  try
	  {
	  getConnection();
      stmt=con.prepareStatement("update schoolstudents set name=?,fathername=? where rollno=?"); 
      stmt.setInt(3, temp.getRoll());
      stmt.setString(1, temp.getName());
      stmt.setString(2, temp.getFathername());
	  System.out.println(stmt.toString());
	  boolean flag=false;
	  int nor=stmt.executeUpdate();
	    closeConnection();	 
	     if(nor>0)
	       return true;
	     else
	    	 return false;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return false; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return false; }  	  
  }
  public static boolean deleteStudentByRoll(int roll)
  {
	  try
	  {
	  getConnection();
      stmt=con.prepareStatement("delete from schoolstudents where rollno=?"); 

      stmt.setInt(1, roll);

	  System.out.println(stmt.toString());
	  boolean flag=false;
	  int nor=stmt.executeUpdate();
	    closeConnection();	 
	     if(nor>0)
	       return true;
	     else
	    	 return false;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return false; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return false; }  

  }
}