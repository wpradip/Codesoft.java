package com.bytebrains.codesoft.main;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Task3StudentManagement {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        StudentManagementSystem managementSystem=new StudentManagementSystem();

        while(true) {
            System.out.println("\nOptions");
            System.out.println("1. Adding new Student"); 
            System.out.println("2.Removing a Student");
            System.out.println("3. Serching for Student");
            System.out.println("4.Display all student information");
            System.out.println("5.Exit"); 
            System.out.println("Enter the choice");
            String choice=scanner.nextLine();

            switch (choice) {

            case "1":
                System.out.println("Enter the Student Name"); 
                String name=scanner.nextLine();
                System.out.println("Enter the roll number of the student"); 
                String rollNo=scanner.nextLine();
                System.out.println("Enter the grade of the Student"); 
                String grade=scanner.nextLine();
            
                Student student=new Student(name, rollNo, grade); 
                managementSystem.addStudent (student); 
                System.out.println("student added successfuly");
                break;

            case "2":
                System.out.println("Enter the rollNo of the student to remove ");
                rollNo=scanner.nextLine();
                managementSystem.removeStudnt(rollNo);
                ((PrintStream) System.out).println("student remove the succssfuly");
                break;

            case "3":
                System.out.println("Enter the rollNo of Student to Search "); 
                rollNo=scanner.nextLine();
                Student searchedStudent=managementSystem.searchStudent(rollNo);
                if(searchedStudent !=null) { 
                    System.out.println("Student found");
                    System.out.println(searchedStudent);
                }
                else { 
                    System.out.println("Student not found");
                } 
                break;

            case "4":
                System.out.println("All Student");
                managementSystem.displayAllStudent();
                break;
                
            case "5":
                System.out.println("Exiting the application");
                scanner.close(); 
                System.exit(0);

            default:
                System.out.println("Invalid choice please try again");
                break;
            }
        }
    }
}