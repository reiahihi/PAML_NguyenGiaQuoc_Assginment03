<%--
// ****************************************** ************************************
// **************************    ************ User: MiTom
// *****************************    ********* Phone: 0966 941 840
// ********************************    ****** Email: 
// ****************************************** ************************************
// *****       ********       ******    ***** Package: 
// *****        ******        ******    ***** Project: PAML_dom
// *****    *    ****    *    ******    ***** Date: 25-Jan-18
// *****    **    **    **    ******    ***** Time: 10:46
// *****    ***        ***    ******    ***** Name: create
// *****    **************    ******    ***** ************************************
// *****    **************    ******    ***** Created by IntelliJ IDEA.
// ****************************************** ************************************
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h1>Create</h1>

<form action="CreateServlet" method="post">
    Code: <input type="number" name="code" id="code"/> <br/>
    Title: <input type="text" name="title" id="title" /> <br/>
    Price: <input type="number" name="price" id="price" /> <br/>
    Author: <input type="text" name="author" id="author" /> <br/>
    Edition: <input type="number" name="edition" id="edition" /> <br/>

    <input type="submit" value="Create"/>

</form>
</body>
</html>
