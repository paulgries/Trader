import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tradable hummingbear = new Hatchimal("Hummingbear", 8);
        Tradable draggle = new Hatchimal("Draggle", 12);
        Tradable riverPebble = new Pebble("River Stone", 10);
        Tradable granitePebble = new Pebble("Granite", 2);

        System.out.println(hummingbear);
        System.out.println(draggle);
        System.out.println(riverPebble);
        System.out.println(granitePebble);

        Trader trader = new Trader();

        trader.add(hummingbear);
        trader.add(riverPebble);

        trader.addToWishlist(granitePebble);
        trader.addToWishlist(draggle);

        List<Tradable> offer = new ArrayList<>();
        offer.add(draggle);

        List<Tradable> request = new ArrayList<>();
        request.add(riverPebble);
        request.add(hummingbear);

        System.out.println("Offer sum: " + getSum(offer));
        System.out.println("Request sum: " + getSum(request));

        System.out.println(trader.evaluateTrade(offer, request));
    }

    private static int getSum(List<Tradable> tradables) {
        return tradables.stream().mapToInt(Tradable::getTradeValue).sum();
    }

}