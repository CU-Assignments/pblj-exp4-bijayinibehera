import java.util.*;

class Card {
    private String symbol;
    private int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return symbol + " " + number;
    }
}

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Card>> cardMap = new TreeMap<>(); // TreeMap for sorted symbols

        // Get number of cards
        System.out.print("Enter Number of Cards: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input cards
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter card " + i + ": ");
            String symbol = scanner.nextLine();
            int number = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Add card to the map
            cardMap.putIfAbsent(symbol, new ArrayList<>()); // Create list if not present
            cardMap.get(symbol).add(new Card(symbol, number));
        }

        // Print distinct symbols
        System.out.print("\nDistinct Symbols are: ");
        for (String symbol : cardMap.keySet()) {
            System.out.print(symbol + " ");
        }
        System.out.println();

        // Print cards, count, and sum for each symbol
        for (Map.Entry<String, List<Card>> entry : cardMap.entrySet()) {
            String symbol = entry.getKey();
            List<Card> cards = entry.getValue();
            int sum = 0;

            System.out.println("\nCards in " + symbol + " Symbol");
            for (Card card : cards) {
                System.out.println(card);
                sum += card.getNumber();
            }
            System.out.println("Number of cards : " + cards.size());
            System.out.println("Sum of Numbers : " + sum);
        }

        scanner.close();
    }
}

/* OUTPUT -
Enter Number of Cards: 5
Enter card 1: 
H
1
Enter card 2: 
H
4
Enter card 3: 
D
3
Enter card 4: 
D
6
Enter card 5: 
S
7

Distinct Symbols are: D H S 

Cards in D Symbol
D 3
D 6
Number of cards : 2
Sum of Numbers : 9

Cards in H Symbol
H 1
H 4
Number of cards : 2
Sum of Numbers : 5

Cards in S Symbol
S 7
Number of cards : 1
Sum of Numbers : 7
 */