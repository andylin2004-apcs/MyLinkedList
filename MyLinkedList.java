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

  private void nuke(){
    this.start = null;
    this.end = null;
    size = 0;
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
    if (index < 0 || index > this.size()){
      throw new IndexOutOfBoundsException();
    }
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
      Node newNext = find(index);
      Node newPrev = newNext.getPrev();
      newPrev.setNext(inserted);
      newNext.setPrev(inserted);
      inserted.setNext(newNext);
      inserted.setPrev(newPrev);
    }
    this.size++;
  }

  public String get(int index){
    if (this.size >= index || index < 0){
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
      current = current.getNext();
      spot++;
    }
    return current;
  }

  public String remove(int index){
    String result;
    if (index == 0){
      result = this.start.getValue();
      this.start = this.start.getNext();
      this.start.setPrev(null);
    }else if (index == size-1){
      result = this.end.getValue();
      this.end = this.end.getPrev();
      this.end.setNext(null);
    }else{
      result = find(index).getValue();
      Node cutLeft = find(index).getPrev();
      Node cutRight = find(index).getNext();
      cutLeft.setNext(cutRight);
      cutRight.setPrev(cutLeft);
    }
    size--;
    return result;
  }

  public void extend(MyLinkedList other){
    this.end.setNext(other.start);
    other.start.setPrev(this.end);
    other.nuke();
  }
}
