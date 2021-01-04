package ex_1;

public class One extends Base {

    int num = 79;

    @Override
    public void print() {
        System.out.print("Return " + this.num + "\n");
    }

    public static void main(String[] args) {

        One firstOne = new One();
        firstOne.print();
    }
}
