import java.util.Random;

public class ArrayListRun {

    private static void sizeColl(ArrayList integers) {
        System.out.println(integers);
        System.out.println("Элементов в коллекции: " + integers.size());
        System.out.println("Среднее арифметическое всех элементов: " + integers.sumElement());
        System.out.println("Максимальное значение коллекции: " + integers.maxElement());
        System.out.println("Минимальное значение коллекции: " + integers.minElement() + "\n");
    }

    public static void printMenu() {
        ArrayList collection = new ArrayList();
        Random random = new Random();

        sizeColl(collection);
        collection.add(null);

        for (int i = 0; i < 5; i++) {
            int rand = random.nextInt(10);
            collection.add(rand);
            System.out.println("Добавление элемента: " + collection);
        }
        System.out.println();
        sizeColl(collection);

        int rand = collection.removeElement(random.nextInt(collection.size() - 1) + 1);
        System.out.println(collection);
        System.out.println("Удаление элемента: " + rand);
        System.out.println("Проверка: " + collection.remove(rand));
        sizeColl(collection);
    }
}
