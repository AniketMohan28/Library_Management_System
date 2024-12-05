/*package Package_Person;

public class Student extends Person {
	private int RollNo;
    private int Std;
    private String Section;
	public int getRollNo() {
		return RollNo;
	}
	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}
	public int getStd() {
		return Std;
	}
	public void setStd(int std) {
		Std = std;
	}
	public String getSection() {
		return Section;
	}
	public void setSection(String section) {
		Section = section;
	}
	public Student(String name, String emailId, String phoneNumber, String address, String dOB, int rollNo, int std,
			String section) {
		super(name, emailId, phoneNumber, address, dOB);
		RollNo = rollNo;
		Std = std;
		Section = section;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [RollNo=" + RollNo + ", Std=" + Std + ", Section=" + Section + ", Name=" + Name + ", EmailId="
				+ EmailId + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", DOB=" + DOB + "]";
	}
    
	
    
	
    
}*/
package Package_Person;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes

    private int RollNo;
    private int Std;
    private String Section;

    public Student(String name, String emailId, String phoneNumber, String address, String dOB, int rollNo, int std, String section) {
        super(name, emailId, phoneNumber, address, dOB);
        RollNo = rollNo;
        Std = std;
        Section = section;
    }

    public Student() {
        super();
    }

    public int getRollNo() {
        return RollNo;
    }

    public void setRollNo(int rollNo) {
        RollNo = rollNo;
    }

    public int getStd() {
        return Std;
    }

    public void setStd(int std) {
        Std = std;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    @Override
    public String toString() {
        return "Student [RollNo=" + RollNo + ", Std=" + Std + ", Section=" + Section + ", Name=" + Name + ", EmailId=" + EmailId + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", DOB=" + DOB + "]";
    }
}





