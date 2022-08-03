package statistics.utils;

import statistics.Statistics;

import java.util.List;

public class StatisticsCounter {
    public static Statistics count(List<String> tokens) {
        Statistics statistics = new Statistics();

        for (String token : tokens) {
            statistics.add(token);
        }

        return statistics;
    }
}
