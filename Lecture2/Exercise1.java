public class Exercise1 {
    int x;
    String message;
    static int y = 0;

    public Exercise1(int x) {
        this.x = x; 
    }
    public void setMessage(String msg) {
        this.message = msg;
    }
    public String yell() {
        return message;
    }
    public static int add(int x) {
        return x + y;
    }


    public static void main(String[] args) {
        Exercise1 obj1 = new Exercise1(y);
        System.out.println(obj1.x);
        y = 7;
        // obj1.message = "bark";
        obj1.setMessage("bark");
        System.out.println(add(4));
        obj1.setMessage("meow");
        System.out.println(obj1.yell());


    }
}
