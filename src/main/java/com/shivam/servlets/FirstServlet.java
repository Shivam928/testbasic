package com.shivam.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		HttpSession session=req.getSession(true);
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		String name=req.getParameter("nm");
		String age=req.getParameter("ag");
		String email=req.getParameter("em");
		//System.out.println("before if");
		if(session.isNew()){
			//System.out.println("session is new");
		session.setAttribute("Name",name); //saving name in session attribute
		req.setAttribute("Name",name);     //saving name in request attribute
		session.setAttribute("Age",age);   //saving age in session attribute
		req.setAttribute("Age",age);       //saving age in request attribute
		session.setAttribute("Email-ID",email); //saving email in session attribute
		req.setAttribute("Email-ID",email);		//saving email in request attribute
		}
		if(name!=null)
		{
		RequestDispatcher rd=req.getRequestDispatcher("ques1.html");
		rd.include(req, res);
		}
		
	
		
		//for question1
		
		
		String q1=req.getParameter("q");
		if(q1!=null)
		{
	    req.setAttribute("Ques1",q1);
	    session.setAttribute("Ques1",q1);
		RequestDispatcher rd1=req.getRequestDispatcher("ques2.html");
		rd1.include(req,res);
		}
		
		//for question2
		
		String q2=req.getParameter("q2");
		if(q2!=null)
		{	
		req.setAttribute("Ques2",q2);
		session.setAttribute("Ques2",q2);
		RequestDispatcher rd2=req.getRequestDispatcher("ques3.html");
		rd2.include(req, res);
		}
		//for question3
		
		String q3=req.getParameter("qr");
		if(q3!=null)
		{	
		req.setAttribute("Ques3",q3);
		session.setAttribute("Ques3",q3);
		RequestDispatcher rd3=req.getRequestDispatcher("ques4.html");
		rd3.include(req, res);
		}
		
		//for question4
		
		String q4=req.getParameter("p");
		if(q4!=null)
		{	
		req.setAttribute("Ques4",q4);
		session.setAttribute("Ques4",q4);
		RequestDispatcher rd4=req.getRequestDispatcher("ques5.html");
		rd4.include(req, res);
		}
		//for question5
		
		String q5=req.getParameter("r");
		if(q5!=null)
		{	
		req.setAttribute("Ques5",q5);
		session.setAttribute("Ques5",q5);
		RequestDispatcher rd5=req.getRequestDispatcher("ques6.html");
		rd5.include(req, res);
		}
		
		//for question6
		
		String q6=req.getParameter("s");
		if(q6!=null)
		{	
		req.setAttribute("Ques6",q6);
		session.setAttribute("Ques6",q6);
		RequestDispatcher rd6=req.getRequestDispatcher("ques7.html");
		rd6.include(req, res);
		}
		
		//for question7
		
		String q7=req.getParameter("t");
		if(q7!=null)
		{	
		req.setAttribute("Ques7",q7);
		session.setAttribute("Ques7",q7);
		RequestDispatcher rd7=req.getRequestDispatcher("ques8.html");
		rd7.include(req, res);
		}
		
		//for question8
		
		String q8=req.getParameter("u");
		if(q8!=null)
		{	
		req.setAttribute("Ques8",q8);
		session.setAttribute("Ques8",q8);
		RequestDispatcher rd8=req.getRequestDispatcher("/my1");
		rd8.include(req, res);
		}
		
		
		
	}	
}		