package com.shivam.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DisplayServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType( "text/html" );
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>table, th, td {border: 1px solid black;border-collapse: collapse;}</style>");
		out.println("</head>");
		out.println(" <body  style=background:Cornsilk;>");
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			String names=(String)session.getAttribute("Name");
		 out.println("<center>");
		 out.println("<h2>Thank you "+names+"</h2>");
		 
		 out.println("</center>");
		 out.println("<center>");
		 out.println("<h3><i><u>Your response fetched by us is as follows</u></i></h3>");
		 out.println("</center>");
		 out.println("<center>");
		 out.println("<form action=\"");
		 out.println("my4\" method=get>");
		 out.println("<br><br>");
		 out.println("<input type=submit value=\"SAVE AS PDF\"></form>");
			out.println("<table>");
				out.println("<tr>");
					out.println("<th>Query Number</th>");
					out.println("<th>Your Response Recorded</th>");
				out.println("</tr>");
				
				//for question 1
				
				String q1=(String)req.getAttribute("Ques1");       //getting from request
				String r1=(String)session.getAttribute("Ques1");   //getting from session
				Integer que1=Integer.parseInt(r1);
				int a=que1.intValue();                             //variable for question 1
				out.println("<tr>");
				out.println("<td>How often have you had the sensation of not emptying your bladder?</td>");
				out.println("<td>"+r1+"</td>");
				out.println("</tr>");
				
				//for question 2
				
				String q2=(String)req.getAttribute("Ques2");       //getting from request
				String r2=(String)session.getAttribute("Ques2");   //getting from session
				Integer que2=Integer.parseInt(r2);
				int b=que2.intValue();                             //variable for question 2
				out.println("<tr>");
				out.println("<td>How often have you had to urinate less than every two hours?</td>");
				out.println("<td>"+r2+"</td>");
				out.println("</tr>");
				
				//for question 3
				
				String q3=(String)req.getAttribute("Ques3");        //getting from request
				String r3=(String)session.getAttribute("Ques3");   //getting from session
				Integer que3=Integer.parseInt(r3);
				int c=que3.intValue();                             //variable for question 3
				out.println("<tr>");
				out.println("<td>How often have you found you stopped and started again several times when you urinated?</td>");
				out.println("<td>"+r3+"</td>");
				out.println("</tr>");
				
				//for question 4
				
				String q4=(String)req.getAttribute("Ques4");       //getting from request
				String r4=(String)session.getAttribute("Ques4");   //getting from session
				Integer que4=Integer.parseInt(r4);
				int d=que4.intValue();                             //variable for question 4
				out.println("<tr>");
				out.println("<td>How often have you found it difficult to postpone urination?</td>");
				out.println("<td>"+r4+"</td>");
				out.println("</tr>");
				
				//for question 5
				
				String q5=(String)req.getAttribute("Ques5");        //getting from request
				String r5=(String)session.getAttribute("Ques5");   //getting from session
				Integer que5=Integer.parseInt(r5);
				int e=que5.intValue();                             //variable for question 5
				out.println("<tr>");
				out.println("<td>How often have you had a weak urinary stream?</td>");
				out.println("<td>"+r5+"</td>");
				out.println("</tr>");
				
				//for question 6
				
				String q6=(String)req.getAttribute("Ques6");        //getting from request
				String r6=(String)session.getAttribute("Ques6");   //getting from session
				Integer que6=Integer.parseInt(r6);
				int f=que6.intValue();                             //variable for question 6
				out.println("<tr>");
				out.println("<td>How often have you had to strain to start urination?</td>");
				out.println("<td>"+r6+"</td>");
				out.println("</tr>");
				
				//for question 7
				
				String q7=(String)req.getAttribute("Ques7");       //getting from request
				String r7=(String)session.getAttribute("Ques7");   //getting from session
				Integer que7=Integer.parseInt(r7);
				int g=que7.intValue();                             //variable for question 7
				out.println("<tr>");
				out.println("<td>How many times did you typically get up at night to urinate?</td>");
				out.println("<td>"+r7+"</td>");
				out.println("</tr>");
				
				//for question 8
				
				String q8=(String)req.getAttribute("Ques8");       //getting from request
				String r8=(String)session.getAttribute("Ques8");   //getting from session
				Integer que8=Integer.parseInt(r8);
				int h=que8.intValue();                             //variable for question 1
				out.println("<tr>");
				out.println("<td>If you were to spend the rest of your life with your urinary condition just the way it is now, how would you feel about that?</td>");
				out.println("<td>"+r8+"</td>");
				out.println("</tr>");
				
				out.println("</table>");
				out.println("</form>");
				out.println("<br><br>");
				out.println("<strong>YOUR SCORE : "+(a+b+c+d+e+f+g+h)+"</strong>");
				
				out.println("</center>");
				out.println("<br><br><br><br><br>");
				int tot=a+b+c+d+e+f+g+h;
				session.setAttribute("Score",tot);
				req.setAttribute("Score",tot);
				out.println("<footer>");
				out.println("<p>");
				out.println("<center>");
				
				out.println("<i>I-PSS Survey Result</i>");
				out.println("<br>");
				out.println("<strong>Note:</strong>");
				out.println("<i>To print press ->ctrl+p</i>");
				out.println("</center>");
				out.println("</p>");
				out.println("</footer>");
			}
		out.println("</body></html>");
		}
		//session.invalidate();        // --> We'll do this or not?
		
	}


