package statistics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import statistics.comparators.FrequencyComparator;
import statistics.comparators.WordComparator;
import statistics.components.StatisticsItem;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Statistics implements Iterable<StatisticsItem> {
    Set<StatisticsItem> statistics;

    {
        statistics = new TreeSet<>(new WordComparator());
    }

    @NotNull
    @Override
    public Iterator<StatisticsItem> iterator() {
        return statistics.iterator();
    }

    public void add(String token) {
        StatisticsItem targetItem = find(token);

        if (targetItem == null) {
            create(token);
        } else  {
            update(targetItem);
        }
    }

    public void sortByFrequency() {
        Set<StatisticsItem> sortedStatistics = new TreeSet<>(new FrequencyComparator());
        sortedStatistics.addAll(statistics);
        statistics = sortedStatistics;
    }

    private @Nullable StatisticsItem find(String token) {
        for (StatisticsItem searchedStatisticsItem : statistics) {
            if (searchedStatisticsItem.getWord().token().equals(token)) {
                return searchedStatisticsItem;
            }
        }

        return null;
    }

    private void create(String token) {
        StatisticsItem newStatisticsItem = new StatisticsItem(token);
        statistics.add(newStatisticsItem);
    }

    private void update(StatisticsItem statisticsItem) {
        statisticsItem.increaseFrequency();
    }
}
