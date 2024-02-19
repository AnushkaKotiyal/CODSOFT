import java.util.*;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int enrolled;

    public Course(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
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

    public int getEnrolled() {
        return enrolled;
    }

    public boolean enrollStudent() {
        if (enrolled < capacity) {
            enrolled++;
            return true;
        } else {
            return false;
        }
    }

    public void dropStudent() {
        enrolled--;
    }

    @Override
    public String toString() {
        return "Code: " + code + ", Title: " + title + ", Description: " + description + ", Capacity: " + capacity
                + ", Enrolled: " + enrolled;
    }
}

class Student {
    private int id;
    private String name;
    private List<String> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

public class CourseRegistrationSystem {
    private Map<String, Course> courses;
    private Map<Integer, Student> students;

    public CourseRegistrationSystem() {
        this.courses = new HashMap<>();
        this.students = new HashMap<>();
    }

    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void displayAvailableCourses() {
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }

    public void registerStudent(int studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (student != null && course != null && course.enrollStudent()) {
            student.registerCourse(courseCode);
            System.out.println("Student " + student.getName() + " registered for course " + course.getTitle());
        } else {
            System.out.println("Registration failed. Please check student ID or course code.");
        }
    }

    public void dropCourse(int studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (student != null && course != null) {
            student.dropCourse(courseCode);
            course.dropStudent();
            System.out.println("Student " + student.getName() + " dropped course " + course.getTitle());
        } else {
            System.out.println("Drop failed. Please check student ID or course code.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        // courses
        Course c1 = new Course("CSE101", "Introduction to Computer Science", "Basic concepts of programming", 30);
        Course c2 = new Course("MAT201", "Linear Algebra", "Fundamental concepts of linear algebra", 25);
        Course c3 = new Course("ENG101", "English Composition", "Writing skills development", 20);
        Course c4 = new Course("HIS201", "World History", "Overview of global historical events", 35);
        Course c5 = new Course("SCI301", "Introduction to Physics", "Basic principles of physics", 25);
        system.addCourse(c1);
        system.addCourse(c2);
        system.addCourse(c3);
        system.addCourse(c4);
        system.addCourse(c5);
        // students
        Student s1 = new Student(1, "Anushka");
        Student s2 = new Student(2, "Astha");
        Student s3 = new Student(3, "Seema");
        Student s4 = new Student(4, "Nikita");
        Student s5 = new Student(5, "Janvi");
        Student s6 = new Student(6, "Sneha");
        Student s7 = new Student(7, "Baronika");
        Student s8 = new Student(8, "Indu");
        Student s9 = new Student(9,"kartik");
        Student s10 = new Student(10,"john");
        system.addStudent(s1);
        system.addStudent(s2);
        system.addStudent(s3);
        system.addStudent(s4);
        system.addStudent(s5);
        system.addStudent(s6);
        system.addStudent(s7);
        system.addStudent(s8); 
        int choice;
        do {
            System.out.println("\n1. Register Student");
            System.out.println("2. Add New Course");
            System.out.println("3. Remove Student");
            System.out.println("4. Remove Course");
            System.out.println("5. Display Available Courses");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    system.registerStudent(studentId, courseCode);
                    break;
                    case 2:
                    System.out.print("Enter course code: ");
                    String code = scanner.next();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter course title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter course description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter course capacity: ");
                    int capacity = scanner.nextInt();
                    system.addCourse(new Course(code, title, description, capacity));
                    system.displayAvailableCourses(); // Display available courses after adding a new course
                    break;                
                case 3:
                    System.out.print("Enter student ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    system.students.remove(idToRemove);
                    System.out.println("Student with ID " + idToRemove + " removed.");
                    break;
                case 4:
                    System.out.print("Enter course code to remove: ");
                    String courseToRemove = scanner.next();
                    system.courses.remove(courseToRemove);
                    System.out.println("Course with code " + courseToRemove + " removed.");
                    break;
                case 5:
                    System.out.println("Available Courses:");
                    system.displayAvailableCourses();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
