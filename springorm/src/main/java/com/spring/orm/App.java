package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//        Student student = new Student(8,"Brad Pit", "USA");
//        int r = studentDao.insert(student);
//        System.out.println("Done " + r);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean run = true;
        while(run)
        {
            System.out.println("Please enter your choice:");
            System.out.println("1: Add New Student");
            System.out.println("2: Display All Students");
            System.out.println("3: Display Details of single student");
            System.out.println("4: Delete Student");
            System.out.println("5: Update Student");
            System.out.println("6: Exit");
            
            try {
            	int input = Integer.parseInt(br.readLine());
            	switch (input) {
				case 1:
					//Add a new student
					//Taking inputs from user
					System.out.println("Enter Student ID");
					int SID = Integer.parseInt(br.readLine());
					
					System.out.println("Enter Student Name");
					String SName = br.readLine();
					
					System.out.println("Enter Student City");
					String SCity = br.readLine();
					
					//Creating student object and setting values
					Student s = new Student();
					s.setStudentId(SID);
					s.setStudentName(SName);
					s.setStudentCity(SCity);
					
					//Saving student object to database by calling insert function of student dao.
					int r = studentDao.insert(s);
					System.out.println("Student with Id " + r + " added successfully!");
					System.out.println("*********************************************");
					break;
				case 2:
					//Display all students
					System.out.println("*********************************************");
					List<Student> allStudents = studentDao.getAllStudents();
					for(Student st:allStudents)
					{
					System.out.println("_____________________________________________");
						System.out.println("Id: " + st.getStudentId());
						System.out.println("Name: " + st.getStudentName());						
						System.out.println("City: "+ st.getStudentCity());
					System.out.println("_____________________________________________");
					}
					System.out.println("*********************************************");
					break;
				case 3:
					//Get single student data
					//Taking inputs from user
					System.out.println("Enter Student ID");
					int ID = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(ID);
					
				System.out.println("_____________________________________________");
					System.out.println("Id: " + student.getStudentId());
					System.out.println("Name: " + student.getStudentName());						
					System.out.println("City: "+ student.getStudentCity());
				System.out.println("_____________________________________________");
					break;
				case 4:
					//Delete student
					System.out.println("Enter Student ID");
					int iD = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(iD);
					System.out.println("*********************************************");
					System.out.println("Student with Id "+ iD + " deleted successfully!");
					System.out.println("*********************************************");
					break;
				case 5:
					//Update student
					System.out.println("Enter Student ID");
					int siD = Integer.parseInt(br.readLine());
					
					System.out.println("Enter new Student Name");
					String NewName = br.readLine();
					
					System.out.println("Enter Student City");
					String NewCity = br.readLine();
					
					//Creating student object and setting values
					Student NewStudent = new Student();
					NewStudent.setStudentId(siD);
					NewStudent.setStudentName(NewName);
					NewStudent.setStudentCity(NewCity);
					
					studentDao.updateStudent(NewStudent);
					
					System.out.println("*********************************************");
					System.out.println("Student with Id "+ siD + " updated successfully!");
					System.out.println("*********************************************");
					break;
				case 6:
					//Exit
					run = false;
					break;
				}
            }catch (Exception e) {
				System.out.println("Invalid inout try again!!");
				System.out.println(e.getMessage());
			}
        }
        System.out.println("Thankyou for using the application.");
    }
}
