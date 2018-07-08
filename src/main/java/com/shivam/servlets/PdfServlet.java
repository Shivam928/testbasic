package com.shivam.servlets;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.http.*;
import com.itextpdf.text.pdf.FdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class PdfServlet extends HttpServlet{
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
HttpSession se=req.getSession(false);
res.setContentType("application/vnd.adobe.pdf");
res.setHeader("Content-Disposition","attachment; filename=\"Report.pdf\"");
if(se!=null){
String name=(String)se.getAttribute("Name"); 

String age=(String)se.getAttribute("Age"); 
String email=(String)se.getAttribute("Email-ID");
String q1=(String)se.getAttribute("Ques1"); 
String q2=(String)se.getAttribute("Ques2");
String q3=(String)se.getAttribute("Ques3");
String q4=(String)se.getAttribute("Ques4");
String q5=(String)se.getAttribute("Ques5"); 
String q6=(String)se.getAttribute("Ques6"); 
String q7=(String)se.getAttribute("Ques7"); 
String q8=(String)se.getAttribute("Ques8"); 

Document document=new Document();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
try {
PdfWriter.getInstance(document,baos);
//PdfWriter.getInstance(document,new FileOutputStream("D:\\ITextTest.pdf"));
document.open();
String k=name;
name="Your name : "+name;
age="Your age : "+age;
String em=(String)se.getAttribute("Email-ID");
em=em+"Your Email id : "+em;
document.add(new Paragraph(name,FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,BaseColor.BLACK)));
document.add(Chunk.NEWLINE);
document.add(new Paragraph(age,FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,BaseColor.BLACK)));
document.add(Chunk.NEWLINE);
document.add(new Paragraph(email,FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,BaseColor.BLACK)));
document.add(Chunk.NEWLINE);
PdfPTable table=new PdfPTable(2);
PdfPCell cell=new PdfPCell(new Paragraph("--THE SCORES FETCHED ACCORDING TO YOUR RESPONSE--"));
cell.setColspan(4);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
cell.setBackgroundColor(BaseColor.GREEN);
table.addCell(cell);
table.addCell("How often have you had the sensation of not emptying your bladder?");
table.addCell(q1);
table.addCell("How often have you had to urinate less than every two hours?");
table.addCell(q2);
table.addCell("How often have you found you stopped and started again several times when you urinated?");
table.addCell(q3);
table.addCell("How often have you found it difficult to postpone urination?");
table.addCell(q4);
table.addCell("How often have you had a weak urinary stream?");
table.addCell(q5);
table.addCell("How often have you had to strain to start urination?");
table.addCell(q6);
table.addCell("How many times did you typically get up at night to urinate?");
table.addCell(q7);
table.addCell("If you were to spend the rest of your life with your urinary condition just the way it is now, how would you feel about that?");
table.addCell(q8);
String msg="Thank you for the Survey Mr./Ms. "+k;

//for question 1

String r1=(String)se.getAttribute("Ques1");   //getting from session
Integer que1=Integer.parseInt(r1);
int a=que1.intValue();                             //variable for question 1

//for question 2

String r2=(String)se.getAttribute("Ques2");
Integer que2=Integer.parseInt(r2);
int b=que2.intValue();

//for question 3

String r3=(String)se.getAttribute("Ques3");
Integer que3=Integer.parseInt(r3);
int c=que3.intValue();

//for question 4

String r4=(String)se.getAttribute("Ques4");
Integer que4=Integer.parseInt(r4);
int d=que4.intValue();

//for question 5

String r5=(String)se.getAttribute("Ques5");   //getting from session
Integer que5=Integer.parseInt(r5);
int e=que5.intValue();                             //variable for question 5

//for question 6

String r6=(String)se.getAttribute("Ques6");
Integer que6=Integer.parseInt(r6);
int f=que6.intValue();

//for question 7

String r7=(String)se.getAttribute("Ques7");
Integer que7=Integer.parseInt(r7);
int g=que7.intValue();

//for question 8

String r8=(String)se.getAttribute("Ques8");
Integer que8=Integer.parseInt(r8);
int h=que8.intValue();

int tot=a+b+c+d+e+f+g+h;
String msg1="As per your survey,the score calculated by us is "+tot;

	document.add(table);
	document.add(Chunk.NEWLINE);
	document.add(new Paragraph(msg,FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLDITALIC,BaseColor.BLACK)));
	document.add(new Paragraph(msg1,FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLDITALIC,BaseColor.BLACK)));

	document.close(); 
} 
catch(Exception e){
	e.printStackTrace();
}
//setting some response headers
res.setHeader("Expires", "0");
res.setHeader("Cache-Control",
 "must-revalidate, post-check=0, pre-check=0");
res.setHeader("Pragma", "public");
//setting the content type
res.setContentType("application/pdf");
//the contentlength
res.setContentLength(baos.size());
//write ByteArrayOutputStream to the ServletOutputStream
OutputStream os = res.getOutputStream();
baos.writeTo(os);
os.flush();
os.close();
se.invalidate();
            }
      }

  }