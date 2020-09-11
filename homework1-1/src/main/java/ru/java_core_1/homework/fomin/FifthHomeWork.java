package ru.java_core_1.homework.fomin;

/*
* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 * Создать массив из 5 сотрудников
 Пример:
 Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 persArray[1] = new Person(...);
 ...
 persArray[4] = new Person(...);

 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 * */
public class FifthHomeWork {
    public static void main(String[] args) {
        Employee[] dataOfEmployees = new Employee[5];
        dataOfEmployees[0] = new Employee("Ivan Bukin", "Engineer", "bukin@mail.ru", "+79451733943", 55000, 29);
        dataOfEmployees[1] = new Employee("Sasha Aleksandrova", "Cook", "999right@yandex.ru", "89068889988", 35000, 49);
        dataOfEmployees[2] = new Employee("Dmitriy Gavarov", "Locksmith", "mine666@yandex.ru", "+7895987786", 28000, 69);
        dataOfEmployees[3] = new Employee("Duke Nukem", "Artist", "photo777@gmail.ru", "+74956667861", 18000, 21);
        dataOfEmployees[4] = new Employee("Barsik Oneblack", "Seller", "catlife@mail.ru", "89069191918", 35000, 48);
        for (Employee data : dataOfEmployees) {
            if (data.age>40){
                data.outDataOfEmployee();
            }
        }
    }

}
