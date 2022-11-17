package core.lambda.stream;

import core.model.Dish;
import core.model.Trader;
import core.model.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamExamples {
    public static void main(String[] args) {
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
        System.out.println("general filter criteria");
        menu.stream().filter(dish -> {
            System.out.println("filtering dish " + dish);
            return dish.getCalories() > 300;
        }).map(dish -> {
            System.out.println(" mapping name " + dish);
            return dish.getName();
        }).toList().forEach(System.out::println);
        System.out.println("print only vegetarian dish");
        menu.stream().filter(Dish::isVegetarian).toList().forEach(System.out::println);
        System.out.println("skip first two meat dishes");
        menu.stream().filter(dish -> dish.getType() == Dish.Type.MEAT).skip(2).toList().forEach(System.out::println);
        // String example
        List<String> words = Arrays.asList("Hello", "manvi", "sharma");
        List<String> strings = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(6, 8);
        List<int[]> collect = list1.stream().flatMap(i -> list2.stream().map(j -> new int[]{i, j})).toList();
        collect.stream().flatMapToInt(Arrays::stream).forEach(System.out::println);
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(System.out::println);
        menu.stream().map(Dish::getCalories).reduce((c1, c2) -> c1 * c2).ifPresent(System.out::println);
        System.out.println((long) menu.size());
        System.out.println(menu.stream().mapToInt(Dish::getCalories).max());


        //////
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
        //   Find all transactions in the year 2011 and sort them by value (small to high).
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        // 2.  What are all the unique cities where the traders work?
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .toList()
                .forEach(System.out::println);

        //3.  Find all traders from Cambridge and sort them by name.
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> Objects.equals(trader.getCity(), "Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .toList()
                .forEach(System.out::println);
        // 4.  Return a string of all traders’ names sorted alphabetically.
        System.out.println(transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining()));
        //5.  Are any traders based in Milan?
        System.out.println("Traders in Milan " + transactions
                .stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan")));

        //  6.  Print all transactions’ values from the traders living in Cambridge.
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .toList().
                forEach(transaction -> System.out.println(transaction.getValue()));
        //7.  What’s the highest value of all the transactions?
        System.out.println("Max value of a transaction " + transactions.stream()
                .max(Comparator.comparing(Transaction::getValue)));
        //8.  Find the transaction with the smallest value.
        System.out.println("Min value of a transaction " + transactions.stream()
                .min(Comparator.comparing(Transaction::getValue)));
        System.out.println("Max even in 100 " + IntStream.
                rangeClosed(1, 100)
                .filter(x -> x % 2 == 0)
                .max()
                .orElse(-1));
        ////////////////////////// Print 1st twenty pythagoreus
        IntStream.rangeClosed(1, 100)
                .boxed()
                .limit(20)
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}))
                .forEach(t -> System.out.println(t[0] + " " + t[1] + " " + t[2]));
        Stream.of("java", "is", "always", "testing", "me")
                .map(String::toUpperCase)
                .forEach(System.out::println);
// first 10 even numbers
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        /// fibonacci series

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.print(t[0] + " "));
    }
}
