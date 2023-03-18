import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        System.out.println("_____Задача 1_____");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i, (int) (Math.random() * 100));
        }
        System.out.println(list);

        Comparator<Integer> comparator = Integer::compare;

        Stream<Integer> integerStream = list.stream();

        BiConsumer<Integer, Integer> biConsumer = (min, max) ->
                System.out.println("Максимальное значение " + max +
                        " , минимальное значение " + min);

        findMinMax(integerStream, comparator, biConsumer);

    }

    public static void task2() {
        System.out.println("_____Задача 2_____");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i, (int) (Math.random() * 100));
        }

        List<Integer> list2 = list.stream()
                .filter(a -> a % 2 == 0)
                .toList();

        System.out.println("В списке " + list + " " +
                list2.size() + " четных элемента и они равны " +
                list2);
    }


    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        T minValue = list.get(0);
        T maxValue = list.get(list.size() - 1);
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else minMaxConsumer.accept(minValue, maxValue);
    }


}