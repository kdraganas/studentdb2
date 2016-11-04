import java.io.Serializable;

public class StudentSystem implements Serializable{
	private String studentNumber;
	private String firstName;
	private char middleInitial;
	private String lastName;
	private String course;
	private int yearLevel;
	private Course favSubject;
	private String cName;

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String toString() {
		return "Student Number: "+studentNumber+"\nName: "+lastName+", "+firstName+" "+middleInitial+".\nProgram: "+course+"\nYear Level: "+yearLevel+"\n"+"Crush Name: "+cName+"\nFavorite Course and Description: "+favSubject.toString();
	}

	public StudentSystem(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel, String cName, String cCourse, String cDescription){
		setStudentNumber(studentNumber);
		setFirstName(firstName);
		setMiddleInitial(middleInitial);
		setLastName(lastName);
		setCourse(course);
		setYearLevel(yearLevel);
		setcName(cName);
		setFavSubject(cCourse,cDescription);
	}

	public void setStudentNumber(String studentNumber){	this.studentNumber = studentNumber; }
	public void setFirstName(String firstName){		this.firstName = firstName;	}
	public void setMiddleInitial(char middleInitial){		this.middleInitial = middleInitial;	}
	public void setLastName(String lastName){		this.lastName = lastName;	}
	public void setCourse(String course){		this.course = course;	}
	public void setYearLevel(int yearLevel){		this.yearLevel = yearLevel;	}
	public void setFavSubject(String cCourse, String cDescription){
		favSubject = new Course(cCourse,cDescription);
	}

	public String getStudentNumber(){		return studentNumber;	}
	public String getFirstName(){		return firstName;	}
	public char getMiddleInitial(){		return middleInitial;	}
	public String getLastName(){		return lastName;	}
	public String getCourse(){		return course;	}
	public int getYearLevel(){		return yearLevel;	}
	public Course getFavSubject(){		return favSubject;		}
}