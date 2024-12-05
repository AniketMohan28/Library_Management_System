package Package_Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

public class StudentManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient ObjectOutputStream OOS_Student = null;
    private transient ObjectInputStream OIS_Student = null;

    File StudentFile = new File("Student.txt");
    ArrayList<Student> StudentList = new ArrayList<>();

    
    @SuppressWarnings("unchecked")
    public StudentManager() {
        if (StudentFile.exists() && StudentFile.length() > 0) { // Check file length to ensure it's not empty
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(StudentFile))) {
                StudentList = (ArrayList<Student>) ois.readObject();
                System.out.println("Loaded students from file: " + StudentList);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No existing student file found. Starting fresh.");
        }
    }


    public void ViewAllStudent() {
        for (Student student : StudentList) {
            System.out.println(student);
        }
    }

    public void AddStudent(Student student) {
        StudentList.add(student);
        System.out.println("Added student: " + student);
        writeToFile();
    }

    public Student SearchStudentByRoll(int roll) {
        for (Student student : StudentList) {
            if (student.getRollNo() == roll) {
                return student;
            }
        }
        return null;
    }

    public boolean DeleteStudent(int roll) {
        ListIterator<Student> StudentIterator = StudentList.listIterator();
        while (StudentIterator.hasNext()) {
            Student student = StudentIterator.next();
            if (student.getRollNo() == roll) {
                StudentIterator.remove();
                writeToFile();
                return true;
            }
        }
        return false;
    }

    public boolean UpdateStudent(int updateRoll, String name, String emailId, String phoneNumber, String address, String DOB, int std, String section) {
        ListIterator<Student> StudentIterator = StudentList.listIterator();
        while (StudentIterator.hasNext()) {
            Student student = StudentIterator.next();
            if (student.getRollNo() == updateRoll) {
                student.setRollNo(updateRoll);
                student.setName(name);
                student.setEmailId(emailId);
                student.setPhoneNumber(phoneNumber);
                student.setAddress(address);
                student.setDOB(DOB);
                student.setStd(std);
                student.setSection(section);
                writeToFile();
                return true;
            }
        }
        return false;
    }

    /*public void writeToFile() {
        try {
            OOS_Student = new ObjectOutputStream(new FileOutputStream(StudentFile));
            OOS_Student.writeObject(StudentList);
            OOS_Student.close();
            System.out.println("Saved students to file: " + StudentList);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }*/
    public void writeToFile() {
        if (StudentList.isEmpty()) {
            System.out.println("Student list is empty. Nothing to save.");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(StudentFile))) {
            oos.writeObject(StudentList);
            System.out.println("Saved students to file: " + StudentList);
        } catch (IOException e) {
            System.err.println("Error saving student data: " + e.getMessage());
        }
    }

}

