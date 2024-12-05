package Package_Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

import Package_Person.Student;

public class BookManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient ObjectOutputStream OOS_Book = null;
    private transient ObjectInputStream OIS_Book = null;

    File Book_File = new File("Book.txt");
    ArrayList<Book> BookList = null;

    @SuppressWarnings("unchecked")
    public BookManager() {
        BookList = new ArrayList<>();
        if (Book_File.exists()) {
            try {
                OIS_Book = new ObjectInputStream(new FileInputStream(Book_File));
                BookList = (ArrayList<Book>) OIS_Book.readObject();
                OIS_Book.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void addBook(Book book) {
        BookList.add(book);
        writeToFile();
    }

    public void ViewAllBook() {
        for (Book book : BookList) {
            System.out.println(book);
        }
    }

    public Book SearchBook(int isbn) {
        for (Book book : BookList) {
            if (book.getISBN_Number() == isbn) {
                return book;
            }
        }
        return null;
    }

    public void SearchBooksBySubject(String Subject) {
        for (Book book : BookList) {
            if (book.getSubject().equals(Subject)) {
                System.out.println(book);
            }
        }
    }

    public boolean DeleteBook(int DeleteISBN) {
        ListIterator<Book> BookIterator = BookList.listIterator();
        while (BookIterator.hasNext()) {
            Book book = BookIterator.next();
            if (book.getISBN_Number() == DeleteISBN) {
                BookIterator.remove();
                writeToFile();
                return true;
            }
        }
        return false;
    }

    public boolean UpdateBook(int Updated_iSBN_Number, String book_Name, String author, String publisher, int edition, String subject, int available) {
        ListIterator<Book> BookIterator = BookList.listIterator();
        while (BookIterator.hasNext()) {
            Book book = BookIterator.next();
            if (book.getISBN_Number() == Updated_iSBN_Number) {
                book.setISBN_Number(Updated_iSBN_Number);
                book.setBook_Name(book_Name);
                book.setAuthor(author);
                book.setPublisher(publisher);
                book.setEdition(edition);
                book.setSubject(subject);
                book.setAvailable(available);
                writeToFile();
                return true;
            }
        }
        return false;
    }

    public void writeToFile() {
        try {
            OOS_Book = new ObjectOutputStream(new FileOutputStream(Book_File));
            OOS_Book.writeObject(BookList);
            OOS_Book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
