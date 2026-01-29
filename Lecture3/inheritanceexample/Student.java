package inheritanceexample;

class Student {

    private String name;
    private String email;
    private int id;
    private String major;
    private int yearEntered;

    private static int studentCounter;
    
    protected Student(String name, String email, int id){
        this.name = name;
        this.email = email;
        this.id = id;
        studentCounter++;
        major = "Undeclared";
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getEmail() {
        return email;
    }


    protected void setEmail(String email) {
        this.email = email;
    }

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected static int getStudentCounter(){
        return studentCounter;
    }

    protected static void setStudentCounter(int students){
        studentCounter = students;
    }


    protected String getMajor(){
        return major;
    }

    protected void setMajor(String major){
        this.major = major;
    }

    protected int getYearEntered(){
        return yearEntered;
    }

    protected void setYearEntered(int year){
        yearEntered = year;
    }

    protected void test(){
        System.out.println("test in student");
    }

    protected int getMaxCredits(){
        return 4;
    }

    public String toString(){
        return "Student Info - Name: " + name + "\nemail: " + email + "\nid: " + id + "\n";
    }

    public static Student olderStudent(Student p1, Student p2) {
        if (p1.getYearEntered() < p2.getYearEntered()) { 
            //if they entered an earlier year, they are an older (in class ranking) student
            return p1;
        }
        return p2;
    }

}
