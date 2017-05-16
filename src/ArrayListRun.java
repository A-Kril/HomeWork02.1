
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayListRun {

    public ArrayList<Integer> collection = new ArrayList<>();
    Random random = new Random();
    public int rand;

    public static void main(String[] args) {
        ArrayListRun colrun = new ArrayListRun();
        colrun.sizeCollection();
        colrun.minmaxElement();
        colrun.sumElement();
        colrun.addElement();
        colrun.removeElement();
        colrun.indexElement();
        colrun.setElement();
    }

    public void sizeCollection() {

        System.out.println("Коллекция: \nЗаполнение целыми числами:");

                for (int i = 0; i < 10; i++) {
            rand = random.nextInt(10);
            collection.add(rand);
            System.out.print("Элементы коллекции:");
            System.out.println(" " + collection);
        }
    }

    public void minmaxElement() {

        System.out.println("1) Минимальное значение коллекции: - " + Collections.min(collection) + "\n");
        System.out.println("2) Максимальное значение коллекции: - " + Collections.max(collection) + "\n");
    }

    public void sumElement() {

        double sum = 0;

        for (int i = 0; i < collection.size(); i++)
            sum += collection.get(i);

        System.out.println("3) Среднее арифметическое всех элементов: " + sum / collection.size() + "\n");
    }

    public void addElement() {

            System.out.println("4) Добавление элемента: \n");
            collection.add(rand);

            for (int i = 0; i < collection.size(); ++i) {
                collection.set(i, collection.get(i) + rand);
            }
            System.out.println("Коллекция после изминения: " + collection + "\n");
        }

    public void removeElement() {
            System.out.println("5) Удаление элемента: \n"); //уменьшается на индекс, а не на число

                for (int i = 0; i < collection.size(); i++) {
                    collection.set(i, collection.get(i) - rand);
                }
                collection.remove(rand);

                System.out.println("Коллекция после изминения: " + collection + "\n");

        }

    public void indexElement() {

        System.out.println("6) Поиск элемента по значению:"); //если нет такого значения, то нужен фолс
            int index = collection.indexOf(rand);
            for (int i = 0; i < collection.size()-1; i++)
                collection.indexOf(i);
        System.out.println("Элемент \"" + rand + "\" находится под: [" + index + "]-м индексом\n");
    }

    public void setElement() {

        System.out.println("7) Поиск числа по индексу:");
        int m = collection.set(rand, collection.size());
        System.out.println("Под индексом [" + rand + "] находится число: " + m + "\n");
    }
}