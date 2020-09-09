package com.impelsys.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.impelsys.dao.StudentDAO;
import com.impelsys.model.StudentModel;

@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		int roll;
		StudentModel temp;
		if(request.getParameter("oper")!=null)
		{
			if(request.getParameter("oper").equals("modify") )
			{
				roll=Integer.parseInt(request.getParameter("roll"));		

			    //temp.setRoll(roll);
			    temp=StudentDAO.getStudentsByRoll(roll);
			    if(temp!=null)
			    {
			    	request.setAttribute("student", temp);
			    	rd=request.getRequestDispatcher("edit_profile.jsp");
			    	rd.forward(request, response);
			    }

			}

		}
		if(request.getParameter("confirmupdate")!=null)
		{
			roll=Integer.parseInt(request.getParameter("roll"));	
			String name=request.getParameter("name");
			String fathername=request.getParameter("fathername");
			temp = new StudentModel();
			temp.setRoll(roll);temp.setName(name);temp.setFathername(fathername);
			if(StudentDAO.updateStudentByRoll(temp))
			 	request.setAttribute("successmsg", "Updated succssfully");
			else
				request.setAttribute("errormsg", "Not updated");			 
			rd=request.getRequestDispatcher("edit_profile.jsp");
    	    rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}