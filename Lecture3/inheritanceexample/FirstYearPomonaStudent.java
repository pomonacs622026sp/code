package inheritanceexample;

class FirstYearPomonaStudent extends PomonaStudent {

    private String id1;
    private static int firstYearCounter;


    protected FirstYearPomonaStudent(String name, String email, int id, String id1){
        super(name, email, id);
        this.id1 = id1;
        firstYearCounter++;
    }

    protected String getId1(){
        return id1;
    }

    protected void setID1(String id1){
        this.id1 = id1;
    }

    public String toString(){
        return super.toString() + "First-Year Student Attending ID1: " + id1;
    }

    @Override
    protected int getMaxCredits(){
        return 4;
    }
    protected void parentTest() {
        super.superTest();
    }
    public static void main(String[] args) {
        FirstYearPomonaStudent student1 = new FirstYearPomonaStudent("daniel", "daniel@pomona.edu", 1, "War and Peace");
        System.out.println("testing inheritance");
        student1.superTest();
    }
}
