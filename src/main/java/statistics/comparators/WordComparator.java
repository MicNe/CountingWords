package statistics.comparators;

import statistics.components.StatisticsItem;

import java.util.Comparator;

public class WordComparator implements Comparator<StatisticsItem> {
    @Override
    public int compare(StatisticsItem statisticsItem1, StatisticsItem statisticsItem2) {
        return statisticsItem1.getWord().token().compareTo(statisticsItem2.getWord().token());
    }
}
