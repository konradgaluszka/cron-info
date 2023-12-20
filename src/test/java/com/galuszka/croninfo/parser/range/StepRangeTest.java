package com.galuszka.croninfo.parser.range;

import com.galuszka.croninfo.parser.range.RangeType;
import com.galuszka.croninfo.parser.range.StepRange;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.galuszka.croninfo.parser.range.RangeType.DAY_OF_WEEK_RANGE;
import static com.galuszka.croninfo.parser.range.RangeType.HOUR_RANGE;
import static com.galuszka.croninfo.parser.range.RangeType.MINUTE_RANGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepRangeTest {

    @ParameterizedTest
    @MethodSource(value = "ranges")
    void correctlyResolves(RangeType rangeType, String cron, String expectedValue) {
        // given
        var selectionRange = new StepRange(rangeType);

        // expect
        assertEquals(expectedValue, selectionRange.resolve(cron));

    }

    static Stream<Arguments> ranges() {
        return Stream.of(
                Arguments.of(MINUTE_RANGE, "*/15", "0 15 30 45"),
                Arguments.of(MINUTE_RANGE, "*/30", "0 30"),
                Arguments.of(HOUR_RANGE, "*/12", "0 12"),
                Arguments.of(DAY_OF_WEEK_RANGE, "*/1", "1 2 3 4 5 6 7")
        );
    }
}
