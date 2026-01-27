package registrar;

//mostly copy/pasted PomonaStudent code, but changed name of class
public class ScrippsStudent {
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

    private static void graduateAllStudents(){
        studentCounter = 0;
     }

    public ScrippsStudent(String name){
        this.name = name;
        studentCounter++;
    }


    public String toString(){
        return "Scripps Student \n Name: " + name + "\n email: " + email + "\n id: " + id;
    }

}
