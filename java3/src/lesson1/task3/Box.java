package lesson1.task3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();
    private String name;

    protected Box(String name) {
        this.name = name;
    }

    protected void putFruit(T fruit) {
        fruits.add(fruit);
    }

    protected void putFruit(T fruit, int countOfFruits) {
        for (int i = 0; i < countOfFruits; i++)
            fruits.add(fruit);
    }


    protected float getWeight() {
        if (fruits.size() == 0) return 0;
        return fruits.size() * fruits.get(0).getWeight();
    }

    protected boolean compare(Box otherBox) {
        if (getWeight() == otherBox.getWeight()) return true;
        else return false;
    }

    protected void moveToOtherBox(Box<T> box) {
        if(!this.getClass().equals(box.getClass())) return;
        for (T fruit : fruits)
            box.putFruit(fruit);
        System.out.printf("Fruits from %s was moved to %s\n",toString(),box.toString());
        fruits.clear();
    }

    @Override
    public String toString() {
        if (fruits.size() == 0) return name;
        return name + " with " + fruits.get(0).getClass().getSimpleName();
    }

}
