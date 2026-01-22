public class PomonaStudent {

    private String name;
    private String email;
    private int id;
    private int yearEntered;
    private String academicStanding;
    private boolean graduated;
    private static int studentCounter;


    int getYearEntered() {
        return yearEntered;
    }

    void setYearEntered(int yearEntered) {
        this.yearEntered = yearEntered;
    }

    public static void graduateAllStudents(){
        studentCounter = 0;
     }

    public PomonaStudent(String name, String email, int id){
        this.name = name;
        this.email = email;
        this.id = id;
        studentCounter++;
    }

    public static PomonaStudent olderStudent(PomonaStudent p1, PomonaStudent p2) {
        if (p1.yearEntered < p2.yearEntered) { 
            //if they entered an earlier year, they are an older (in class ranking) student
            return p1;
        }
        return p2;
    }

    public String toString(){
        return "Name: " + name + "\nemail: " + email + "\nid: " + id;
    }


    public static void main(String[] args){

        PomonaStudent[] students = new PomonaStudent[2];
        students[0] = new PomonaStudent("Alex", "email@pomona.edu", 123);
        students[0].setYearEntered(2022);
        System.out.println(students[0].getYearEntered());
        System.out.println(studentCounter);
        graduateAllStudents();
        System.out.println(studentCounter); 

        PomonaStudent student2 = new PomonaStudent("Ravi Kumar", "rkjc2023@mypomona.edu", 1234);
        students[1] = student2;
        student2.setYearEntered(2025);
        System.out.println(student2);

        System.out.println("The older student is " + olderStudent(students[0], students[1]));

        graduateAllStudents();
        students[0].graduateAllStudents();



    }

}
