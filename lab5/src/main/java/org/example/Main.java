package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть номер місяця (1-12): ");
        int month = scanner.nextInt();

        System.out.println("\n1. Завантажити всіх студентів і відфільтрувати в Java");
        System.out.println("2. Виконати SQL-запит для отримання студентів");
        System.out.print("Виберіть варіант (1 або 2): ");
        int choice = scanner.nextInt();

        List<Student> students;

        if (choice == 1) {
            students = studentService.filterStudentsByMonth(studentDAO.getAllStudents(), month);
        } else {
            students = studentDAO.getStudentsByMonth(month);
        }

        if (students.isEmpty()) {
            System.out.println("Немає студентів, народжених у цьому місяці.");
        } else {
            System.out.println("Список студентів:");
            students.forEach(System.out::println);
        }
    }
}
