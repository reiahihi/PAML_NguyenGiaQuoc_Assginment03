<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
// ****************************************** ************************************
// **************************    ************ User: MiTom
// *****************************    ********* Phone: 0966 941 840
// ********************************    ****** Email: 
// ****************************************** ************************************
// *****       ********       ******    ***** Package: 
// *****        ******        ******    ***** Project: PAML_dom
// *****    *    ****    *    ******    ***** Date: 25-Jan-18
// *****    **    **    **    ******    ***** Time: 09:14
// *****    ***        ***    ******    ***** Name: index
// *****    **************    ******    ***** ************************************
// *****    **************    ******    ***** Created by IntelliJ IDEA.
// ****************************************** ************************************
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="tblData" cellpadding="1" cellspacing="1" border="1">
    <a href="CreateServlet">Create New</a>
    <caption><h1>Book List</h1></caption>

    <thead>
    <tr>

        <td>Code</td>
        <td>Title</td>
        <td>Price</td>
        <td>Author</td>
        <td>Edition</td>
        <td></td>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${list}" var="b">
        <tr>
            <td>${b.code}</td>
            <td>${b.title}</td>
            <td>${b.price}</td>
            <td>${b.author}</td>
            <td>${b.edition}</td>
            <td><a href="UpdateServlet?code=${b.code}">Update</a> | <a href="DeleteServlet?code=${b.code}">Delete</a> </td>
        </tr>

    </c:forEach>
    </tbody>
</table>

</body>
</html>
