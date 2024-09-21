package org.generation.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.generation.exceptions.CourseNotFoundException;
import org.generation.exceptions.StudentNotFoundException;


public class StudentService
{
    private HashMap<String, Course> courseList = new HashMap<>();

    private HashMap<String, Student> students = new HashMap<>();

    private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    public StudentService(){
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    }

    public void enrollStudents( String courseName, String studentID ) throws CourseNotFoundException, StudentNotFoundException{
    	if(!courseList.containsKey(courseName)) {
    		throw new CourseNotFoundException("Course not found! [" + courseName + "]");
    	}
    	if(!students.containsKey(studentID)) {
    		throw new StudentNotFoundException("Course not found! [" + studentID + "]");
    	}
    	Course course = courseList.get(courseName);
		if ( !coursesEnrolledByStudents.containsKey( studentID ) ){
            coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        }
        coursesEnrolledByStudents.get( studentID ).add( course );
    }

    public void unEnrollStudents( String courseName, String studentID ){
        Course course = courseList.get( courseName );

        if ( coursesEnrolledByStudents.containsKey( studentID ) ){
            coursesEnrolledByStudents.get( studentID ).remove( course );
        }
    }

    public void showEnrolledStudents(String courseId){
        //TODO implement using collections loops
    	Course course = courseList.get( courseId );
    	System.out.println("Students enrolled in  " + course.getName());
    	for(String key : coursesEnrolledByStudents.keySet()) {
    		if(coursesEnrolledByStudents.get(key).contains(course)) {
    			System.out.println(students.get(key));
    		}
    		
    	}
    }

    public void showAllCourses(){
        //TODO implement using collections loops
    	for(Course course: this.courseList.values()) {
    		System.out.println(course);
    	}
    }

	public void setStudents(Student student) {
		students.put(student.getId(), student);
	}
    
    
}