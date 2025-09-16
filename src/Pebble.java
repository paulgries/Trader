public class Pebble implements Tradable {
    private String type;
    private int smoothness;

    public Pebble(String type, int smoothness) {
        this.type = type;
        this.smoothness = smoothness;
    }

    @Override
    public String getName() {
        return type;
    }

    @Override
    public int getTradeValue() {
        return smoothness * 5;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Pebble{")
                .append("type='").append(type).append('\'')
                .append(", smoothness=").append(smoothness)
                .append('}')
                .toString();
    }
}
