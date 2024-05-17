import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {
    public static class Course {
        int code;
        String title;
        String description;
        long capacity;
        ArrayList<String> schedule;

        public Course(int code, String title, String description, long capacity, ArrayList<String> schedule) {
            this.code = code;
            this.title = title;
            this.description = description;
            this.capacity = capacity;
            this.schedule = new ArrayList<>();
        }
    }

    public static class Student {
        int student_ID;
        String name;
        ArrayList<Course> registeredCourses;

        public Student(int student_ID, String name) {
            this.student_ID = student_ID;
            this.name = name;
            this.registeredCourses = new ArrayList<>();
        }

        public void registerCourse(Course course) {
            if (registeredCourses.size() < 5 && !registeredCourses.contains(course)) {
                registeredCourses.add(course);
                System.out.println(name + " registered for course: " + course.title);
            } else {
                System.out.println("Registration failed for " + name + ": Course limit reached or already registered.");
            }
        }

        public void removeCourse(Course course) {
            if (registeredCourses.contains(course)) {
                registeredCourses.remove(course);
                System.out.println(name + " removed course: " + course.title);
            } else {
                System.out.println("Removal failed for " + name + ": Course not found.");
            }
        }

        public void displayRegisteredCourses() {
            if (registeredCourses.isEmpty()) {
                System.out.println(name + " has not registered for any courses.");
            } else {
                System.out.println(name + "'s registered courses:");
                for (Course course : registeredCourses) {
                    System.out.println(course.title);
                }
            }
        }
    }

    public static void displayCourses(ArrayList<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("Available courses:");
            for (Course course : courses) {
                System.out.println("Code: " + course.code + ", Title: " + course.title);
            }
        }
    }

    // Method to display courses of a specific student
    public static void displayStudentCourses(Student student) {
        student.displayRegisteredCourses();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        Student student1=new Student(1,"Alice");
        Student student2=new Student(2,"BOB");
        students.add(student1);
        students.add(student2);

        courses.add(new Course(1, "Mathematics", "Introductory Mathematics", 50, new ArrayList<>()));
        courses.add(new Course(2, "Physics", "Basic Physics", 40, new ArrayList<>()));
        courses.add(new Course(3, "Biology", "Introduction to Biology", 30, new ArrayList<>()));

        int choice;
        boolean Exit=false;
            while (!Exit) {
                System.out.println("Menu:");
                System.out.println("1. Display Courses");
                System.out.println("2. Display Students");
                System.out.println("3. Register Student for Course");
                System.out.println("4. Remove Student from Course");
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");
                
                choice = scanner.nextInt(); 
                
                switch (choice) {
                    case 1:
                        displayCourses(courses);
                        break;
                    case 2:
                        if (students.isEmpty()) {
                            System.out.println("Students not available!");
                        } else {
                            for (int i = 0; i < students.size(); i++) {
                                int studentid = students.get(i).student_ID;
                                String studentname = students.get(i).name;
                                System.out.println("Student ID: " + studentid + " Student Name: " + studentname);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter student id : ");
                        int id=scanner.nextInt();
                        System.out.println("Enter course code : ");
                        int code =scanner.nextInt();

                        Student selectstudent=null;
                        for(Student student:students){
                            if(student.student_ID==id){
                                selectstudent=student;
                                break;
                            }
                        }
                            if(selectstudent!=null){
                                for(Course course:courses){
                                    if(course.code==code){}
                                    selectstudent.registeredCourses.add(course);
                                    break;
                                }
                            }
                            else{
                                System.out.println("Student not found!");
                            }

                        break;
                    case 4:
                    System.out.println("Enter student ID: ");
                    int removeStudentID = scanner.nextInt();
                    System.out.println("Enter course code: ");
                    int removeCourseCode = scanner.nextInt();
                    Student removeSelectedStudent = null;
                    for (Student student : students) {
                       if (student.student_ID == removeStudentID) {
                            removeSelectedStudent = student;
                          break;
                        }
                    }
                    if (removeSelectedStudent != null) {
                        for (Course course : courses) {
                            if (course.code == removeCourseCode) {
                                removeSelectedStudent.removeCourse(course);
                                 break;
                            }
                        }
                    }
                     else {
                        System.out.println("Student not found.");
                    }
                    break;
                    case 5:
                    Exit=true;
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
    
            scanner.close();
    }
}
