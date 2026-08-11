/*
Course: BIT504
Name: Thilini Amarasekara
Student ID: 5109653
Assessment: 01 
*/

package studentreport;

import java.util.ArrayList;

public class Report {
	
	public static void printHeader() {

	    System.out.println("ID\tName\t\tM\tA\tH\tS\tG\tE\tL\tAvg");
	    System.out.println("-----------------------------------------------------------------------------------------------------");

	}

	    public static String getGrade(double mark) {

	        if (mark < 50)
	            return "E";
	        else if (mark < 60)
	            return "D";
	        else if (mark < 70)
	            return "C";
	        else if (mark < 85)
	            return "B";
	        else
	            return "A";
	    }

	    public static double getCourseAverage(ArrayList<Student> students, String courseName) {

	        int total = 0;

	        for (Student s : students) {
	            total += s.getCourseMark(courseName);
	        }

	        return (double) total / students.size();
	    }
	    
	    public static void displayAllStudents(ArrayList<Student> students) {

	        printHeader();

	        for (Student s : students) {

	            System.out.println(
	                    s.getStudentID() + "\t" +
	                    s.getFullName() + "\t" +
	                    s.getCourseMark("Mathematics") + "\t" +
	                    s.getCourseMark("Art") + "\t" +
	                    s.getCourseMark("History") + "\t" +
	                    s.getCourseMark("Science") + "\t" +
	                    s.getCourseMark("Geography") + "\t" +
	                    s.getCourseMark("Economics") + "\t" +
	                    s.getCourseMark("Literature") + "\t" +
	                    s.getAverageMark()
	            );

	        }

	    }
	    
	    public static void displayStudentById(ArrayList<Student> students, String id) {

	        boolean found = false;

	        for (Student s : students) {

	            if (s.getStudentID().equals(id)) {

	                printHeader();

	                System.out.println(
	                        s.getStudentID() + "\t" +
	                        s.getFullName() + "\t" +
	                        s.getCourseMark("Mathematics") + "\t" +
	                        s.getCourseMark("Art") + "\t" +
	                        s.getCourseMark("History") + "\t" +
	                        s.getCourseMark("Science") + "\t" +
	                        s.getCourseMark("Geography") + "\t" +
	                        s.getCourseMark("Economics") + "\t" +
	                        s.getCourseMark("Literature") + "\t" +
	                        s.getAverageMark()
	                );

	                found = true;
	            }
	        }

	        if (!found) {
	            System.out.println("Student not found.");
	        }
	    }
	    
	    public static void displayTopStudents(ArrayList<Student> students) {

	        String[] courses = {
	                "Mathematics",
	                "Art",
	                "History",
	                "Science",
	                "Geography",
	                "Economics",
	                "Literature"
	        };

	        for (String course : courses) {

	            int highest = -1;

	            // find highest mark
	            for (Student s : students) {

	                int mark = s.getCourseMark(course);

	                if (mark > highest) {
	                    highest = mark;
	                }
	            }

	            // print course name
	            System.out.println("\n" + course + ":");

	            // print student(s) with highest mark
	            for (Student s : students) {

	                if (s.getCourseMark(course) == highest) {
	                    System.out.println(s.getFullName() + " " + highest);
	                }

	            }

	        }
	          
	    }
	    
	    public static void displayClassReport(ArrayList<Student> students) {

	        String[] courses = {
	                "Mathematics",
	                "Art",
	                "History",
	                "Science",
	                "Geography",
	                "Economics",
	                "Literature"
	        };

	        System.out.println("\n===== CLASS REPORT =====");

	        System.out.println("Total students: " + students.size());

	        System.out.printf("\n%-12s %6s %6s\n", "Average:", "Mark", "Grade");

	        for (String course : courses) {

	            double avg = getCourseAverage(students, course);

	            String grade = getGrade(avg);

	            System.out.printf("%-12s %6d %6s\n", course + ":", (int) avg, grade);
	        }
	    }

}
