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
 public String get(){
   return this.data;
 }

 public void set(String in){
   this.data = in;
 }
 
 public Node getPrev(){
   return prev;
 }
 public Node getNext(){
   return next;
 }
}
