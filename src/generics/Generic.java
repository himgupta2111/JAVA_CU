class CQArrayList {
  private int size; // number of elements
  private Object[] elements;

  public CQArrayList() {
    elements = new Object[10];
    size = 0;
  }

  public void add(Object obj) {
    if (size < elements.length)
      elements[size] = obj;
    else {
      // allocate a larger array and add the elements here
    }
    ++size;
  }

  public Object get(int index) {
    if (index >= size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    return elements[index];
  }

  public int size() {
    return size;
  }
}

public class Generic {
  public static void main(String[] args) {
    CQArrayList lst1 = new CQArrayList();
    lst1.add("Code"); // We inserted an String
    lst1.add("Quotient");
    for (int i = 0; i < lst1.size(); ++i)
      System.out.println((String) lst1.get(i));

    // Inadvertently added a non-String object will cause a runtime
    // ClassCastException.
    lst1.add(Integer.valueOf(12));

    for (int i = 0; i < lst1.size(); ++i)
      System.out.println((String) lst1.get(i)); // compile ok, runtime ClassCastException
  }
}