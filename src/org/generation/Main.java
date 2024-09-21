package org.generation;

import org.generation.classes.Student;
import org.generation.classes.StudentService;
import org.generation.exceptions.CourseNotFoundException;
import org.generation.exceptions.StudentNotFoundException;

public class Main {

    public static void main(String[] args) {
	    StudentService studentService = new StudentService();
	    //TODO refactor this code to use encapsulation inside studentsService
        studentService.setStudents(new Student( "Carlos", "1030", 31 ) );
        studentService.setStudents(new Student( "Ian", "1040", 28 ) );
        studentService.setStudents(new Student( "Elise", "1050", 26 ) );
        studentService.setStudents(new Student( "Santiago", "1020", 33 ) );
        
        enrollStudents(studentService, "Math", "1030" );
	    enrollStudents(studentService, "Biology", "1030" );
	    enrollStudents(studentService, "Biology", "1020" );
	    enrollStudents(studentService, "Biolog", "2020" );
	    enrollStudents(studentService, "Biology", "2000" );

        studentService.showAllCourses();
        studentService.showEnrolledStudents("Biology");
        studentService.showEnrolledStudents("Math");
    }
    
    private static void enrollStudents(StudentService studentService, String courseID, String studentID) {
    	try {
	        studentService.enrollStudents( courseID, studentID );
        } catch(CourseNotFoundException |  StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        }
    }
}
