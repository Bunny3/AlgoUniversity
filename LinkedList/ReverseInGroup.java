import java.util.*;
import java.io.*;

class Node {
  int val;
  Node next;
  Node(int a) {
    val = a;
    next = null;
  }
}
public class ReverseInGroup {

  static Node insertNode(Node head, int val) {
    Node newNode = new Node(val);
    if(head == null) {
      head = newNode;
      return head;
    }

    Node temp = head;
    while(temp.next != null) temp = temp.next;

    temp.next = newNode;
    return head;
  }

  static void printLinkedList(Node head) {
    while(head.next!= null){
      System.out.print(head.val+ "=>" );
      head = head.next;
    } 
    System.out.println();;
  }

  static int lengthOfLinkedList(Node head) {
    int length = 0;
    while(head != null) {
      ++length;
      head = head.next;
    }
    return length;
  }
  public static Node reverseKNodes(Node head, int k) {
    if(head == null || head.next == null) {
      return head;                                                 
    }
    
    int length = lengthOfLinkedList(head);
    Node dummyHead = new Node(0);
    dummyHead.next = head;

    Node pre = dummyHead;
    Node cur;
    Node nex;

    while(length >= k ) {
      cur = pre.next;
      nex = cur.next;
        for(int i=1; i<k; i++) {
          cur.next = nex.next;
          nex.next = pre.next;
          pre.next = nex;
          nex = cur.next;
        }
        pre = cur;
        length = length - k;
    }
    return dummyHead.next;
  }
  public static void main(String args[]) throws IOException {
    Node head = null;
    int k = 3;
    head = insertNode(head,1);
    head = insertNode(head,2);
    head = insertNode(head,3);
    head = insertNode(head,4);
    head = insertNode(head,5);
    head = insertNode(head,6);
    head = insertNode(head,7);
    head = insertNode(head,8);

    System.out.println("Original Linked List");
    printLinkedList(head);
    System.out.println("After Reversal of K nodes");
    Node newHead = reverseKNodes(head,k);
    printLinkedList(newHead);
  }
}
