class MyLinkedList {
    private static class Node {
        int val;
        Node next;
        Node (int val){
            this.val = val;
        }
    }
    private Node sentinel;
    private int size;

    public MyLinkedList() {
       sentinel = new Node(0);
       size = 0;
    }
    
    public int get(int index) {
        if(index<0 || index >=size ) return -1;
        Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        Node before = sentinel;
        for (int i = 0; i < index; i++) {
            before = before.next;
        }

        Node node = new Node(val);
        node.next = before.next;
        before.next = node;
        size++;
        
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        Node before = sentinel;
        for (int i = 0; i < index; i++) {
            before = before.next;
        }

        before.next = before.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */