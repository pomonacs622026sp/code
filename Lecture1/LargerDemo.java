public class LargerDemo {
    public static int larger(int x, int y) {
        if (x > y) {
            return x;
        }
        return y;
    }
    public static void main(String[] args) {
       int z = larger(4, 6);
       System.out.println(z);
    } 
}   