package Package_Transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookTransactionManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient ObjectOutputStream OOS_Book_Transaction = null;
    private transient ObjectInputStream OIS_Book_Transaction = null;

    File Book_Transaction_File = new File("BookTransaction.txt");
    ArrayList<BookTransaction> Book_Transaction_List = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public BookTransactionManager() {
        if (Book_Transaction_File.exists()) {
            try {
                OIS_Book_Transaction = new ObjectInputStream(new FileInputStream(Book_Transaction_File));
                Book_Transaction_List = (ArrayList<BookTransaction>) OIS_Book_Transaction.readObject();
                OIS_Book_Transaction.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean IssueDate(int Roll, int ISBN) {
        int Total_Book_Issued = 0;

        for (BookTransaction book_Transaction : Book_Transaction_List) {
            if (book_Transaction.getRollNo() == Roll && book_Transaction.getReturnDate() == null) {
                Total_Book_Issued += 1;
                if (Total_Book_Issued >= 3) {
                    return false;
                }
            }
        }
        String issueDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        BookTransaction book_Transaction = new BookTransaction(ISBN, Roll, issueDate, null);
        Book_Transaction_List.add(book_Transaction);
        writeToFile();
        return true;
    }

    public boolean ReturnDate(int Roll, int ISBN) {
        for (BookTransaction book_Transaction : Book_Transaction_List) {
            if (book_Transaction.getRollNo() == Roll && book_Transaction.getISBN() == ISBN && book_Transaction.getReturnDate() == null) {
                String returnDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                book_Transaction.setReturnDate(returnDate);
                writeToFile();
                return true;
            }
        }
        return false;
    }

    public void ShowAll() {
        for (BookTransaction book_Transaction : Book_Transaction_List) {
            System.out.println(book_Transaction);
        }
    }

    public void writeToFile() {
        try {
            OOS_Book_Transaction = new ObjectOutputStream(new FileOutputStream(Book_Transaction_File));
            OOS_Book_Transaction.writeObject(Book_Transaction_List);
            OOS_Book_Transaction.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

