package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        String retunrValue = "";
        if (students.size() < getCapacity()) {
            if (students.contains(student)) {
                return retunrValue = "Student is already in the university";
            }
            students.add(student);
            return retunrValue = String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }
        return retunrValue = "No seats in the university";
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student1 : students) {
            if (student1.getFirstName().equals(firstName) && student1.getLastName().equals(lastName)) {
                return student1;
            }
        }
            return null;
    }

    public String getStatistics() {
        StringBuilder sb= new StringBuilder();
        for (Student student : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s"
                    ,student.getFirstName(),student.getLastName(),student.getBestSubject())).append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}
