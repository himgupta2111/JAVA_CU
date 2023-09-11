import java.lang.Thread;

class Counter {
  int counter = 0;
  
  void increment() {
    synchronized(this) {
      counter++;
    }
  }

  int getCounterValue() {
    return this.counter;
  }
}

class CounterIncrement extends Thread {
  Counter counterObj;

  CounterIncrement(Counter obj) {
    this.counterObj = obj;
  }
  
  @Override
  public void run() {
    for (int i = 1; i <= 1000; i++)
      counterObj.increment();
  }
}

public class CounterMain {
  public static void main(String[] args) {
    Counter counter = new Counter();
    CounterIncrement t1 = new CounterIncrement(counter);
    CounterIncrement t2 = new CounterIncrement(counter);

    t1.start();
    t2.start();

    try { t1.join(); } catch (InterruptedException e) {}
    try { t2.join(); } catch (InterruptedException e) {}

    // Expected output is 2000 - To achive that we have used the synchronized block inside increment method
    System.out.println(counter.getCounterValue());
  }
}