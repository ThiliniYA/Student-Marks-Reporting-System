/*
Course: BIT504
Name: Thilini Amarasekara
Student ID: 5109653
Assessment: 01 
*/

package studentreport;

public class Course {
	
	private String courseName;
	
    private int mark;

    public Course(String courseName, int mark) {
    	
        this.courseName = courseName;
        
        this.mark = mark;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

}
