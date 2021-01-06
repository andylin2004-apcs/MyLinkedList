import java.lang.IndexOutOfBoundsException;

class MyLinkedList{
 private int size;
 private Node start,end;

  public MyLinkedList(){
    size = 0;
  }
  public int size(){
    return this.size;
  }
  public boolean add(String value){
    if (this.size == 0){
      this.start = new Node(value);
      this.end = this.start;
    }else{
      Node temp = this.end;
      this.end = new Node(value);
      temp.setNext(this.end);
      this.end.setPrev(temp);
    }
    this.size++;
    return true;
  }
  public void add(int index, String value){
    if (this.size == 0){
      this.start = new Node(value);
      this.end = this.start;
    }else if(index == size){
      Node temp = this.end;
      this.end = new Node(value);
      temp.setNext(this.end);
      this.end.setPrev(temp);
    }else if(index == 0){
      Node temp = this.start;
      this.start = new Node(value);
      temp.setPrev(this.start);
      this.start.setNext(temp);
    }else{
      Node inserted = new Node(value);
      Node newPrev = find(index);
      Node newNext = newPrev.getNext();
      newPrev.setNext(inserted);
      newNext.setPrev(inserted);
      inserted.setNext(newNext);
      inserted.setPrev(newPrev);
    }
    this.size++;
  }
  public String get(int index){
    if (this.size >= index){
      throw new IndexOutOfBoundsException();
    }
    return find(index).getValue();
  }

  public String set(int index, String value){
    Node toSet = find(index);
    return toSet.setValue(value);
  }

  public String toString(){
    String result = "[";
    Node current = this.start;
    while (current != null){
      if (!result.equals("[")){
        result += ", ";
      }
      System.out.println(current.getValue());
      result += current.getValue();
      current = current.getNext();
    }
    return result+"]";
  }
  
  private Node find(int pos){
    int spot = 0;
    Node current = this.start;
    while (pos > spot && current != null){
      System.out.println(current.getValue());
      current = current.getNext();
      spot++;
    }
    return current;
  }
}
