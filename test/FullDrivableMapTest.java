import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "unsafe", "all"})
public class FullDrivableMapTest {
    DrivableMap dm;

    @Before
    public void setUp() {
        dm = new DrivableMap();
    }

    @Test(timeout = 50)
    public void testAddDrivable() {
        Horse h = new Horse();
        assertTrue(dm.addDrivable("Name", h));
        assertFalse(dm.addDrivable("Name", h));
        assertTrue(dm.addDrivable("Name2", h));
    }

    @Test(timeout = 50)
    public void testAddDrivableHidden() {
        Unicorn u = new Unicorn();
        assertTrue(dm.addDrivable("Something", u));
        assertTrue(dm.addDrivable("Another thing", u));
        assertFalse(dm.addDrivable("Something", u));
        assertFalse(dm.addDrivable("Another thing", u));
    }

    @Test(timeout = 50)
    public void testHasFasterThan() {
        Horse h = new Horse();
        dm.addDrivable("Name", h);
        assertFalse(dm.hasFasterThan(2));
        assertTrue(dm.hasFasterThan(1));
    }

    @Test(timeout = 50)
    public void testHasFasterThanHidden() {
        Horse h = new Horse();
        Unicorn u = new Unicorn();
        dm.addDrivable("Name", h);
        dm.addDrivable("Another", u);
        assertTrue(dm.hasFasterThan(9));
        assertFalse(dm.hasFasterThan(11));
        u.upgradeSpeed();
        assertTrue(dm.hasFasterThan(10));
    }

    @Test(timeout = 50)
    public void testGetTradable() {
        Horse h = new Horse();
        Unicorn u = new Unicorn();
        dm.addDrivable("Horse", h);
        dm.addDrivable("Unicorn", u);

        List<Tradable> tradables = dm.getTradable();
        assertEquals(1, tradables.size());
        assertEquals(h, tradables.get(0));
    }

    @Test(timeout = 50)
    public void testGetTradableHidden() {
        Horse h = new Horse();
        Horse h2 = new Horse();
        Unicorn u = new Unicorn();
        dm.addDrivable("Horse", h);
        dm.addDrivable("Horse2", h2);
        dm.addDrivable("Unicorn", u);

        List<Tradable> tradables = dm.getTradable();
        assertEquals(2, tradables.size());
    }
}
