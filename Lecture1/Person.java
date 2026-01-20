public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("Hi, I am " + name);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Mary");
        Person p2 = new Person("Denise");
        p1.speak(); //prints Hi, I am Mary
        p2.speak(); //prints Hi, I am Denise
    } 
}    
