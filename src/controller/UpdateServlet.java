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

@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet
{
    repository.MyXMLHandler data = new MyXMLHandler();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String[] update =
                {
                    request.getParameter("title"),
                    request.getParameter("price"),
                    request.getParameter("author"),
                    request.getParameter("edition")
                };

        data.putBook(Integer.parseInt(request.getParameter("code")), update);

        response.sendRedirect("ListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int code = Integer.valueOf(request.getParameter("code"));
        data.getBooksFromXml();
        Book b =  data.findBookByCode(code);
        request.setAttribute("code", b.getCode());
        request.setAttribute("title", b.getTitle());
        request.setAttribute("price", b.getPrice());
        request.setAttribute("author", b.getAuthor());
        request.setAttribute("edition", b.getEdition());

        request.getRequestDispatcher("view/update.jsp").forward(request, response);
    }
}
