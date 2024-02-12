public class SinglyLinkedList<E> {
    public static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public SinglyLinkedList() {}

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E first() {
        if (isEmpty()) {
            return null;
        }
        else {
            return head.getElement();
        }
    }
    public E last() {
        if (isEmpty()) {
            return null;
        }
        else {
            return head.getElement();
        }
    }
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        }
        else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E answer = get(getSize() - 1).getElement();
        tail = get(getSize()- 2);
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }
    public Node<E> get(int index) {
        Node<E> answer = null;
        if (isEmpty()) {
            return null;
        }
        else if (index == 0){
            return head;
        }
        else {
            answer = head;
            while (index != 0) {
                answer = answer.getNext();
                index--;
            }
        }
        return answer;
    }
    public void insert(int index, E e) {
        Node<E> newest = new Node<>(e, null);
        Node<E> prev = get(index - 1);

        newest.setNext(prev.getNext());
        prev.setNext(newest);
        size++;
    }
    public void addAtIndex(int index, E e) {
        if (index > getSize() || index < 0) {
            System.out.println("not a valid index");
        }
        else if (index == 0){
            addFirst(e);
        }
        else {
            insert(index, e);
        }
    }
}
