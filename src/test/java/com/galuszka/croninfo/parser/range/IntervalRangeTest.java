package com.galuszka.croninfo.parser.range;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.galuszka.croninfo.parser.range.RangeType.DAY_OF_MONTH_RANGE;
import static com.galuszka.croninfo.parser.range.RangeType.HOUR_RANGE;
import static com.galuszka.croninfo.parser.range.RangeType.MINUTE_RANGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntervalRangeTest {

    @ParameterizedTest
    @MethodSource(value = "ranges")
    void correctlyResolves(RangeType rangeType, String cron, String expectedValue) {
        // given
        var selectionRange = new IntervalRange(rangeType);

        // expect
        assertEquals(expectedValue, selectionRange.resolve(cron));

    }

    static Stream<Arguments> ranges() {
        return Stream.of(
                Arguments.of(MINUTE_RANGE, "0-5", "0 1 2 3 4 5"),
                Arguments.of(MINUTE_RANGE, "57-59", "57 58 59"),
                Arguments.of(HOUR_RANGE, "0-2", "0 1 2"),
                Arguments.of(HOUR_RANGE, "20-23", "20 21 22 23"),
                Arguments.of(DAY_OF_MONTH_RANGE, "1-6", "1 2 3 4 5 6")
        );
    }
}
