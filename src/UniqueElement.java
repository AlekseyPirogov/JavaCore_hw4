
import java.util.ArrayList;
import java.util.Arrays;

// Класс для хранения записей об уникальных элементах:

public class UniqueElement {

    // Поля для хранения записи об объекте
    private String uniqueNname;
    private Integer counterRepeat;

    // Параметризованынй конструктор класса для создания уникальной записи
    public UniqueElement(String name, int count){
        this.uniqueNname = name;
        this.counterRepeat = (Integer)count;
    }

    // Набор из геттера и сеттера для работы со счётчиком количества ункальных записей
    public Integer getCount() {
        return counterRepeat;
    }

    public void setCount(Integer count) {
        this.counterRepeat = count;
    }

    // Переопределённый метод для вывода информации о записи

    @Override
    public String toString() {
        return "UniqueElement {" +
                "uniqueNname='" + uniqueNname + '\'' +
                ", counterRepeat=" + counterRepeat +
                '}';
    }
}
