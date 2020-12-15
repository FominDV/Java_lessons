package lesson1.task4;

public class ElementOfSingleLinkedList<T> {
    T object;
    ElementOfSingleLinkedList linkOfNextElement;

    public ElementOfSingleLinkedList(T object) {
        this.object = object;
    }

    public void setLinkOfNextElement(ElementOfSingleLinkedList linkOfNextElement) {
        this.linkOfNextElement = linkOfNextElement;
    }

    public T getObject() {
        return object;
    }
    public ElementOfSingleLinkedList getLinkOfNextElement(){
        return linkOfNextElement;
    }
}
