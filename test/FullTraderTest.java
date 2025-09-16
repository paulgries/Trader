/*
 * This file contains JUnit test cases for Trader.java
 * You should NOT modify this file!
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FullTraderTest {
    Trader trader;

    @Before
    public void setUp() {
        trader = new Trader();
    }

    @Test(timeout = 50)
    public void TestEmptyConstructor() {
        assertEquals(0, trader.getInventory().size());
        assertEquals(0, trader.getWishlist().size());
    }


    @Test(timeout = 50)
    public void TestAddToWishlist() {
        trader.addToWishlist(new Hatchimal(1));
        assertEquals(1, trader.getWishlist().size());
    }


    @Test(timeout = 50)
    public void TestAddToWishlistHidden() {
        trader.addToWishlist(new Horse());
        trader.addToWishlist(new Horse());
        trader.addToWishlist(new Horse());
        assertEquals(3, trader.getWishlist().size());
    }

    @Test(timeout = 50)
    public void TestGetSellingPrice() {
        Horse h = new Horse();
        Unicorn u = new Unicorn();
        assertEquals(10, trader.getSellingPrice(h));
        assertEquals(Tradable.MISSING_PRICE, trader.getSellingPrice(u));
    }
}