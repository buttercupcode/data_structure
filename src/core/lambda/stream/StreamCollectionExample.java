package core.lambda.stream;

import core.model.Dish;
import core.model.Trader;
import core.model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamCollectionExample {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));


        System.out.println(menu
                .stream()
                .max(Comparator.comparingInt(Dish::getCalories)));


        System.out.println(menu.stream()
                .collect(summingInt(Dish::getCalories)));
        IntSummaryStatistics intSummaryStatistics = menu.stream()
                .collect(summarizingInt(Dish::getCalories));
        System.out.println("Int summary :: " + intSummaryStatistics);
        /// join strings
        System.out.println(menu.stream().map(Dish::getName).collect(joining(", ")));
        System.out.println(" Total calories " + menu
                .stream()
                .collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j)));

        System.out.println(menu
                .stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        menu.stream()
                .collect(reducing(0, Dish::getCalories, Integer::sum));
        menu.stream()
                .map(Dish::getCalories).reduce(Integer::sum)
                .get();
        long sum = menu.stream()
                .mapToLong(Dish::getCalories)
                .sum();
        System.out.println("Calories total : " + sum);
        menu.stream()
                .map(Dish::getName)
                .collect(joining());
        menu.stream()
                .map(Dish::getName)
                .collect(reducing((d1, d2) -> d1 + d2))
                .get();
        // menu.stream().collect(reducing((dish, dish2) -> dish.getName()+dish2.getName())).get()
        String collect8 = menu.stream()
                .collect(reducing("", Dish::getName, (dish1Name, dish2Name) -> dish1Name + dish1Name));
        Map<Dish.Type, List<Dish>> collect = menu.stream()
                .collect(groupingBy(Dish::getType));
        collect.forEach((type, dishes) -> {
            System.out.print("Type " + type);
            dishes.forEach(dish -> {
                System.out.print(" Dish:: " + dish);
            });
            System.out.println();
        });
        Map<Dish.Type, Map<String, List<Dish>>> typeMapMap = menu.
                stream()
                .collect(groupingBy(Dish::getType, groupingBy(dish ->
                {
                    if (dish.getCalories() <= 400) return "Dieting";
                    else return "Not Dieting";
                })));

        Map<Dish.Type, Long> collect2 = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));
        collect2
                .forEach((dish, count) -> System.out.println("[dish " + dish.name() + " count " + count + "]"));
        Map<Dish.Type, Optional<Dish>> collect1 = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        menu.stream()
                .collect(
                        groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(Comparator.comparingInt(Dish::getCalories))
                                        , Optional::get)));
        menu.stream().collect(
                groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));
        Map<Dish.Type, Set<Dish.CaloricLevel>> collect3 = menu.stream().collect(groupingBy(Dish::getType,
                mapping(dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() > 400 && dish.getCalories() > 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                }, toSet())));
        List<String> collect7 = collect3.entrySet()
                .stream()
                .map(typeSetEntry -> {
                    String value = typeSetEntry.getValue().stream().map(Dish.CaloricLevel::name).collect(joining("'"));
                    return typeSetEntry.getKey().name() + " " + value;
                }).collect(toList());
        collect7.forEach(System.out::println);
        Map<Boolean, List<Dish>> collect4 = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        Map<Boolean, Map<Dish.Type, List<Dish>>> collect5 = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        Map<Boolean, Dish> collect6 = menu
                .stream()
                .collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories))
                                        , Optional::get)));
        menu.stream().mapToLong(Dish::getCalories).reduce((c1, c2) -> c1 * 31 + c2).orElse(-1);
    }
}
