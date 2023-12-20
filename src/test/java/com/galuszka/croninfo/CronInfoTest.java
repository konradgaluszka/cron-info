package com.galuszka.croninfo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CronInfoTest {

    @Test
    void printsStandardCronCommand() {
        // given
        CronInfo cronInfo = new CronInfo("*/15 0 1,15 * 1-5 /usr/bin/find");

        // when
        String result = cronInfo.get();

        // then
        assertEquals("""
                minute        0 15 30 45
                hour          0
                day of month  1 15
                month         1 2 3 4 5 6 7 8 9 10 11 12
                day of week   1 2 3 4 5
                command       /usr/bin/find""", result);
    }
}
