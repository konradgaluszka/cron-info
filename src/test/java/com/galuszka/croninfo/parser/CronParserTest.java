package com.galuszka.croninfo.parser;

import com.galuszka.croninfo.parser.CronParser;
import com.galuszka.croninfo.parser.ParsedCron;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CronParserTest {
    private final CronParser cronParser = new CronParser();

    @Test
    void parsesCronWithWildcards() {
        // when
        ParsedCron result = cronParser.parse("*/10 3,7 1-3 * * command");

        // expect
        assertEquals("0 10 20 30 40 50", result.getMinute());
        assertEquals("3 7", result.getHour());
        assertEquals("1 2 3", result.getDayOfMonth());
        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12", result.getMonth());
        assertEquals("1 2 3 4 5 6 7", result.getDayOfWeek());
        assertEquals("command", result.getCommand());

    }
}
