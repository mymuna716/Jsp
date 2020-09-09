<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>
 <%@ page import="com.impelsys.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<link rel="stylesheet" type="text/css" href="css/style1.css">


</head>


<body bgcolor="grey">
<form name=show action="StudentServlet" method="get">
<div>

<div class="dropdown" color=cyan>
<p align=center>
  <label  id="text">Choose Department  :</label>
  <select id="category" name="category">
  <option value="Select">Select</option>

  <%
  String list="";
 
  if(request.getAttribute("allbranch")!=null)
   { 
	 
	   ArrayList<String> allBranch=(ArrayList<String>)request.getAttribute("allbranch");
	  
	   for(String val: allBranch)
	   {
		   list=list+"<option>"+val+"</option>";
	   }
	   
   }
  out.println(list);
  
  
  
  %>

</select>

<input type=submit value=Submit name=catg></p>




    <br><br>
</div>

<div color=blue>
<table id="customers">
  <tr>
    <th>Roll</th>
    <th>Name</th>
    <th>Father Name</th>

    <th>Degree</th>
    <th>Select</th>
    <th>Remove</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
 <%
 
 String record="";
 if(request.getAttribute("allStudent")!=null)
 { 
    ArrayList<StudentModel> allStudent=(ArrayList<StudentModel>)request.getAttribute("allStudent");   
    for(StudentModel s: allStudent)
    {  
 	   record=record+"<tr>";
 	   record=record+"<td>"+s.getRoll()+"</td><td>"+s.getName()+"</td><td>"+s.getFathername()+"</td><td>"+s.getDegree()+"</td>";
 	   record=record+"<td><input type=checkbox name=choose value='"+s.getRoll()+"'></td>";
 	   record=record+"<td><input type=Radio name=choose value='"+s.getRoll()+"'></td>";
 	   record=record+"<td><a href='ModifyServlet?oper=modify&roll="+s.getRoll()+"'>Edit</a></td>";
 	   record=record+"<td><a href='DeleteServlet?oper=delete&roll="+s.getRoll()+"'>Delete</a></td>";
 	   record=record+"</tr>";
    }
    
 }
 out.println(record);
 
 
 
 
 %> 



  </tr>

</table>
<br><br>
</p>
</div>
</form>
</body>
</html>
</body>
</html> 