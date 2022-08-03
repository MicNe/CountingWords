package parsing;

import exceptions.NoTokensException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class TokenParser {
    private final List<String> tokens;

    {
        tokens = new ArrayList<>();
    }

    public void parse(String inputFileName) {
        Reader reader = null;
        StringBuilder token = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(inputFileName));

            while (true) {
                int codePoint = reader.read();
                char symbol = (char)codePoint;

                if (Character.isLetterOrDigit(symbol)) {
                    token.append(symbol);
                } else {
                    if (!token.isEmpty()) {
                        tokens.add(token.toString());
                        token.delete(0, token.length());
                    }

                    if (codePoint == StreamTokenizer.TT_EOF) {
                        break;
                    }
                }
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException exception) {
                    exception.printStackTrace(System.err);
                }
            }
        }
    }

    public List<String> getTokens() throws NoTokensException {
        if (tokens.isEmpty()) {
            throw new NoTokensException("There are no tokens (check input file)");
        } else {
            return tokens;
        }
    }
}
