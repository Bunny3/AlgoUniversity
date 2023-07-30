package LinkedList;
import java.util.*;
import java.io.*;
class Node {
  int val;
  Node next;
  Node random_next;
  Node(int v) {
    val = v;
    next = null;
    random_next = null;
  }
}
public class DeepCopy {
  public static Node insertNode(Node head, int val)
  {
    if(head == null) {
      head = new Node(val);
      return head;
    }
    Node temp  = head;
    while(temp.next != null) {
      temp = temp.next;
    }
    temp.next = new Node(val);
    return head;
  }

  static HashMap<Node, Node> mp = new HashMap<>();
  public static Node deepCopy(Node head) {

    if(head == null) {
      return null;
    }
    if(mp.containsKey(head)) {
      return mp.get(head);
    }
    Node deepNode = new Node(head.val);
    mp.put(head, deepNode);
    deepNode.next = deepCopy(head.next);
    deepNode.random_next = deepCopy(head.random_next);
    return deepNode;
  }
  public static void main(String args[]){
    Node head = null;
    head = insertNode(head,1);
    head = insertNode(head,2);
    head = insertNode(head,3);
    head = insertNode(head,4);
    head = insertNode(head,5);
    System.out.println("Original LL" + head);
    Node deNode = deepCopy(head);
    System.out.println(deNode);
  }
}
