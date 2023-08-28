//Can create single-linked list of nodes length of input array
//Currently only iterable backwards. Next: Create function to insert the .next values.

public class SingleLinkedList {
    public static void main(String[] args) {
        new LinkedList(new int[]{2, 4, 6, 8});
    }
}


class LinkedList {
    public static Node firstNode;
    public static Node lastNode;
    public static int counter = 0;

    //Constructor. Assigns values to first and last node (with null references)
    public LinkedList(int [] values){
        firstNode = new Node(values[0], null);
        lastNode = new Node(values[values.length -1], null);
        addNodes(firstNode, values);
        printList();
    }

    //Creates linked list (called upon by constructor)
    public void addNodes(Node prev, int[] values){
        counter++;
        if(counter == values.length -1){
            lastNode.prev = prev;
        } else {
            addNodes(new Node(values[counter], prev), values);
        }
    }

    //prints list
    public void printList(){
        Node thisNode = lastNode;
        for (int i = counter; i >= 0; i--){
            System.out.println(thisNode.value);
            thisNode = thisNode.prev;
        }
    }

}


class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int value, Node prev) {
        this.value = value;
        this.prev = prev;
    }
}
