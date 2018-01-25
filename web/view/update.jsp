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
// *****    ***        ***    ******    ***** Name: update
// *****    **************    ******    ***** ************************************
// *****    **************    ******    ***** Created by IntelliJ IDEA.
// ****************************************** ************************************
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <h1>Update</h1>

    <form action="UpdateServlet" method="post">
        Code: <input type="number" name="code" id="code" value="${code}" readonly="readonly"/> <br/>
        Title: <input type="text" name="title" id="title" value="${title}"/> <br/>
        Price: <input type="number" name="price" id="price" value="${price}"/> <br/>
        Author: <input type="text" name="author" id="author" value="${author}"/> <br/>
        Edition: <input type="number" name="edition" id="edition" value="${edition}"/> <br/>

        <input type="submit" value="Update"/>

    </form>
</body>
</html>
