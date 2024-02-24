package CodeSoft;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class CourseRegistrationSystem {

	
		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        Map<String, Course> courses = new HashMap<>();
		        List<Student> students = new ArrayList<>();

		        while (true) {
		            System.out.println("1. Add Course\n2. Register Student\n3. Display Courses\n4. Remove Course\n5. Exit");
		            int choice = scanner.nextInt();
		            scanner.nextLine(); // Consume newline character

		            switch (choice) {
		                case 1:
		                    System.out.println("Enter Course Code:");
		                    String code = scanner.nextLine();
		                    System.out.println("Enter Course Title:");
		                    String title = scanner.nextLine();
		                    System.out.println("Enter Course Description:");
		                    String description = scanner.nextLine();
		                    System.out.println("Enter Course Capacity:");
		                    int capacity = scanner.nextInt();
		                    Course course = new Course(code, title, description, capacity);
		                    courses.put(code, course);
		                    break;
		                case 2:
		                    System.out.println("Enter Student ID:");
		                    String studentId = scanner.nextLine();
		                    System.out.println("Enter Student Name:");
		                    String studentName = scanner.nextLine();
		                    System.out.println("Enter Course Code:");
		                    String courseCode = scanner.nextLine();
		                    Course selectedCourse = courses.get(courseCode);
		                    if (selectedCourse != null) {
		                        if (selectedCourse.registerStudent(studentId, studentName)) {
		                            students.add(new Student(studentId, studentName));
		                            System.out.println("Student registered successfully.");
		                        } else {
		                            System.out.println("Course is full.");
		                        }
		                    } else {
		                        System.out.println("Course not found.");
		                    }
		                    break;
		                case 3:
		                    System.out.println("Course Listing:");
		                    for (Course c : courses.values()) {
		                        System.out.println(c);
		                    }
		                    break;
		                case 4:
		                    System.out.println("Enter Student ID:");
		                    String sId = scanner.nextLine();
		                    System.out.println("Enter Course Code:");
		                    String cCode = scanner.nextLine();
		                    Course c = courses.get(cCode);
		                    if (c != null) {
		                        if (c.removeStudent(sId)) {
		                            System.out.println("Student removed successfully.");
		                        } else {
		                            System.out.println("Student not found in the course.");
		                        }
		                    } else {
		                        System.out.println("Course not found.");
		                    }
		                    break;
		                case 5:
		                    System.out.println("Exiting...");
		                    return;
		                default:
		                    System.out.println("Invalid choice.");
		            }
		        }
		    }
		}

		class Course {
		    private String code;
		    private String title;
		    private String description;
		    private int capacity;
		    private List<Student> enrolledStudents;

		    public Course(String code, String title, String description, int capacity) {
		        this.code = code;
		        this.title = title;
		        this.description = description;
		        this.capacity = capacity;
		        this.enrolledStudents = new ArrayList<>();
		    }

		    public boolean registerStudent(String studentId, String studentName) {
		        if (enrolledStudents.size() < capacity) {
		            enrolledStudents.add(new Student(studentId, studentName));
		            return true;
		        }
		        return false;
		    }

		    public boolean removeStudent(String studentId) {
		        for (Student s : enrolledStudents) {
		            if (s.getId().equals(studentId)) {
		                enrolledStudents.remove(s);
		                return true;
		            }
		        }
		        return false;
		    }

		    public String getCode() {
		        return code;
		    }

		    public String getTitle() {
		        return title;
		    }

		    public String getDescription() {
		        return description;
		    }

		    public int getCapacity() {
		        return capacity;
		    }

		    @Override
		    public String toString() {
		        return "Course{" +
		                "code='" + code + '\'' +
		                ", title='" + title + '\'' +
		                ", description='" + description + '\'' +
		                ", capacity=" + capacity +
		                ", enrolledStudents=" + enrolledStudents +
		                '}';
		    }
		}

		class Student {
		    private String id;
		    private String name;

		    public Student(String id, String name) {
		        this.id = id;
		        this.name = name;
		    }

		    public String getId() {
		        return id;
		    }

		    public String getName() {
		        return name;
		    }
		


	}


