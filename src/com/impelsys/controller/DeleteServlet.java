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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		int roll;
		//rd=request.getRequestDispatcher("delete_profile.jsp");
		//rd.forward(request, response);	

		StudentModel temp=new StudentModel();
		if(request.getParameter("oper")!=null)
		{
			if(request.getParameter("oper").equals("delete"))
			{

				roll=Integer.parseInt(request.getParameter("roll"));					
			    temp.setRoll(roll);
			    temp=StudentDAO.getStudentsByRoll(roll);
			    if(temp!=null)
			    {

			    	request.setAttribute("student", temp);
			    	rd=request.getRequestDispatcher("delete_profile.jsp");
			    	rd.forward(request, response);	

			    }		    
			}
		}

		if(request.getParameter("confirmdelete")!=null)
		{
			roll=Integer.parseInt(request.getParameter("roll"));	
			if(StudentDAO.deleteStudentByRoll(roll))
			{
				request.setAttribute("successmsg", "deleted succssfully");
			}
			else
			{
				request.setAttribute("errormsg", "Not deleted");	
			}
			rd=request.getRequestDispatcher("delete_profile.jsp");
			rd.forward(request, response);	
		}



	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}