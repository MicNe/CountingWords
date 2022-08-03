package statistics.utils;

import statistics.Statistics;
import statistics.components.StatisticsItem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class StatisticsWriter {
    public static void write(Statistics statistics, String outputFileName) {
        statistics.sortByFrequency();

        Writer writer = null;

        try {
            writer = new OutputStreamWriter(new FileOutputStream(outputFileName));

            for (StatisticsItem statisticsItem : statistics) {
                writer.write(statisticsItem.toString());
                writer.write("\n");
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException exception) {
                    exception.printStackTrace(System.err);
                }
            }
        }
    }
}
