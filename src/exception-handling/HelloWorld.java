// try catch finally throw throws

import java.util.Scanner;

class MyException extends Exception {
  MyException(String msg) {
    super(msg);
  }
  void fun() {
    System.out.println("World full of exceptions");
  }
}

public class HelloWorld {

  static int divide(int a, int b) throws MyException {
    if (b == 0) throw new MyException("Denominator must not be zero");
    return a / b;
  }

  public static void main(String[] args) {
    System.out.println("Enter a and b :");
    
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt(), b = sc.nextInt();
    int c = 0;
    try {
      c = divide(a, b);
      // int arr[] = new int[5];
      // for (int i = 0; i <= 5; i++) {
      //   arr[i] = i;
      // }
    } 
    catch (ArithmeticException e) {
      System.out.println(e);
    }
    catch(ArrayIndexOutOfBoundsException e) {
      System.out.println(e);
    }
    catch (MyException e) {
      e.fun();
    }
    finally {
      System.out.println("Finally");
    }

    System.out.println("Output :" + c);

    sc.close();
  }
}