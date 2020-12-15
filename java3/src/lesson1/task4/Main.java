package lesson1.task4;
//4. Реализовать односвязный список
public class Main {
    public static void main(String[] args) {
SingleLinkedList<Integer> list1=new SingleLinkedList<>();
list1.addLast(1);
        list1.addLast(2);
        list1.addFirst(3);
        list1.addLast(4);
        list1.print();
       System.out.println(list1.get(3));
        printSize(list1);
       list1.removeFirst();
       list1.removeFirst();
       list1.removeLast();
       list1.print();
        printSize(list1);
list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addFirst(4);
        list1.print();
        printSize(list1);
        list1.remove(2);
        list1.remove(0);
        list1.remove(2);
        list1.print();
        printSize(list1);
    }
    static<T> void printSize(SingleLinkedList<T> list){
        if(list.getSize()==0) System.out.print("Size = "+list.getSize());
        System.out.printf("Size of %s = %d\n",list.get(0).getClass().getSimpleName(),list.getSize());
    }
}
