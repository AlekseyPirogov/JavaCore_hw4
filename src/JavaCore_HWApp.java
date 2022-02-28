// Дисциплина: Java Core для тестировщиков
// Домашнее задание №4 "ArrayList"
// Студент: Алексей Пирогов
// Дата: 28.02.2022

import java.util.ArrayList;
import java.util.Arrays;

// Задание:

// 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести
// список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз
// встречается каждое слово.

// 2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефон-
// ных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи, а с по-
// мощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может
// быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться
// все телефоны.

public class JavaCore_HWApp {

    public static void main(String[] args) {

        System.out.println("Задание 1. Пример работы с ArrayList: ");
        ArrayList<String> arrayList; // Массив ArrayList
        // Наполнение массива данными с использование контруктора класса
        arrayList = new ArrayList<>(Arrays.asList("Москва", "Вашингтон", "Париж", "Вена", "Прага", "Берлин", "Лондон", "Пекин", "Токио", "Дели"));

        // Добавление в массив данных с использование метода add
        arrayList.add("Будапешт");
        arrayList.add("Лондон");
        arrayList.add("Москва");
        arrayList.add("Варшава");
        arrayList.add("Варшава");
        arrayList.add("Вашингтон");
        arrayList.add("Москва");
        arrayList.add("Москва");
        arrayList.add("Варшава");
        arrayList.add("Москва");
        arrayList.add("Москва");
        arrayList.add("Москва");
        arrayList.add("Варшава");
        arrayList.add("Варшава");

        // Вывод информации об исходном массиве
        System.out.println(" - размер массива \"arrayList\" с исходными данными: " + arrayList.toArray().length + ". Состав:\n"); //+ arrayList.toString() + "\n");

        for (int i = 0; i < arrayList.toArray().length; i++)
            System.out.print(arrayList.get(i) + ", ");

        // Объявление массива с уникальными элементами (с параметром UniqueElement)
        ArrayList<UniqueElement> arrayListWithUniqueElement = new ArrayList<>(arrayList.toArray().length);
        // Объявление объекта типа UniqueElement
        UniqueElement uniqueElement;
        // Счётчик количества уникальных элементов
        int counterUniqueElement = 1;
        // Цикл по массиву с исходными данными для перебора всех элементов
        for (int i = 0; i < arrayList.toArray().length; i++) {
            // Создание записи уникальных данных и размещение её в массиве с уникальными данными
            uniqueElement = new UniqueElement(arrayList.get(i),counterUniqueElement);
            arrayListWithUniqueElement.add(i, uniqueElement);

            // Цикл для сравнения найденной ранее уникальной записи с последующими элементами исходного масива
            for (int j = i + 1; j < arrayList.toArray().length; j++) {
                // Если i-й и j-й элементы равны, то увеличение счётчика количества уникальных элементов:
                if (arrayList.get(i).equals(arrayList.get(j))) {
                    counterUniqueElement++;                             // увеличение значения счётчика
                    uniqueElement.setCount(counterUniqueElement);       // запись информации уникального значения в обект типа uniqueElement
                    arrayListWithUniqueElement.set(i,uniqueElement);    // добавление к массиву с уникальными заначениями соответствующей записи
                    arrayList.remove(j);    // удаление соответсвующей строки из исходного масства данных
                    j--;    // декремент счётчика для исключения ситуации, когда идут два одинаковых элемета друг за другом в исходном массиве
                }
            }
            // Сброс счётчика количества уникальных элементов
            counterUniqueElement = 1;
        }

        // Вывод информации об массиве с уникальными данными:
        System.out.println("\n\n - размер массива \"arrayListWithUniqueElement\" с уникальными элементами: " + arrayListWithUniqueElement.toArray().length + ". Состав:");
        for (int i = 0; i < arrayListWithUniqueElement.toArray().length; i++)
            System.out.println(arrayListWithUniqueElement.get(i).toString());

        System.out.println("\n\nЗадание 2. Пример работы с ArrayList: ");
        ArrayList<PhoneBook> phoneBooks = new ArrayList<>();
        phoneBooks.add(new PhoneBook("Иванов", "+74991234567"));
        phoneBooks.add(new PhoneBook("Петров", "+79991230001"));
        phoneBooks.add(new PhoneBook("Сидоров", "+79991230001"));
        phoneBooks.add(new PhoneBook("Петров", "+74951230033"));
        phoneBooks.add(new PhoneBook("Васильев", "+79099099090"));
        phoneBooks.add(new PhoneBook("Иванов", "+74951230022"));

        System.out.println("Исходный масств с телефонными номерами:" + phoneBooks.toArray().length);

        for(int i = 0; i < phoneBooks.toArray().length; i++)
            System.out.println(phoneBooks.get(i));

        System.out.println("\nСписок совпадений для фамилии \"Иванов\": ");
        PhoneBook.getPhone("Иванов", phoneBooks);

        System.out.println("\nСписок совпадений для фамилии \"Петров\": ");
        PhoneBook.getPhone("Петров", phoneBooks);
    }
}
