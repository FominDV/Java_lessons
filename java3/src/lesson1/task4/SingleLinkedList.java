package lesson1.task4;

import java.util.Collection;

public class SingleLinkedList<T> {
    private int size = 0;
    private ElementOfSingleLinkedList linkOfFirstElement, linkOfLastElement;

    public SingleLinkedList() {

    }

    public SingleLinkedList(Collection<? extends T> collection) {
        for (T element : collection) {
            addFirst(element);
        }
    }

    public void addFirst(T object) {
        ElementOfSingleLinkedList<T> newElement = new ElementOfSingleLinkedList<>(object);
        newElement.setLinkOfNextElement(linkOfFirstElement);
        linkOfFirstElement = newElement;
        if (linkOfLastElement == null) linkOfLastElement = newElement;
        size++;
    }

    public void addLast(T object) {
        ElementOfSingleLinkedList<T> newElement = new ElementOfSingleLinkedList<>(object);
        if (linkOfLastElement != null) {
            linkOfLastElement.setLinkOfNextElement(newElement);
        } else {
            linkOfFirstElement = newElement;
        }
        linkOfLastElement = newElement;
        size++;
    }

    public void add(T object, int index) {
        if (index == 0) {
            addFirst(object);
            return;
        }
        ElementOfSingleLinkedList newElement = new ElementOfSingleLinkedList(object);
        newElement.setLinkOfNextElement(getLink(index));
        getLink(index - 1).setLinkOfNextElement(newElement);
        size++;
    }

    public void print() {
        ElementOfSingleLinkedList link = linkOfFirstElement;
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
        linkOfFirstElement = linkOfFirstElement.getLinkOfNextElement();
        if (size == 1) linkOfLastElement = null;
        size--;
    }

    public void removeLast() {
        if (size == 1) {
            linkOfLastElement = null;
            linkOfFirstElement = null;
            size--;
            return;
        }
        ElementOfSingleLinkedList newLastElement = getLink(size - 2);
        newLastElement.setLinkOfNextElement(null);
        linkOfLastElement = newLastElement;
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
        ElementOfSingleLinkedList afterRemovingElement = getLink(index + 1);
        getLink(index - 1).setLinkOfNextElement(afterRemovingElement);
        size--;
    }

    private ElementOfSingleLinkedList getLink(int index) {
        if (!isValidIndex(index)) throw new IndexOutOfBoundsException();
        int counter = 0;
        ElementOfSingleLinkedList link = linkOfFirstElement;
        while (counter < index) {
            link = link.getLinkOfNextElement();
            counter++;
        }
        return link;
    }

    public T get(int index) {
        ElementOfSingleLinkedList link = getLink(index);
        return (T) link.getObject();
    }

    private boolean isValidIndex(int index) {
        return !(index < 0 || index >= size);
    }

    public void set(T object, int index) {
        ElementOfSingleLinkedList newElement = new ElementOfSingleLinkedList(object);
        ElementOfSingleLinkedList pastElement = getLink(index);
        newElement.setLinkOfNextElement(pastElement.getLinkOfNextElement());
        pastElement = newElement;
        if (index != 0)
            getLink(index - 1).setLinkOfNextElement(newElement);
    }
}
