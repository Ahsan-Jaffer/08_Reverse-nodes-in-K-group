// Reverse first K node
// recursive reverse
// return updated head

public class Main{

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void print(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static int size(Node head){
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static Node reverseKNode(Node head, int k){
        if (head == null) {
            return head;
        }
        if (k > size(head)) {
            return head;
        }
        boolean rev = true;
        if (rev) {
            // Step A : Reverse First K nodes of LinkedList
    
            int count = 0;
    
            Node curr = head;
            Node prev = null;
            Node nextNode = curr.next;
            while (count < k) {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                count++;
            }
    
            //Step B: recursive call
            if (nextNode != null) {
                // Still we have left nodes to reverse
                head.next = reverseKNode(nextNode, k);
            }
            head = prev;
            return head;
        }
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(2);
        Node fifth = new Node(1);
        Node sixth = new Node(60);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        Node head = first;
        
        print(head);
        Node r = reverseKNode(head, 2);
        System.out.println();
        print(r);
        

        
    }
}