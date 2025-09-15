/* A sample class that implements the given interfaces.
 */
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "unsafe", "all"})
public class Zebra implements Drivable, Domesticatable, Tradable {
    private int maxSpeed;

    public Zebra() {
        this.maxSpeed = 18;
    }

    @Override
    public String sound() {
        return "Neigh!";
    }

    @Override
    public void upgradeSpeed() {
        this.maxSpeed += 2;
    }

    @Override
    public void downgradeSpeed() {
        this.maxSpeed--;
    }

    @Override
    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    @Override
    public int getPrice() {
        return 17;
    }
}
