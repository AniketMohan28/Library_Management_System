package Package_Main;
import java.util.Scanner;

import Package_Book.Book;
import Package_Book.BookManager;
import Package_Exception.BookNotFoundException;
import Package_Exception.StudentNotFoundException;
import Package_Person.Student;
import Package_Person.StudentManager;
import Package_Transaction.BookTransactionManager;

public class Main {

	public static void main(String[] args) 
	{
		Scanner Sc=new Scanner(System.in);
		
		BookManager BM=new BookManager();
		StudentManager SM=new StudentManager();
		BookTransactionManager BTM=new BookTransactionManager();
		
		int Choice;
		do
		{
			 System.out.println("Enter 1 if you are a student.. \n Enter 2 if you are a Librarian \n Enter 3 for Exit..");
			 Choice=Sc.nextInt();
			 
			 if(Choice==1)
			 {
				 System.out.println("Enter Your Roll Number :");
				 int Roll=Sc.nextInt();
				 
				 try
				 {
					 Student S=SM.SearchStudentByRoll(Roll);
					 if(S==null)
					 {
						 throw new StudentNotFoundException();
					 }
					 else
					 {
						 int Schoice;
						 do
						 {
							 System.out.println("Enter 1 For View all book from list..\n Enter 2 for Search book by subject.. \n Enter 3 for seach book by ISBN.. \n Enter 4 for issue a book.. \n Enter 5 for return a book.. \n Enter 99 for exit :");
							 Schoice=Sc.nextInt();
							 
							 switch(Schoice)
							 {
							 case 1:
								 System.out.println("view Your all book...");
								 BM.ViewAllBook();
								 break;
								 
							 case 2:
								 System.out.println("Search book by Subject name...");
								 
								 System.out.println("Enter subject name which you want to search :");
								 Sc.nextLine();
								 String SearchSubject=Sc.nextLine();							
								 BM.SearchBooksBySubject(SearchSubject);
								 break;
							 case 3:
								 System.out.println("Search book by isbn...");

								 System.out.println("Enter book ISBN number :");
								 int Search_ISBN=Sc.nextInt();
								 Book book=BM.SearchBook(Search_ISBN);
								 if(book==null)
								 {
									 System.out.println("No book of this ISBN number is in list..");
								 }
								 else
								 {
									 System.out.println(book);
								 }
								 break;
								 
							 case 4:
								 System.out.println("Issue a book..");
								 
								 System.out.println("Enter ISBN Number :");
								 int Issue_ISBN=Sc.nextInt();
								 book=BM.SearchBook(Issue_ISBN);
								 try {
									 if(book==null)
									 {
										 throw new  BookNotFoundException();
										 
									 }
									 if(book.getAvailable()>0)
									 {
										 book.setAvailable(book.getAvailable()-1);
										 System.out.println("Book has been issued..");
										 
									 }
									 else
									 {
										 System.out.println("Books not available");
									 }
								 }catch(BookNotFoundException BNFE)
								 {
									 System.out.println(BNFE);
								 }
								 
								 break;
							 case 5:
								 System.out.println("return a book..");
								 System.out.println("Enter ISBN Number :");
								 int Return_ISBN=Sc.nextInt();
								 book=BM.SearchBook(Return_ISBN);
								 
								 if(book!=null)
								 {
									 if(BTM.ReturnDate(Return_ISBN,Roll))
									 {
										 book.setAvailable(book.getAvailable()+1);
										 System.out.println("Book has been return..");
									 }
									 else
									 {
										 System.out.println("Book has not been return..");
									 }
										 
								 }
								 else
								 {
									 book.setAvailable(book.getAvailable()-1);
									 System.out.println("Book doesn't exits in library..");
								 }
								 break;
								
							 case 99:
								 System.out.println("Thank you for visit our library..");
								 break;
								 
							 default:
								 System.out.println("Invalid Choice");
								 
							
							
							 }
							 
						 }while(Schoice!=99);
						 
					 }
				 }catch(StudentNotFoundException SNFE)
				 {
					 System.out.println(SNFE);
				 }
						 
			 }
			 
			 
			 else if(Choice==2)
			 {
				 int LChoice;
				 do
				 {
					 System.out.println("Enter 11 to view all student.. \n Enter 12 to search student by their roll number \n Enter 13 to add a student in library.. \n Enter 14 to update a student.. \n Enter 15 to delete student from list..");
					 System.out.println("Enter 21 to view all book.. \n Enter 22 to search book by ISBN number \n Enter 23 to add a book in library.. \n Enter 24 to update a book.. \n Enter 25 to delete book from list..");
					 System.out.println("Enter 31 to view all transaction..");
					 System.out.println("Enter 99 for exist");
					 LChoice=Sc.nextInt();
					 
					 
					 switch(LChoice)
					 {
					 case 11:
						 System.out.println("View All Student..");
						 SM.ViewAllStudent();
						 break;
					 case 12:
						 System.out.println("Enter student Roll number :");
						 int Get_Roll=Sc.nextInt();
						 Student student=SM.SearchStudentByRoll(Get_Roll);
						 if(student==null)
						 {
							 System.out.println("No student of this roll number is list..");
						 }
						 else
						 {
							 System.out.println(student);
						 }
						 break;
					 case 13:
						 System.out.println("Enter Student detail to add :");
						 String name;
						 String emailId;
						 String phoneNumber;
						 String address;
						 String dOB;
						 int rollNo;
						 int std;
						 String section;
						 
						 Sc.nextLine();
						 
						 System.out.println("Enter student name :");
						 name=Sc.nextLine();
						 
						 System.out.println("Enter student email Id :");
						 emailId=Sc.nextLine();
						 
						 System.out.println("Enter student Phone number :");
						 phoneNumber=Sc.nextLine();
						 
						 System.out.println("Enter student address :");
						 address=Sc.nextLine();
						 
						 System.out.println("Enter student Date of Birth :");
						 dOB=Sc.nextLine();
						 
						 System.out.println("Enter student Roll Number :");
						 rollNo=Sc.nextInt();
						 
						 System.out.println("Enter student standard(Class) :");
						 std=Sc.nextInt();
						 
						 Sc.nextLine();
						 System.out.println("Enter student section :");
						 section=Sc.nextLine();
						 
						 
						 student =new Student(name, emailId, phoneNumber, address, dOB, rollNo, std, section);
						 SM.AddStudent(student);
						 System.out.println("Student added successfully..");
						 break;
						 
					 case 14:
						 System.out.println("Here you can update student profile :");
						 System.out.println("Enter student Roll number :");
						 int Update_Roll=Sc.nextInt();
						 student=SM.SearchStudentByRoll(Update_Roll);
						 
						 try
						 {
						 if(student==null)
						 {
							 throw new StudentNotFoundException();
						 }
						 
Sc.nextLine();
						 
						 System.out.println("Enter student name :");
						 name=Sc.nextLine();
						 
						 System.out.println("Enter student email Id :");
						 emailId=Sc.nextLine();
						 
						 System.out.println("Enter student Phone number :");
						 phoneNumber=Sc.nextLine();
						 
						 System.out.println("Enter student address :");
						 address=Sc.nextLine();
						 
						 System.out.println("Enter student Date of Birth :");
						 dOB=Sc.nextLine();
						 
						 System.out.println("Enter student standard(Class) :");
						 std=Sc.nextInt();
						 
						 Sc.nextLine();
						 
						 
						 System.out.println("Enter student section :");
						 section=Sc.nextLine();
						 
						 
						 SM.UpdateStudent(Update_Roll, name, emailId, phoneNumber, address, dOB, std, section);
						 System.out.println("Student updated sucessfully..");
						 
						 }catch(StudentNotFoundException SNFE )
						 {
							 System.out.println(SNFE);
						 }
						 break;
						 
					 case 15:
						 int Delete_Roll=Sc.nextInt();
						 student=SM.SearchStudentByRoll(Delete_Roll);
						 if(SM.DeleteStudent(Delete_Roll))
						 {
							 System.out.println("Student is removed from list sucessfully..");
						 }
						 else
						 {

							 System.out.println("No student of this roll number is list..");
						 }
						 break;
						 
					 case 21:
						 System.out.println("View All Books..");
						 BM.ViewAllBook();
						 break;
						 
					 case 22:
						 System.out.println("Here,you can seach a book by ISBN..");
						
						 System.out.println("Enter book ISBN number :");
						 int Get_ISBN=Sc.nextInt();
						 Book book=BM.SearchBook(Get_ISBN);
						 if(book==null)
						 {
							 System.out.println("No book of this ISBN number is in list..");
						 }
						 else
						 {
							 System.out.println(book);
						 }
						 break;
					 case 23:
						 System.out.println("Enter book details to add a book..:");
						 int iSBN_Number;
						 String book_Name;
						 String author;
						 String publisher;
						 int edition;
						 String subject;
						 int available;
						 
                         Sc.nextLine();
						 
						 System.out.println("Enter Book ISBN number :");
						 iSBN_Number=Sc.nextInt();
						 
						 Sc.nextLine();
						 System.out.println("Enter Book name :");
						 book_Name=Sc.nextLine();
						 
						 System.out.println("Enter Book author name:");
						 author=Sc.nextLine();
						 
						 System.out.println("Enter book publisher name :");
						 publisher=Sc.nextLine();
						 
						 System.out.println("Enter Book edition :");
						 edition=Sc.nextInt();								 
								 
						 Sc.nextLine();
						 
						 System.out.println("Enter book subject :");
						 subject=Sc.nextLine();
						 
						 System.out.println("Enter number of book copies avilable : :");
						 available=Sc.nextInt();
						  
						 book=new Book(iSBN_Number, book_Name,  author,  publisher,  edition,  subject,
			 available);
						 BM.addBook(book);
						 System.out.println("Book added successfully..");
						 break;
						 
					 case 24:
						 System.out.println("Here you can update any book...");
						 
						 System.out.println("Enter  Book ISBN number :");
						 int Update_ISBN=Sc.nextInt();
						 book=BM.SearchBook(Update_ISBN);
						 
						 
						 try
						 {
						    if(book==null)
						    {
						     	 throw new BookNotFoundException();
						 
						    }
						    Sc.nextLine();
							 System.out.println("Enter Book name :");
							 book_Name=Sc.nextLine();
							 
							 System.out.println("Enter Book author name:");
							 author=Sc.nextLine();
							 
							 System.out.println("Enter book publisher name :");
							 publisher=Sc.nextLine();
							 
							 System.out.println("Enter Book edition :");
							 edition=Sc.nextInt();								 
									 
							 Sc.nextLine();
							 
							 System.out.println("Enter book subject :");
							 subject=Sc.nextLine();
							 
							 System.out.println("Enter number of book copies avilable : :");
							 available=Sc.nextInt();
						    
							 
							 BM.UpdateBook(Update_ISBN,book_Name,  author,  publisher,  edition,  subject, available);
							 System.out.println("Book Updated successfully..");						 
						}catch(BookNotFoundException BNFE)
						 {
							 System.out.println(BNFE);
						 }
						 break;
						 
					 case 25:
						 System.out.println("Enter ISBN Number to delete the record..");
						 int DeleteISBN;
						 DeleteISBN=Sc.nextInt();
						 try {
							 book=BM.SearchBook(DeleteISBN);
							 if(book==null)
							 {
								 throw new BookNotFoundException();
								 
							 }
							 else
							 {
								 BM.DeleteBook(DeleteISBN);
								 System.out.println("Book Deleted Successfully..");
							 }
						 }catch(BookNotFoundException BNFE)
						 {
							 System.out.println(BNFE);
						 }
						 break;
					 case 31:
						    BTM.ShowAll();
						    break;

						case 32:
						    System.out.print("Enter Roll Number: ");
						    int rollNo1 = Sc.nextInt();
						    System.out.print("Enter ISBN Number: ");
						    int isbn = Sc.nextInt();

						    if (BTM.IssueDate(rollNo1, isbn)) 
						    {
						        System.out.println("Book issued successfully!");
						    } 
						    else 
						    {
						        System.out.println("Failed to issue the book. Check if the book is available or already issued.");
						    }
						    break;

						case 33: 
						    System.out.print("Enter Roll Number: ");
						    int returnRollNo = Sc.nextInt();
						    System.out.print("Enter ISBN Number: ");
						    int returnIsbn = Sc.nextInt();

						    if (BTM.ReturnDate(returnRollNo, returnIsbn)) 
						    {
						        System.out.println("Book returned successfully!");
						    } 
						    else 
						    {
						        System.out.println("Failed to return the book. Check if the book was issued or already returned.");
						    }
						    break;


								 
								 
						 
					default:
						System.out.println("Invalid choice..");
					 }
						 
				 }while(LChoice!=99);
				 
				 
			 }
		}while(Choice!=3);
		SM.writeToFile();
		BM.writeToFile();
		BTM.writeToFile();
		Sc.close();

	}

}



