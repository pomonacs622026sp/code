package inheritanceexample;

public class ScrippsStudent extends Student {

    private boolean gwsReqCompleted;

    private static int scrippsStudentCounter;

    protected ScrippsStudent(String name, String email, int id){
        super(name, email, id);
        scrippsStudentCounter++;
    }

    protected void completeGWSReq() {
        gwsReqCompleted = true;
    }

    protected boolean getGWSReqCompleted() {
        return gwsReqCompleted;
    }   

    public String toString(){
        return "Scripps " + super.toString();
    }

    protected static void graduateAllStudents(){
        Student.setStudentCounter(Student.getStudentCounter() - scrippsStudentCounter);
        scrippsStudentCounter = 0;
    }

}
