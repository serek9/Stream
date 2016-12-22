import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. Find all transactions in the year 2011 and sort them by value (small to high).
        List<Transaction> transactions1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(transactions1);
        //2. What are all the unique cities where the traders work?
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().collect(toList());
        System.out.println(cities);
        //3. Find all traders from Cambridge and sort them by name.
        List<Trader> Cambridgetraders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct().sorted(Comparator.comparing(Trader::getName))
                .collect(toList());
        System.out.println(Cambridgetraders);
        //4. Return a string of all traders’ names sorted alphabetically.
        String Stringtraders = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct().sorted().reduce("", (n1, n2) -> n1 + n2);
        System.out.println(Stringtraders);
        //5. Are any traders based in Milan?
        boolean Basedmilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader()
                        .getCity().equals("Milan"));
        System.out.println(Basedmilan);
        //6. Print all transactions’ values from the traders living in Cambridge.
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        //7. What’s the highest value of all the transactions?
        Optional<Integer> highest = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(highest);
        //8. Find the transaction with the smallest value.
        Optional<Transaction> smallest = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
    }
}
