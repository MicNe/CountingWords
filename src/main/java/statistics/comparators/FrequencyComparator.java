package statistics.comparators;

import statistics.components.StatisticsItem;

import java.util.Comparator;

public class FrequencyComparator implements Comparator<StatisticsItem> {
    @Override
    public int compare(StatisticsItem statisticsItem1, StatisticsItem statisticsItem2) {
        if (statisticsItem1.getFrequency().getFrequency() == statisticsItem2.getFrequency().getFrequency()) {
            return statisticsItem1.getWord().token().compareTo(statisticsItem2.getWord().token());
        } else {
            return statisticsItem2.getFrequency().getFrequency() - statisticsItem1.getFrequency().getFrequency();
        }
    }
}
