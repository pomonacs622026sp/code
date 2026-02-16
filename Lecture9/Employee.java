import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int compareTo(Employee e) {
        if (this.id < e.id) {
            return -1;
        } else if (this.id > e.id) {
            return 1;
        } else
            return 0;
        // return Integer.valueOf(this.id).compareTo(Integer.valueOf(e.id));
        // return Integer.compare(this.id, e.id);
    }

    public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e1.name.compareTo(e2.name);
        }
    };

    public static Comparator<Employee> salaryComparator() {
        return (Employee e1, Employee e2) -> Integer.compare(e1.salary, e2.salary);
    }

    public String toString() {
        return "Name: " + name + " ID: " + id + " Salary: " + salary;
    }

    public static void main(String[] args) {

        Employee e1 = new Employee(5, "Yash", 100000);
        Employee e2 = new Employee(8, "Tharun", 25000);
        Employee e3 = new Employee(4, "Yush", 10000);
        List<Employee> list = new ArrayList<Employee>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        System.out.print("Unsorted list: ");
        System.out.println(list);

        Collections.sort(list);
        System.out.print("Naturally sorted list: ");
        System.out.println(list);

        Collections.sort(list, Employee.nameComparator); // call @compare (o1,o2)
        System.out.print("Sorted list based on names: ");
        System.out.println(list);

        Collections.sort(list, Employee.salaryComparator()); // call @compare (o1,o2)
        System.out.print("Sorted list based on salaries: ");
        System.out.println(list);

    }
}
