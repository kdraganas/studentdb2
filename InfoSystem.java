import java.io.*;
import java.util.*;

public class InfoSystem{
	private static final String FILE_NAME = "F:\\COMPUTER SCIENCE\\CMSC 22\\studentser\\db.txt";

	public static void main(String[] args) throws IOException {
		List <StudentSystem> listOfStudents = new ArrayList<StudentSystem>();
		String studentNumber, firstName, lastName, course, middleInitial, cCourse, cDescription;
		char middleIn;
		int yearLevel;
		Scanner sc = new Scanner(System.in);
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			File f = new File(FILE_NAME);
			fis = new FileInputStream(f);
			if(f.length()==0){
				listOfStudents = new ArrayList<StudentSystem>();
			} else {
				ois = new ObjectInputStream(fis);
				listOfStudents = (List <StudentSystem>) ois.readObject();
				ois.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		int choice;
		do{
			System.out.println("STUDENT INFORMATION SYSTEM");
			System.out.println("1 - REGISTER\n2 - INFORMATION\n3 - DELETE\n4 - SAVE\n5 - EDIT\n6 - EXIT\n");
			choice = sc.nextInt();
			if (choice == 1){
				System.out.println("Student Number: ");
				studentNumber = sc.next();
				register(listOfStudents, studentNumber, sc);
			}
			else if (choice == 2){
				System.out.print("Student Number: ");
				studentNumber = sc.next();
				search(listOfStudents, studentNumber);
			}
			else if (choice == 3){
				System.out.print("Student Number: ");
				studentNumber = sc.next();
				delete(listOfStudents, studentNumber);
			}
			else if (choice == 4){
				save(listOfStudents);
			}
			else if (choice == 5){
				System.out.println("Student Number: ");
				studentNumber = sc.next();
				edit(listOfStudents, studentNumber, sc);
			}
			else{
				System.out.println("Au revoir! A bientot!");
				break;
			}
		}while (choice<=6 && choice>=1);
	}

	public static void save(List<StudentSystem> listOfStudents){
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			File fout = new File(FILE_NAME);
			fos = new FileOutputStream(fout);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(listOfStudents);
			oos.close();
		}
		catch(IOException e){
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void register(List<StudentSystem> listOfStudents, String studentNumber, Scanner sc){
		String firstName, lastName, course, cCourse, cDescription, cName;
		char middleIn;
		int yearLevel;
		if (listOfStudents.contains(studentNumber)){
			System.out.println("The student number exist.");
		}
		else{
			System.out.println("First Name: ");
			firstName = sc.next();
			System.out.println("Middle Initial: ");
			if (sc.nextLine().equals("")){
				middleIn = 32;
			}
			middleIn = sc.next().charAt(0);

			System.out.println("Last Name: ");
			lastName = sc.next();
			System.out.println("Course: ");
			course = sc.next();
			System.out.println("Year Level: ");
			yearLevel = sc.nextInt();
			System.out.println("Crush Name: ");
			cName = sc.next();
			System.out.println("Course Code & Description: ");
			cCourse = sc.next();
			cDescription = sc.next();

			StudentSystem ss2 = new StudentSystem(studentNumber, firstName, middleIn, lastName, course, yearLevel, cName, cCourse, cDescription);
			listOfStudents.add(ss2);
			System.out.println("Student Added!");
		}
	}
	public static void search(List<StudentSystem> listOfStudents, String studentNumber){
		boolean flag = false;
		for(StudentSystem s: listOfStudents){
			if(s.getStudentNumber().equals(studentNumber)){
				System.out.println(s);
				flag = true;
			}
		}
		if (!flag){
			System.out.println("The student number " + studentNumber + " does not exist.");
		}
	}
	public static void delete(List<StudentSystem> listOfStudents, String studentNumber){
		boolean flag = false;
		for(StudentSystem s: listOfStudents){
			if(s.getStudentNumber().equals(studentNumber)){
				listOfStudents.remove(s);
				flag = true;
				break;
			}
		}
		if (!flag){
			System.out.println("The student number " + studentNumber + " does not exist.");
		}
	}
	public static void edit(List<StudentSystem> listOfStudents, String studentNumber, Scanner sc){
		String firstName, lastName, course, cCourse, cDescription, cName;
		char middleIn;
		int yearLevel;
		boolean flag = false;
		for(StudentSystem s: listOfStudents){
			if(s.getStudentNumber().equals(studentNumber)){
				System.out.println("Change First Name: ");
				firstName = sc.next();
				s.setFirstName(firstName);
				System.out.println("Change Middle Initial: ");
				middleIn = sc.next().charAt(0);
				s.setMiddleInitial(middleIn);
				System.out.println("Change Last Name: ");
				lastName = sc.next();
				s.setLastName(lastName);
				System.out.println("Change Course: ");
				course = sc.next();
				s.setCourse(course);
				System.out.println("Change Year Level: ");
				yearLevel = sc.nextInt();
				s.setYearLevel(yearLevel);
				System.out.println("Change Crush Name: ");
				cName = sc.next();
				s.setcName(cName);
				System.out.println("Change Favorite Course and its Course Description: ");
				cCourse = sc.next();
				cDescription = sc.next();
				s.setFavSubject(cCourse,cDescription);

				System.out.println("Updated a student!");
				flag = true;
			}
		}
		if (!flag){
			System.out.println("The student number " + studentNumber + " does not exist.");
		}
	}
}