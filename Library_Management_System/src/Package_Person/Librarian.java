package Package_Person;


public class Librarian extends Person{
      private int id;
      private String DateOfJoining;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateOfJoining() {
		return DateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		DateOfJoining = dateOfJoining;
	}
	public Librarian(String name, String emailId, String phoneNumber, String address, String dOB, int id,
			String dateOfJoining) {
		super(name, emailId, phoneNumber, address, dOB);
		this.id = id;
		DateOfJoining = dateOfJoining;
	}
	public Librarian(String name, String emailId, String phoneNumber, String address, String dOB) {
		super(name, emailId, phoneNumber, address, dOB);
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", DateOfJoining=" + DateOfJoining + ", Name=" + Name + ", EmailId=" + EmailId
				+ ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", DOB=" + DOB + "]";
	}
      
      
}


