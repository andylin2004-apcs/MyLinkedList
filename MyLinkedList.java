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
    
  }
  public String get(int index){
    return
  }
  public String set(int index, String value){
    return
  }
  public String toString(){
    return;
  }
}
