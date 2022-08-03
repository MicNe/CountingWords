package statistics.components;

public class Frequency {
    private static int totalFrequency;
    private int frequency;

    public Frequency() {
        ++totalFrequency;
        ++frequency;
    }

    public static int getTotalFrequency() {
        return totalFrequency;
    }

    public static void setTotalFrequency(int totalFrequency) {
        Frequency.totalFrequency = totalFrequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
