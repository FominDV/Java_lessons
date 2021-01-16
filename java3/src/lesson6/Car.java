package lesson6;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
    private static boolean hasWinner;
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private ArrayList<Stage> stages;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        stages = race.getStages();
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(name + " готов");
            MainClass.preparingCDL.countDown();
            MainClass.preparingCDL.await();
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < stages.size(); i++) {
            stages.get(i).go(this);
        }
        if(!hasWinner){
            hasWinner=true;
            System.out.println(name+" - WIN");
        }
        MainClass.preparingCDL.countDown();
    }
}
