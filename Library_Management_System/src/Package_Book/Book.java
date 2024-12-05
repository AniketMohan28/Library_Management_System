package Package_Book;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Book implements Serializable {
      private int ISBN_Number;
      private String Book_Name;
      private String Author;
      private String Publisher;
      private int Edition;
      private String Subject;
      private int Available;
	public int getISBN_Number() {
		return ISBN_Number;
	}
	public void setISBN_Number(int iSBN_Number) {
		ISBN_Number = iSBN_Number;
	}
	public String getBook_Name() {
		return Book_Name;
	}
	public void setBook_Name(String book_Name) {
		Book_Name = book_Name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public int getEdition() {
		return Edition;
	}
	public void setEdition(int edition) {
		Edition = edition;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public int getAvailable() {
		return Available;
	}
	public void setAvailable(int available) {
		Available = available;
	}
	public Book(int iSBN_Number, String book_Name, String author, String publisher, int edition, String subject,
			int available) {
		super();
		ISBN_Number = iSBN_Number;
		Book_Name = book_Name;
		Author = author;
		Publisher = publisher;
		Edition = edition;
		Subject = subject;
		Available = available;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [ISBN_Number=" + ISBN_Number + ", Book_Name=" + Book_Name + ", Author=" + Author + ", Publisher="
				+ Publisher + ", Edition=" + Edition + ", Subject=" + Subject + ", Available=" + Available + "]";
	}
      
      
}


