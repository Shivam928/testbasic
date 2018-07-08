<% HttpSession se=request.getSession(false); %>
<%@ page import="com.itextpdf.text.BaseColor" %>
<%@ page import="com.itextpdf.text.Chunk" %>
<%@ page import="com.itextpdf.text.Document" %>
<%@ page import="com.itextpdf.text.DocumentException" %>
<%@ page import="com.itextpdf.text.Element" %>
<%@ page import="com.itextpdf.text.Font" %>
<%@ page import="com.itextpdf.text.FontFactory" %>
<%@ page import="com.itextpdf.text.Paragraph" %>
<%@ page import="com.itextpdf.text.pdf.PdfPCell" %>
<%@ page import="com.itextpdf.text.pdf.PdfPTable" %>
<%@ page import="com.itextpdf.text.pdf.PdfWriter" %>
<!--<%@ page import="java.io.FileOutputStream" %>-->
<%@ page import="com.itextpdf.text.pdf.FdfWriter" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.io.OutputStream" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="application/pdf; charset=ISO-8859-1">
<%response.setContentType("application/vnd.adobe.pdf");
response.setHeader("Content-Disposition","attachment; filename=\"Report.pdf\""); %>
<title>RESULT PDF</title>
</head>
<body>

<fieldset>
<legend> <marquee><b>I-PSS Survey</b></marquee> </legend>
<%
if(se!=null){
String name=(String)session.getAttribute("Name"); 

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
PdfWriter.getInstance(document,baos);
//PdfWriter.getInstance(document,new FileOutputStream("D:\\ITextTest.pdf"));
document.open();
String k=name;
name="Your name : "+name;
age="Your age : "+age;
String em=(String)session.getAttribute("Email-ID");
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
document.add(table);
document.add(Chunk.NEWLINE);
String msg="Thank you for the Survey Mr./Ms. "+k;
	int sco=(int)se.getAttribute("Score");
String msg1="As per your survey,the score calculated by us is "+sco;
document.add(new Paragraph(msg,FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLDITALIC,BaseColor.BLACK)));
document.add(new Paragraph(msg1,FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLDITALIC,BaseColor.BLACK)));

document.close(); 
//setting some response headers
response.setHeader("Expires", "0");
response.setHeader("Cache-Control",
 "must-revalidate, post-check=0, pre-check=0");
response.setHeader("Pragma", "public");
//setting the content type
response.setContentType("application/pdf");
//the contentlength
response.setContentLength(baos.size());
//write ByteArrayOutputStream to the ServletOutputStream
OutputStream os = response.getOutputStream();
baos.writeTo(os);
os.flush();
os.close();
}
%>

<%se.invalidate(); %>
</fieldset>
</body>
</html>