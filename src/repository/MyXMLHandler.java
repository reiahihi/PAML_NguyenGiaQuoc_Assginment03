package repository;

// ****************************************** ************************************
// **************************    ************ User: MiTom
// *****************************    ********* Phone: 0966 941 840
// ********************************    ****** Email: 
// ****************************************** ************************************
// *****       ********       ******    ***** Package: repository
// *****        ******        ******    ***** Project: PAML_dom
// *****    *    ****    *    ******    ***** Date: 25-Jan-18
// *****    **    **    **    ******    ***** Time: 09:19
// *****    ***        ***    ******    ***** Name: MyXMLHandler
// *****    **************    ******    ***** ************************************
// *****    **************    ******    ***** Created by IntelliJ IDEA.
// ****************************************** ************************************

import model.Book;
import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.List;

public class MyXMLHandler
{
    List<Book> Books;



    public List<Book> getBooksFromXml()
    {
        Books = new ArrayList<>();

        Document doc = DomHelper.getDoc();

        doc.getDocumentElement().normalize();

        System.out.println("Root: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("Book");

        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node nNode = nList.item(temp);

            System.out.println("\nCurrent Element: " + nNode.getNodeName());
            if (nNode.getNodeType() == 1)
            {
                Element eElement = (Element) nNode;
                Book b = new Book();
                System.out.println(eElement.getAttribute("code"));
                b.setCode(Integer.parseInt(eElement.getAttribute("code")));

                b.setTitle(eElement.getElementsByTagName("Title").item(0).getTextContent());

                b.setPrice(Integer.valueOf(eElement.getElementsByTagName("Price").item(0).getTextContent()));

                b.setAuthor(eElement.getElementsByTagName("Author").item(0).getTextContent());

                b.setEdition(Integer.valueOf(eElement.getElementsByTagName("Edition").item(0).getTextContent()));

                this.Books.add(b);
            }

        }
        return this.Books;


    }

    public boolean removeBook(int code)
    {

        Document doc = DomHelper.getDoc();
        Node store = doc.getFirstChild();

        boolean found = false;

        NodeList books = doc.getElementsByTagName("Book");

        System.out.println(books.getLength());

        for (int i = 0; i < books.getLength(); i++)
        {
            Node book = books.item(i);

            NamedNodeMap attr = book.getAttributes();

            if (Integer.valueOf(attr.getNamedItem("code").getNodeValue()) == code)
            {
                found = true;
                store.removeChild(book);
            }
        }
        if (!found)
            return false;
        DomHelper.saveXmlContent(doc);

        return true;
    }

    public Book findBookByCode(int code)
    {
        for (Book b : this.Books)
        {
            if (b.getCode() == code)
                return b;

        }
        return null;
    }

    public void postBook(Book b)
    {
        Document d;
        try {
            d = repository.DomHelper.getDoc();
            Element books = d.getDocumentElement();
            Element book = d.createElement("Book");


            book.setAttribute("code", String.valueOf(b.getCode()));

            Element title = d.createElement("Title");
            title.appendChild(d.createTextNode(b.getTitle()));
            book.appendChild(title);

            Element price = d.createElement("Price");
            price.appendChild(d.createTextNode(String.valueOf(b.getPrice())));
            book.appendChild(price);

            Element author = d.createElement("Author");
            author.appendChild(d.createTextNode(b.getAuthor()));
            book.appendChild(author);

            Element edition = d.createElement("Edition");
            edition.appendChild(d.createTextNode(String.valueOf(b.getEdition())));
            book.appendChild(edition);

            books.appendChild(book);

            DomHelper.saveXmlContent(d);
            System.out.println("da save");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return;
    }

    public boolean putBook(int code, String[] update)
    {
        Document doc = repository.DomHelper.getDoc();

        boolean found = false;

        NodeList books = doc.getElementsByTagName("Book");

        for(int i = 0; i < books.getLength(); i++)
        {
            Node book = books.item(i);
            NamedNodeMap attr = book.getAttributes();

            if(Integer.valueOf(attr.getNamedItem("code").getNodeValue()) == code)
            {
                found = true;

                NodeList list = book.getChildNodes();

                for ( int j = 0 ; j < list.getLength(); j++)
                {
                    Node node = list.item(j);

                    if("Title".equalsIgnoreCase(node.getNodeName()))
                    {
                        node.setTextContent(update[0]);
                    }

                    if("Price".equalsIgnoreCase(node.getNodeName()))
                    {
                        node.setTextContent(update[1]);
                    }

                    if("Author".equalsIgnoreCase(node.getNodeName()))
                    {
                        node.setTextContent(update[2]);
                    }

                    if("Edition".equalsIgnoreCase(node.getNodeName()))
                    {
                        node.setTextContent(update[3]);
                    }

                }
                break;

            }
        }
        if (!found)
            return false;

        repository.DomHelper.saveXmlContent(doc);
        return true;
    }

    public static void main(String[] args)
    {
        MyXMLHandler exec = new MyXMLHandler();

        Document d = repository.DomHelper.getDoc();



        exec.postBook(new Book());
    }
}
