public class PomonaStudent {

    // state variables
    String name;
    String email;
    int id;
    int yearEntered;
    String academicStanding;
    boolean graduated;

    // unlike python, you can have multiple constructors
    // they just need to differ in the # of arguments
    public PomonaStudent() {
    }

    //you don't *need* this.name if the parameter is a different variable
    public PomonaStudent(String studentName){
        name = studentName;
    }

    //but if your parameters and variables are the same, you need the keyword this
    public PomonaStudent(String name, String email, int id){
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public static void main(String[] args){

        PomonaStudent student1 = new PomonaStudent(); //uses the default constructor
        student1.name = "Ravi Kumar";
        student1.email = "rkjc2023@mypomona.edu";
        student1.id = 1234;  
        
        PomonaStudent student2 = new PomonaStudent("Ravi Kumar", "rkjc2023@mypomona.edu", 1234);
        System.out.println(student2.name); //prints Ravi Kumar
        student2.name = "Jingyi Li";
        System.out.println(student2.name); //prints Jingyi Li
 
    }
}

