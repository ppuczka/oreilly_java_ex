package ex_2;

public class Derived extends Base {

    public void print() {
        System.out.println("Hello");
    }

    static void function() {
        Base base1 = new Derived();
        base1.print();
    }

    public static void main(String[] args) {
        function();
    }
}
