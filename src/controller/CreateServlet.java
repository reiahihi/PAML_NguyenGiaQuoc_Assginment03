package controller;// ****************************************** ************************************
// **************************    ************ User: MiTom
// *****************************    ********* Phone: 0966 941 840
// ********************************    ****** Email: 
// ****************************************** ************************************
// *****       ********       ******    ***** Package: "${PACKAGE_NAME}"
// *****        ******        ******    ***** Project: PAML_dom
// *****    *    ****    *    ******    ***** Date: 25-Jan-18
// *****    **    **    **    ******    ***** Time: 09:49
// *****    ***        ***    ******    ***** Name: ${NAME}
// *****    **************    ******    ***** ************************************
// *****    **************    ******    ***** Created by IntelliJ IDEA.
// ****************************************** ************************************


import model.Book;
import repository.MyXMLHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateServlet", urlPatterns = {"/CreateServlet"})
public class CreateServlet extends HttpServlet
{
    repository.MyXMLHandler data = new MyXMLHandler();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        data.postBook(new Book(
                Integer.parseInt(request.getParameter("code")),
                request.getParameter("title"),
                request.getParameter("author"),
                Integer.parseInt(request.getParameter("price")),
                Integer.parseInt(request.getParameter("edition"))
        ));

        response.sendRedirect("ListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("view/create.jsp").forward(request, response);
    }
}
