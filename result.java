import java.util.*;

public class result {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a:");
        int a = sc.nextInt();
        System.out.println("enter b:");
        int b = sc.nextInt();
        System.out.println("select operation from 1 to 5:");
        int operation = sc.nextInt();
        switch (operation) {
            case 1:

                System.out.println("a+b:" +(a+b)); 
                break;
            case 2:
                System.out.println("a-b:"+ (a-b));
                break;
            case 3:
                System.out.println("a*b:" + (a*b));
                break;
            case 4:
                if (b == 0) {
                    System.out.println("invild operation");
                } else {
                    System.out.println("a/b:" + (a/b));
                }
                break;
            case 5:
                if (b == 0) {
                    System.out.println("invalid operation");
                } else {
                    System.out.println("a%b" + (a%b));
                }
                break;
            default:
                System.out.println("invalid operation");
        }
    }
}
