package lesson1.task4;

import java.util.Collection;

public class SingleLinkedList<T> {
    private int size = 0;
    private Node<T> head, tail;

    public SingleLinkedList() {

    }

    public SingleLinkedList(Collection<? extends T> collection) {
        for (T element : collection) {
            addFirst(element);
        }
    }

    public void addFirst(T object) {
        Node<T> newElement = new Node<>(object);
        newElement.setLinkOfNextElement(head);
        head = newElement;
        if (tail == null) tail = newElement;
        size++;
    }

    public void addLast(T object) {
        Node<T> newElement = new Node<>(object);
        if (tail != null) {
            tail.setLinkOfNextElement(newElement);
        } else {
            head = newElement;
        }
        tail = newElement;
        size++;
    }

    public void add(T object, int index) {
        if (index == 0) {
            addFirst(object);
            return;
        }
        Node newElement = new Node(object);
        newElement.setLinkOfNextElement(getLink(index));
        getLink(index - 1).setLinkOfNextElement(newElement);
        size++;
    }

    public void print() {
        Node link = head;
        System.out.print("[ ");
        while (link != null) {
            System.out.print(link.getObject().toString() + " ");
            link = link.getLinkOfNextElement();
        }
        System.out.print("]\n");
    }

    public int getSize() {
        return size;
    }

    public void removeFirst() {
        head = head.getLinkOfNextElement();
        if (size == 1) tail = null;
        size--;
    }

    public void removeLast() {
        if (size == 1) {
            tail = null;
            head = null;
            size--;
            return;
        }
        Node newLastElement = getLink(size - 2);
        newLastElement.setLinkOfNextElement(null);
        tail = newLastElement;
        size--;
    }

    public void remove(int index) {
        if (index == size - 1) {
            removeLast();
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node afterRemovingElement = getLink(index + 1);
        getLink(index - 1).setLinkOfNextElement(afterRemovingElement);
        size--;
    }

    private Node getLink(int index) {
        if (!isValidIndex(index)) throw new IndexOutOfBoundsException();
        int counter = 0;
        Node link = head;
        while (counter < index) {
            link = link.getLinkOfNextElement();
            counter++;
        }
        return link;
    }

    public T get(int index) {
        Node link = getLink(index);
        return (T) link.getObject();
    }

    private boolean isValidIndex(int index) {
        return !(index < 0 || index >= size);
    }

    public void set(T object, int index) {
        Node newElement = new Node(object);
        Node pastElement = getLink(index);
        newElement.setLinkOfNextElement(pastElement.getLinkOfNextElement());
        pastElement = newElement;
        if (index != 0)
            getLink(index - 1).setLinkOfNextElement(newElement);
    }
    class Node<T> {
        T object;
       Node<T> linkOfNextElement;

        public Node(T object) {
            this.object = object;
        }

        public void setLinkOfNextElement(Node linkOfNextElement) {
            this.linkOfNextElement = linkOfNextElement;
        }

        public T getObject() {
            return object;
        }
        public Node getLinkOfNextElement(){
            return linkOfNextElement;
        }
    }
}
