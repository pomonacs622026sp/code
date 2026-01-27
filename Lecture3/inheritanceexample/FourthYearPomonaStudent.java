package inheritanceexample;

class FourthYearPomonaStudent extends PomonaStudent {

    private String thesisTitle;
    private static int fourthYearCounter;

    protected FourthYearPomonaStudent(String name, String email, int id, String thesisTitle){
        super(name, email, id);
        this.thesisTitle = thesisTitle;
        fourthYearCounter++;
    }

    protected String getThesisTitle(){
        return thesisTitle;
    }

    protected void setThesisTitle(String thesisTitle){
        this.thesisTitle = thesisTitle;
    }

    @Override
    protected int getMaxCredits(){
        return 6;
    }

    public String toString(){
        return super.toString() + "Fourth-Year Student Writing Thesis on: " + thesisTitle;
    }
}

