import java.util.ArrayList;

class studentCourse{
    protected String courseCode;
    protected String title;
    protected String description;
    protected int enrollStudents;
    protected int capacity;
    protected String schedule;

    public studentCourse(String courseCode, String title, String description, int capacity, String schedule){
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrollStudents = 0;
        this.schedule = schedule;
    }

    public boolean enrollStudent(){
        if(enrollStudents < capacity){
            enrollStudents++;
            return true;
        } else {
            System.out.println("Course is full: " + title);
            return false;
        }
    }

    public boolean dropStudent(){
        if(enrollStudents > 0){
            enrollStudents--;
            return true;
        } else {
            System.out.println("No student to drop from: " + title);
            return false;
        }
    }

    public void displayCourseDetails(){
        System.out.println("Course Code: " + courseCode);
        System.out.println("Title of the Course: " + title);
        System.out.println("Course Description: " + description);
        System.out.println("Schedule of the course: " + schedule);
        System.out.println("Course Capacity: " + capacity);
        System.out.println("Enrolled Students in the Course: " + enrollStudents);
        System.out.println("Available Slots in the Course: " + (capacity - enrollStudents));
    }

    
    static class Student {
        private String studentID;
        private String name;
        private ArrayList<studentCourse> registeredCourses;

        public Student(String studentID, String name){
            this.studentID = studentID;
            this.name = name;
            this.registeredCourses = new ArrayList<>();
        }

        public void registerCourse(studentCourse course){
            if(course.enrollStudent()){
                registeredCourses.add(course);
                System.out.println(name + " registered for course: " + course.title);
            } else {
                System.out.println("Registration failed for course: " + course.title);
            }
        }

        public void dropCourse(studentCourse course){
            if(registeredCourses.contains(course) && course.dropStudent()){
                registeredCourses.remove(course);
                System.out.println(name + " dropped course: " + course.title);
            } else {
                System.out.println(name + " is not registered for course " + course.title);
            }
        }

        public void displayRegisteredCourses(){
            System.out.println("Student: " + name + " | ID: " + studentID);
            if(registeredCourses.isEmpty()){
                System.out.println("No registered courses...");
            } else {
                System.out.println("Registered Courses: ");
                for(studentCourse course : registeredCourses){
                    course.displayCourseDetails();
                }
            }
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        
        studentCourse course1 = new studentCourse("CS101", "Introduction to Computer Science", "Basics of programming", 30, "Mon 10AM");
        studentCourse course2 = new studentCourse("MATH101", "Calculus I", "Differentiation and Integration", 40, "Tue 2PM");
        
        studentCourse.Student student1 = new studentCourse.Student("S001", "Alice");
      
        System.out.println("Available Courses:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();

        student1.registerCourse(course1);
        student1.registerCourse(course2);

        student1.displayRegisteredCourses();

        student1.dropCourse(course1);

        student1.displayRegisteredCourses();
    }
}
