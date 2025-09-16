public class Hatchimal implements Tradable {
    private String name;
    private int rarity;

    public Hatchimal(String name, int rarity) {
        this.name = name;
        this.rarity = rarity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTradeValue() {
        return rarity * 10; // Arbitrary value logic
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Hatchimal{")
                .append("name='").append(name).append('\'')
                .append(", rarity=").append(rarity)
                .append('}').toString();
    }
}
