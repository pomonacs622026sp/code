package registrar;

public class StudentLauncher {

    public static void main(String[] args){

        PomonaStudent student1 = new PomonaStudent("cecil");
        student1.setYearEntered(2022);
        System.out.println(student1.getYearEntered());
        System.out.println(student1.getYearEntered());
        // PomonaStudent.graduateAllStudents();

        ScrippsStudent student2 = new ScrippsStudent("La Semeuse");
        student2.setYearEntered(1889);
        System.out.println(student1);
        System.out.println(student2);
        // PomonaStudent.olderStudent(student1, student2);
    }

}
