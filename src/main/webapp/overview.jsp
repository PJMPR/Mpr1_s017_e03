<%@page import="java.util.List"%>
<%@page import="domain.model.Person"%>
<%@page import="domain.model.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Person person = (Person) session.getAttribute("person") ;
		List<Account> accountList = (List<Account>) session.getAttribute("accounts");
	%>
	<h2><%=person.getName()%> <%=person.getSurname()%></h2>
	
	<ol>
		<%for(Account account: accountList){ %>
		<li><%=account.getCurrency() %> <%=account.getAmount()%></li>
		<%}%>
	</ol>
	<a href="finalize">Save</a>
</body>
</html>