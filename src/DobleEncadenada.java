



public class DobleEncadenada {
public class DoublyLinkedList {
    private Lista tail;
    private Lista head;
 
    public void addLast(Integer value) {
        Lista node = new Lista (value);
        if (tail == null && head == null) {
            tail = node;
            head = node;
        } else {
            tail.setNextElement(node);
            node.setPreviousElement(tail);
            tail = node;
        }
    }
 
    public void addFirst(Integer value) {
        Lista node = new Lista(value);
        if (tail == null && head == null) {
            tail = node;
            head = node;
        } else {
            node.setNextElement(head);
            head.setPreviousElement(node);
            head = node;
        }
    }
 
    public void print() {
        for (Lista i = head; i != null; i = i.getNextElement()) {
            System.out.printf("\t %s ", i.toString());
        }
        System.out.println();
    }
}    
}
