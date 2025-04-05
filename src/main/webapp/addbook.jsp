<%@ page import="p4n.in.BookDao"%>
<jsp:useBean id="b" class="p4n.in.Book"></jsp:useBean>
<jsp:setProperty property="*" name="b"/>

<%
int i = BookDao.save(b);
if (i > 0) {
    response.sendRedirect("addbook-success.jsp");
} else {
    response.sendRedirect("addbook-error.jsp");
}
%>
