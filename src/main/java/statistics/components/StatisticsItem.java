package statistics.components;

public class StatisticsItem {
    private final Word word;
    private final Frequency frequency;

    {
        frequency = new Frequency();
    }

    public StatisticsItem(String token) {
        word = new Word(token);
    }

    public Word getWord() {
        return word;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void increaseFrequency() {
        Frequency.setTotalFrequency(Frequency.getTotalFrequency() + 1);
        frequency.setFrequency(frequency.getFrequency() + 1);
    }

    @Override
    public String toString() {
        return word.token()
                + ';' + frequency.getFrequency()
                + ';' + (float)frequency.getFrequency() / (float)Frequency.getTotalFrequency();
    }
}
