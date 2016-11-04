import java.io.Serializable;

public class Course implements Serializable{
    private String cCourse;
    private String cDescription;

    public Course(String cCourse, String cDescription){
        this.cCourse = cCourse;
        this.cDescription = cDescription;
    }

    public String getcCourse() {
        return cCourse;
    }

    public void setcCourse(String cCourse) {
        this.cCourse = cCourse;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    @Override
    public String toString() {
        return cCourse +" "+ cDescription;
    }
}
