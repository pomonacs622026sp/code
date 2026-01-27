package registrar;

public class PomonaStudent {

    private String name;
    private String email;
    private int id;
    private int yearEntered;
    private String academicStanding;
    private boolean graduated;
    private static int studentCounter;


    int getYearEntered() { //default access 
        return yearEntered;
    }

    void setYearEntered(int yearEntered) {
        this.yearEntered = yearEntered;
    }

    //private - scripps should not be able to graduate pomona students
    private static void graduateAllStudents(){
        studentCounter = 0;
     }

    public PomonaStudent(String name){
        this.name = name;
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
        return "Pomona Student \n Name: " + name + "\n email: " + email + "\n id: " + id;
    }

}
