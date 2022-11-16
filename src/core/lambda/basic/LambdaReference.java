package core.lambda.basic;

import core.model.Apple;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class LambdaReference {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("B", "b", "A", "a"));
        list.sort(String::compareToIgnoreCase);
        list.forEach(System.out::println);
        Function<String, Integer> parseInt = Integer::parseInt;
        List<String> inList = Arrays.asList("1", "2", "3", "4", "5");
        inList.stream().map(parseInt).forEach(System.out::println);
        BiPredicate<List<String>, String> containElement = List::contains;
        List<Integer> weights = Arrays.asList(1, 2, 3, 4, 5);
        List<Apple> apples = map(weights, Apple::new);
        apples.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        apples.forEach(System.out::println);
        BiFunction<Integer, String, Apple> appleConstructor = Apple::new;
        Map<String, Integer> stringIntegerMap = Map.of("red", 1, "orange", 2, "kiwi", 0);
        List<Apple> allConstApples = map(stringIntegerMap, appleConstructor);
        allConstApples.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor));
        allConstApples.forEach(System.out::println);

        Apple a = appleConstructor.apply(23, "orange");
        System.out.println(a);
    }

    private static List<Apple> map(List<Integer> weights, Function<Integer, Apple> func) {
        List<Apple> apples = new ArrayList<>();
        for (Integer i : weights) {
            apples.add(func.apply(i));
        }
        return apples;
    }

    private static List<Apple> map(Map<String, Integer> pairs, BiFunction<Integer, String, Apple> biFunc) {
        List<Apple> apples = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : pairs.entrySet()) {
            apples.add(biFunc.apply(entry.getValue(), entry.getKey()));
        }
        return apples;
    }
}
