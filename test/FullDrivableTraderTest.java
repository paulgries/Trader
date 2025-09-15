import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "unsafe", "all"})
public class FullDrivableTraderTest {
    DrivableTrader dt;

    @Before
    public void setUp() {
        dt = new DrivableTrader(10);
    }

    @Test(timeout = 50)
    public void TestGetSellingPrice() {
        Horse h = new Horse();
        Unicorn u = new Unicorn();
        assertEquals(11, dt.getSellingPrice(h));
        assertEquals(Tradable.MISSING_PRICE, dt.getSellingPrice(u));
    }

    @Test(timeout = 50)
    public void TestGetSellingPriceVaryingSpeed() {
        Horse h = new Horse();
        h.upgradeSpeed();
        assertEquals(12, dt.getSellingPrice(h));
    }

    @Test(timeout = 50)
    public void TestGetSellingPriceVaryingSpeedHidden() {
        Horse h = new Horse();
        h.upgradeSpeed();
        h.upgradeSpeed();
        h.upgradeSpeed();
        assertEquals(14, dt.getSellingPrice(h));
    }

}
