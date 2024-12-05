/*package Package_Person;


public class Person {
      protected String  Name;
      protected String EmailId;
      protected String PhoneNumber;
      protected String Address;
      protected String DOB;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public Person(String name, String emailId, String phoneNumber, String address, String dOB) {
		super();
		Name = name;
		EmailId = emailId;
		PhoneNumber = phoneNumber;
		Address = address;
		DOB = dOB;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [Name=" + Name + ", EmailId=" + EmailId + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address
				+ ", DOB=" + DOB + "]";
	}
      
      
}*/

package Package_Person;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes

    protected String Name;
    protected String EmailId;
    protected String PhoneNumber;
    protected String Address;
    protected String DOB;

    public Person(String name, String emailId, String phoneNumber, String address, String dOB) {
        Name = name;
        EmailId = emailId;
        PhoneNumber = phoneNumber;
        Address = address;
        DOB = dOB;
    }

    public Person() {}

    // Getters and setters
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    @Override
    public String toString() {
        return "Person [Name=" + Name + ", EmailId=" + EmailId + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", DOB=" + DOB + "]";
    }
}





