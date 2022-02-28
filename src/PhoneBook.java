// Дисциплина: Java Core для тестировщиков
// Домашнее задание №4 "ArrayList"
// Студент: Алексей Пирогов
// Дата: 28.02.2022

import java.util.ArrayList;

public class PhoneBook {

    // Поля для хранения записи об объекте
    private String surname;
    private String phoneNimber;

    // Параметризованынй конструктор класса для создания уникальной записи
    public PhoneBook(String surname, String phoneNimber){
        this.surname = surname;
        this.phoneNimber = phoneNimber;
    }

    // Набор из геттера и сеттера для работы со счётчиком количества ункальных записей
    public String getSurname() {
        return surname;
    }

    public String getPhoneNimber() {
        return phoneNimber;
    }

    public String getObject() {
        return this.getSurname() + "\t" +  this.getPhoneNimber();
    }

    // Переопределённый метод для вывода информации о записи
    @Override
    public String toString() {
        return "UniqueElement{" +
                "surname='" + surname + '\'' +
                ", phoneNimber='" + phoneNimber + '\'' +
                '}';
    }

    public static void getPhone(String strToSearch, ArrayList<PhoneBook> phoneBooks) {
        for (int i = 0; i < phoneBooks.toArray().length; i++)
            if (phoneBooks.get(i).getSurname().equals(strToSearch))
                System.out.println(phoneBooks.get(i));
    }
}
