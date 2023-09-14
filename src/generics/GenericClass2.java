// Generic class
class CQGeneric <T> {
  private T content;

  // Constructor
  public CQGeneric(T content) {
    this.content = content;
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

  public String toString() {
    return content + " (" + content.getClass() + ")";
  }
}

class GenericClass2 {
  public static void main(String[] args) {
    CQGeneric<String> box1 = new CQGeneric<String>("Code Quotient");
    String str = box1.getContent(); // no explicit downcasting needed
    System.out.println(str);

    CQGeneric<Integer> box2 = new CQGeneric<Integer>(5587); // autobox int to Integer
    int i = box2.getContent(); // downcast to Integer, auto-unbox to int
    System.out.println(i);

    CQGeneric<Double> box3 = new CQGeneric<Double>(22.33); // autobox double to Double
    double d = box3.getContent(); // downcast to Double, auto-unbox to double
    System.out.println(d);
  }
}