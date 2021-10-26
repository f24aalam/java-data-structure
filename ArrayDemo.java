import java.util.Scanner;

class ArrayDemo {
    public static void main(String[] args) {
        int[] demoArray = new int[5];

        Scanner in = new Scanner(System.in);
        for(int i = 0; i < demoArray.length; i++) {
            demoArray[i] = in.nextInt();
        }

        for(int i = 0; i < demoArray.length; i++) {
            System.out.print(demoArray[i] + " ");
        }
    }
}