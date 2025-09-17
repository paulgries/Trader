import java.util.ArrayList;
import java.util.List;

public class Trader {
    private List<Tradable> items;
    private List<Tradable> wishlist;

    public Trader() {
        this.items = new ArrayList<>();
        this.wishlist = new ArrayList<>();
    }

    public void add(Tradable t) {
        this.items.add(t);
    }

    /**
     * Agree to a trade if all of the following are true:
     * - at least one item in the offer list is in this Trader's wishlist
     * - all of the items in the request list are in this Trader's inventory
     * - the total value of the Tradables in the offer is within 10% of the request value
     */
    public boolean evaluateTrade(List<Tradable> offer, List<Tradable> request) {
        boolean offerContainsWishlistItem = false;
        for (Tradable t : offer) {
            if (wishlist.contains(t)) {
                offerContainsWishlistItem = true;
            }
        }

        int offerValue = 0;
        for (Tradable t : offer) {
            offerValue += t.getTradeValue();
        }

        int requestValue = 0;
        for (Tradable t : request) {
            requestValue += t.getTradeValue();
        }

        boolean allItemsInInventory = items.containsAll(request);
        boolean valueWithinRange = Math.abs(offerValue - requestValue) <= 0.1 * requestValue;

        return offerContainsWishlistItem && allItemsInInventory && valueWithinRange;
    }

    public void addToWishlist(Tradable t) {
        this.wishlist.add(t);
    }
}
