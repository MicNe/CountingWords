import exceptions.NoTokensException;
import parsing.TokenParser;
import statistics.Statistics;
import statistics.components.Frequency;
import statistics.utils.StatisticsCounter;
import statistics.utils.StatisticsWriter;

import java.util.List;

public class CountingWords {
    public static void main(String[] args) {
        if (args.length == 2) {
            String inputFileName = args[0];
            TokenParser tokenParser = new TokenParser();
            tokenParser.parse(inputFileName);

            List<String> tokens;
            try {
                tokens = tokenParser.getTokens();
            } catch (NoTokensException exception) {
                System.err.println(exception.getMessage());
                return;
            }
            Statistics statistics = StatisticsCounter.count(tokens);

            String outputFileName = args[1];
            StatisticsWriter.write(statistics, outputFileName);

            System.out.println("Total words in input file: " + Frequency.getTotalFrequency());
        } else {
            System.err.println("You must specify the input file name and output file name as arguments of the program");
        }
    }
}
