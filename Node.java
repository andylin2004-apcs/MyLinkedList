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
 public String getValue(){
   return this.data;
 }

 public String setValue(String in){
   String toReturn = this.data;
   this.data = in;
   return toReturn;
 }

 public Node getPrev(){
   return prev;
 }
 public Node getNext(){
   return next;
 }
}
