package com.impelsys.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.impelsys.dao.*;
import com.impelsys.model.*;



@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		RequestDispatcher rd;
		String selname="";   // 12,13

		String oper="";String roll="";
		if(request.getParameter("oper")!=null )
		{
			oper=request.getParameter("oper");
			roll=(String)request.getParameter("roll");
			if(oper=="modify")
			{
				rd=request.getRequestDispatcher("modify");		    
		 	    rd.forward(request, response);
			}
			else if(oper=="delete")
			{
				rd=request.getRequestDispatcher("delete");		    
		 	    rd.forward(request, response);
			}
		}


		ArrayList<String> allbranch;
		allbranch= StudentDAO.getAllBranch();
		request.setAttribute("allbranch", allbranch);
		String val="";

		ArrayList<StudentModel> allStudents;

		if(request.getParameter("catg")!=null)
		{   
			val=request.getParameter("category");
			allStudents= StudentDAO.getStudentsByBranch(val);
			request.setAttribute("allStudent", allStudents);			
		}	

		rd=request.getRequestDispatcher("ShowProduct.jsp");		    
 	    rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}