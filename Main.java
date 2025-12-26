package Main;

import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int choice;
			do {
			    System.out.println("1. Add Student");
			    System.out.println("2. View All Students");
			    System.out.println("3. Update Student");
			    System.out.println("4. Delete Student");
			    System.out.println("5. Exit");
			    System.out.print("Enter your choice: ");
			    choice = sc.nextInt();
			    switch (choice) {
			        case 1:
			            System.out.print("Enter Name; ");
			            sc.nextLine();
			            String name = sc.nextLine();
			            System.out.print("Enter Email ");
			            String email = sc.nextLine();
			            System.out.print("Enter Age");
			            int age = sc.nextInt();
			            Student newStudent = new Student(name, email, age);
			            StudentDAO.addStudent(newStudent);
			            break;

			        case 2:
			            List<Student> list = StudentDAO.getAllStudents();
			            list.forEach(System.out::println);
			            break;

			        case 3:
			            System.out.println("Enter Student ID:");
			            int idToUpdate = sc.nextInt();
			            sc.nextLine();
			            System.out.println("Enter Student new Name:");
			            String newName = sc.nextLine();
			            System.out.println("Enter Student new Email:");
			            String newEmail = sc.nextLine();
			            System.out.println("Enter Student new Age:");
			            int newAge = sc.nextInt();
			            Student updatedStudent = new Student(idToUpdate, newName, newEmail, newAge);
			            StudentDAO.updateStudent(updatedStudent);
			            break;

			        case 4:
			            System.out.println("Enter Student ID to Delete:");
			            int idToDelete = sc.nextInt();
			            StudentDAO.deleteStudent(idToDelete);
			            break;

			        case 5:
			            System.out.println("Bye!");
			            break;
			    }
			}
			while (choice != 5);
		}

   }

}
