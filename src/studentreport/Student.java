/*
Course: BIT504
Name: Thilini Amarasekara
Student ID: 5109653
Assessment: 01 
*/

package studentreport;

import java.util.ArrayList;


public class Student {
	 private String studentID;
	    private String firstName;
	    private String lastName;
	    private ArrayList<Course> courses;

	    public Student(String studentID, String firstName, String lastName) {

	        this.studentID = studentID;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.courses = new ArrayList<>();
	    }

	    public void addCourse(Course course) {
	        courses.add(course);
	    }

	    public String getFullName() {
	        return firstName + " " + lastName;
	    }

	    public double getAverageMark() {

	        int total = 0;

	        for (Course c : courses) {
	            total += c.getMark();
	        }

	        return (double) total / courses.size();
	    }

	    public int getCourseMark(String courseName) {

	        for (Course c : courses) {
	            if (c.getCourseName().equalsIgnoreCase(courseName)) {
	                return c.getMark();
	            }
	        }

	        return -1;
	    }

	    public String getStudentID() {
	        return studentID;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public ArrayList<Course> getCourses() {
	        return courses;
	    }

}
