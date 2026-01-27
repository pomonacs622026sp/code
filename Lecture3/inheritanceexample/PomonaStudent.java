package inheritanceexample;

public class PomonaStudent extends Student {

    private boolean languageReqCompleted;

    private static int pomonaStudentCounter;

    protected PomonaStudent(String name, String email, int id){
        super(name, email, id);
        pomonaStudentCounter++;
    }

    protected void completeLanguageReq() {
        languageReqCompleted = true;
    }

    protected boolean getLanguageReqCompleted() {
        return languageReqCompleted;
    }   

    public String toString(){
        return "Pomona " + super.toString();
    }

    protected static void graduateAllStudents(){
        Student.setStudentCounter(Student.getStudentCounter() - pomonaStudentCounter);
        pomonaStudentCounter = 0;
    }
}
