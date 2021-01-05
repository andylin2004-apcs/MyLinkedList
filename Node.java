class Node{
 private String data;
 private Node next,prev;

 public Node(String value){
   this.data = value;
 }
 public void setPrev(Node in){
   this.prev = in;
 }
 public void setNext(Node in){
   this.next = in;
 }
 public String getData(){
   return this.data;
 }
 public String getPrev(){
   return prev.getData();
 }
 public String getNext(){
   return next.getData();
 }
}
