package org.example.main;

import org.example.controller.*;
import org.example.model.*;

public class Run {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        // Створення університету
        Human rector = new Human("Іван", "Іванов", "Іванович", Human.Sex.MALE) {};
        UniversityCreator universityCreator = new UniversityCreator();
        University university = universityCreator.createUniversity("Університет прикладних наук", rector);

        // Створення першого факультету
        Human facultyHead1 = new Human("Марія", "Петрівна", "Семенова", Human.Sex.FEMALE) {};
        FacultyCreator facultyCreator = new FacultyCreator();
        Faculty faculty1 = facultyCreator.createFaculty("Факультет інформатики", facultyHead1);

        // Додавання кафедр до факультету
        Human departmentHead1 = new Human("Олександр", "Ковальчук", "Олексійович", Human.Sex.MALE) {};
        DepartmentCreator departmentCreator = new DepartmentCreator();
        Department department1 = departmentCreator.createDepartment("Кафедра програмування", departmentHead1);

        Human departmentHead2 = new Human("Ірина", "Сидорова", "Анатоліївна", Human.Sex.FEMALE) {};
        Department department2 = departmentCreator.createDepartment("Кафедра кібербезпеки", departmentHead2);

        facultyCreator.addDepartment(faculty1, department1);
        facultyCreator.addDepartment(faculty1, department2);

        // Додавання груп до кафедр
        Human groupHead1 = new Human("Дмитро", "Лебедєв", "Миколайович", Human.Sex.MALE) {};
        GroupCreator groupCreator = new GroupCreator();
        Group group1 = groupCreator.createGroup("Група ПР-101", groupHead1);

        Human groupHead2 = new Human("Олена", "Кравченко", "Василівна", Human.Sex.FEMALE) {};
        Group group2 = groupCreator.createGroup("Група ПР-102", groupHead2);

        departmentCreator.addGroup(department1, group1);
        departmentCreator.addGroup(department1, group2);

        // Додавання студентів до груп
        StudentCreator studentCreator = new StudentCreator();
        Student student1 = studentCreator.createStudent("Андрій", "Ткаченко", "Віталійович", Human.Sex.MALE, "PR101001");
        Student student2 = studentCreator.createStudent("Наталія", "Гриценко", "Ігорівна", Human.Sex.FEMALE, "PR101002");
        Student student3 = studentCreator.createStudent("Василь", "Петренко", "Андрійович", Human.Sex.MALE, "PR102001");
        Student student4 = studentCreator.createStudent("Ольга", "Мельник", "Володимирівна", Human.Sex.FEMALE, "PR102002");

        groupCreator.addStudent(group1, student1);
        groupCreator.addStudent(group1, student2);
        groupCreator.addStudent(group2, student3);
        groupCreator.addStudent(group2, student4);

        // Додавання факультету до університету
        universityCreator.addFaculty(university, faculty1);

        // Створення другого факультету
        Human facultyHead2 = new Human("Сергій", "Іванов", "Михайлович", Human.Sex.MALE) {};
        Faculty faculty2 = facultyCreator.createFaculty("Факультет математики", facultyHead2);

        universityCreator.addFaculty(university, faculty2);

        // Вивід даних про університет
        System.out.println(university);
    }
}
