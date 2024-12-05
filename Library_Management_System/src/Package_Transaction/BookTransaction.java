package Package_Transaction;
import java.io.Serializable;

public class BookTransaction implements Serializable {
	private static final long serialVersionUID = 1L;
     private int RollNo;
     private int ISBN;
     private String IssueDate;
     private String ReturnDate;
	public int getRollNo() {
		return RollNo;
	}
	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getIssueDate() {
		return IssueDate;
	}
	public void setIssueDate(String issueDate) {
		IssueDate = issueDate;
	}
	public String getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}
	public BookTransaction(int rollNo, int iSBN, String issueDate, String returnDate) {
		super();
		RollNo = rollNo;
		ISBN = iSBN;
		IssueDate = issueDate;
		ReturnDate = returnDate;
	}
	public BookTransaction() {
		super();
	}
	@Override
	public String toString() {
		return "BookTransaction [RollNo=" + RollNo + ", ISBN=" + ISBN + ", IssueDate=" + IssueDate + ", ReturnDate="
				+ ReturnDate + "]";
	}
	
     
}


