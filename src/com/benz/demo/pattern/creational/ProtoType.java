package com.benz.demo.pattern.creational;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

class Book
{
    private int bookId;
    private String name;
    private double price;

    public Book() {
    }

    public Book(int bookId, String name, double price) {
        this.bookId = bookId;
        this.name = name;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return price;
    }

    public void setSalary(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class BookShop implements Cloneable
{
    private String name;
    private final List<Book> books;

    public BookShop(String name)
    {
        this.name=name;
        books=new ArrayList<>();
    }

    public void loadBook()
    {
        for(int i=1;i<=1000;i++)
        {
            Book book=new Book();
            book.setBookId(1000+i);
            book.setName("book "+i);
            book.setSalary(genPrice());
            this.getBooks().add(book);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    private double genPrice()
    {
        int min=1000;
        int max=10000;

        DecimalFormat df=new DecimalFormat("####0.00");

        return Double.valueOf(df.format(Math.round((Math.random()*(max-min+1)+min)/10.0)*10));
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public BookShop deepClone(String shoName)
    {
        BookShop bookShop=new BookShop(shoName);

        for(int i=1;i<=1000;i++)
        {
            Book book=new Book();
            book.setBookId(1000+i);
            book.setName("book "+i);
            book.setSalary(genPrice());
            this.getBooks().add(book);
        }
        return bookShop;
    }
}

public class ProtoType {

    public void start() throws CloneNotSupportedException {
        BookShop bookShop = new BookShop("benz");
        bookShop.loadBook();

       /* BookShop bookShop2 = (BookShop) bookShop.clone();//shallow cloning
        bookShop2.loadBook();*/

        BookShop bookShop2 = bookShop.deepClone("kelly"); //deep cloning
        bookShop2.loadBook();

        bookShop.getBooks().remove(1);

        System.out.println(bookShop);
        System.out.println(bookShop2);
    }


}
