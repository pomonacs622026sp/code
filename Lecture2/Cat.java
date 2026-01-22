public class Cat {

    private String name;
    private String sex;
    private int age;
    private int daysInRescue;
    private boolean adopted;

    public Cat(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    @Override
    public String toString(){
        return "Cat name: " + this.name + " is adopted? " + this.adopted;
    }

    public int getDaysInRescue(){
        return this.daysInRescue;
    }

    public void setDaysinRescue(int days){
        this.daysInRescue = days;
    }
    //could also not be static, but conceptually makes more sense as static
    //since the oldest cat in rescue is not tied to a specific cat
    //but rather all the cats in the rescue
    public static Cat oldestCatInRescue(Cat[] cats) {
        Cat oldest = cats[0];
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].getDaysInRescue() > oldest.getDaysInRescue()) {
                oldest = cats[i];
            }
        }
        /* OR, for-each loop
        for (Cat cat : cats) {
         if (cat.getDaysInRescue() > oldest.getDaysInRescue()) {
                oldest = cat;
            }
        } 
        */
        return oldest;
    }

    public static void main(String[] args){
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Sesame", "female", 3);
        cats[0].setDaysinRescue(20);
        cats[1] = new Cat("Liko", "female", 1);
        cats[1].setDaysinRescue(15);
        cats[2] = new Cat("Mr. Meow", "male", 12);
        cats[2].setDaysinRescue(300);

        System.out.println("oldest cat is " + oldestCatInRescue(cats));

    }
}
