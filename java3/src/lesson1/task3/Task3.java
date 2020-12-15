package lesson1.task3;

/*3. Большая задача:
        a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
         поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
        d. Сделать метод getWeight() который высчитывает вес коробки,
        зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
        которую подадут в compare в качестве параметра, true - если их веса равны,
         false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов,
        нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
        которые были в этой коробке;
        g. Не забываем про метод добавления фрукта в коробку.*/
public class Task3 {
    public static void main(String[] args) {
        Box<Orange> box1 = new Box<>("box1");
        box1.putFruit(new Orange());
        box1.putFruit(new Orange());
        box1.putFruit(new Orange(), 2);
        Box<Apple> box2 = new Box<>("box2");
        box2.putFruit(new Apple(), 6);
        Box<Orange> box3 = new Box<>("box3");
        box3.putFruit(new Orange(), 5);
        Box<Orange> box4 = new Box<>("box4");
        box4.putFruit(new Orange(), 3);
        Box<Apple> box5 = new Box<>("box5");
        box5.putFruit(new Apple(), 6);
        printWeightOfBox(box1);
        printWeightOfBox(box2);
        printWeightOfBox(box3);
        printWeightOfBox(box4);
        printWeightOfBox(box5);
        printComparingOfBoxes(box1, box2);
        printComparingOfBoxes(box1, box3);
        printComparingOfBoxes(box1, box3);
        printComparingOfBoxes(box2, box3);
        printComparingOfBoxes(box2, box4);
        printComparingOfBoxes(box2, box5);
        box3.moveToOtherBox(box4);
        printWeightOfBox(box3);
        printWeightOfBox(box4);
        box5.moveToOtherBox(box2);
        printWeightOfBox(box2);
        printWeightOfBox(box5);
        printComparingOfBoxes(box2,box4);
        box1.moveToOtherBox(box2);
        printWeightOfBox(box2);
    }

    private static void printWeightOfBox(Box box) {
        System.out.println("Weight of " + box.toString() + " is " + box.getWeight());
    }

    private static void printComparingOfBoxes(Box box1, Box box2) {
        System.out.printf("Weights of %s and %s are equal: %b\n", box1.toString(), box2.toString(), box1.compare(box2));
    }
}
