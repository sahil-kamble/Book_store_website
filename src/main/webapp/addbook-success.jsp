<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Added Successfully</title>
</head>
<body>

<jsp:include page="header.html"></jsp:include>

<div class="px-4 py-5 my-5">
    <div class="col-lg-6 mx-auto">
        <h4 class="display-5 fw-bold text-body-emphasis">Add New Book</h4>
        <div class="alert alert-success" role="alert">
            The book has been successfully added to the store!
        </div>
        <jsp:include page="userbook.html"></jsp:include>
    </div>
</div>

</body>
</html>
