<%@page import="p4n.in.BookDao"%>
<jsp:useBean id="b" class="p4n.in.Book"></jsp:useBean>
<jsp:setProperty property="*" name="b"/>

<%
int i = BookDao.update(b);
response.sendRedirect("viewbooks.jsp");
%>
