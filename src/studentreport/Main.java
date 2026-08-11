/*
Course: BIT504
Name: Thilini Amarasekara
Student ID: 5109653
Assessment: 01 
*/

package studentreport;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Student> students = new ArrayList<>();
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

	    System.out.println("Student Report System");

	    loadStudents();

	    int choice = 0;

	    while (choice != 5) {

	        showMenu();

	        choice = input.nextInt();

	        switch (choice) {

	            case 1:
	            	Report.displayAllStudents(students);
	                break;

	            case 2:

	                System.out.print("Enter Student ID: ");
	                String id = input.next();

	                Report.displayStudentById(students, id);

	                break;

	            case 3:
	                Report.displayTopStudents(students);
	                break;

	            case 4:
	                Report.displayClassReport(students);
	                break;

	            case 5:
	                System.out.println("Exiting program...");
	                break;

	            default:
	                System.out.println("Invalid option. Please try again.");

	        }

	    }

	}
	
	public static void loadStudents() {

	    students = Database.loadAllStudents();

	}	
	
	public static void showMenu() {

	    System.out.println("\n===== STUDENT REPORT MENU =====");
	    System.out.println("1. Display all students");
	    System.out.println("2. Display individual student information");
	    System.out.println("3. Display top student for each course");
	    System.out.println("4. Display class report");
	    System.out.println("5. Exit");
	    System.out.print("Enter your choice: ");

	}	

}
