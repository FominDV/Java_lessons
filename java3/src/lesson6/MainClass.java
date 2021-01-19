package lesson6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/*Организуем гонки:
Все участники должны стартовать одновременно, несмотря на то, что на подготовку у каждого из них уходит разное время.
В туннель не может заехать одновременно больше половины участников (условность).
Попробуйте всё это синхронизировать.
Только после того как все завершат гонку, нужно выдать объявление об окончании.*/
public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CountDownLatch preparingCDL;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        reloadPreparingCDL();
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        preparingCDL.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        reloadPreparingCDL();
        preparingCDL.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
    private static void reloadPreparingCDL(){
        preparingCDL =new CountDownLatch(CARS_COUNT);
    }
}