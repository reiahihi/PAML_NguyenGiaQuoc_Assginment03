package model;

// ****************************************** ************************************
// **************************    ************ User: MiTom
// *****************************    ********* Phone: 0966 941 840
// ********************************    ****** Email: 
// ****************************************** ************************************
// *****       ********       ******    ***** Package: model
// *****        ******        ******    ***** Project: PAML_dom
// *****    *    ****    *    ******    ***** Date: 25-Jan-18
// *****    **    **    **    ******    ***** Time: 09:33
// *****    ***        ***    ******    ***** Name: Book
// *****    **************    ******    ***** ************************************
// *****    **************    ******    ***** Created by IntelliJ IDEA.
// ****************************************** ************************************

public class Book
{
    int code;
    String title;
    String author;
    int price;
    int edition;

    public Book()
    {
    }

    public Book(int code, String title, String author, int price, int edition)
    {
        this.code = code;
        this.title = title;
        this.author = author;
        this.price = price;
        this.edition = edition;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public int getEdition()
    {
        return edition;
    }

    public void setEdition(int edition)
    {
        this.edition = edition;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", edition=" + edition +
                '}';
    }
}
