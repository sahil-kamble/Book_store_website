<%@ page import="p4n.in.BookDao,p4n.in.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.html"></jsp:include>

<div class="px-4 py-5 my-5">
    <div class="col-lg-6 mx-auto">
        <h4 class="display-5 fw-bold text-body-emphasis">All Books</h4>

        <%
        List<Book> list = BookDao.getAllBooks();
        request.setAttribute("list", list);
        %>

        <table class="table table-bordered border-dark table-striped">
            <tr><th>Id</th><th>Title</th><th>Author</th><th>Price</th><th>Publication Year</th><th>Edit</th><th>Delete</th></tr>
            <c:forEach items="${list}" var="b">
                <tr>
                    <td>${b.getId()}</td>
                    <td>${b.getTitle()}</td>
                    <td>${b.getAuthor()}</td>
                    <td>${b.getPrice()}</td>
                    <td>${b.getPublicationYear()}</td>
                    <td><a class="btn btn-success" href="editbookform.jsp?id=${b.getId()}">Edit</a></td>
                    <td><a class="btn btn-danger" href="deletebook.jsp?id=${b.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
