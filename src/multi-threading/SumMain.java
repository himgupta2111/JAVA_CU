import java.lang.Thread;

class MyClass extends Thread {
  int sum, start, end;

  MyClass(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public void run() {
    for (int i = start; i <= end; i++)
      this.sum += i;
  }

  int getSum() {
    return this.sum;
  }
}

public class SumMain {
  public static void main(String[] args) {
    MyClass t0 = new MyClass(1, 500);
    MyClass t1 = new MyClass(501, 1000);
    t0.start();
    t1.start();

    try { t0.join(); } catch (InterruptedException e) {}
    try { t1.join(); } catch (InterruptedException e) {}

    System.out.println(t0.getSum() + t1.getSum());
  }
}