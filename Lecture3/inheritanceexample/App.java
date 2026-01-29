package inheritanceexample;

public class App {

    public static void main(String[] args) {

        FirstYearPomonaStudent student1 = new FirstYearPomonaStudent("daniel", "daniel@pomona.edu", 1, "War and Peace");
        FirstYearPomonaStudent student2 = new FirstYearPomonaStudent("wentao", "wentao@pomona.edu", 2, "Everday Chemistry");
        ScrippsStudent student3 = new ScrippsStudent("stacy", "stacy@scripps.edu", 3);
        ScrippsStudent student4 = new ScrippsStudent("abram", "abram@scripps.edu", 4);
        FourthYearPomonaStudent student5 = new FourthYearPomonaStudent("millie", "millie@pomona.edu", 5, "Power and its Effects on Software Engineering");
        
        FirstYearPomonaStudent[] firstYears = {student1, student2};

        for (FirstYearPomonaStudent firstYear : firstYears) {
            // System.out.println(firstYear);
            // System.out.println("---");
        }

        //can use more general parent class
        Student[] students = new Student[5];
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
        students[3] = student4;
        students[4] = student5;
        for (Student student : students) {
            System.out.println(student);
            System.out.println("---");
        }


        //checking graduating students
        System.out.println(Student.getStudentCounter()); //should be 5
        PomonaStudent.graduateAllStudents(); 
        System.out.println(Student.getStudentCounter()); //now should be 2
        ScrippsStudent.graduateAllStudents();
        System.out.println(Student.getStudentCounter()); //now should be 0

    }
}
