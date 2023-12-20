package com.galuszka.croninfo.parser.range;

import com.galuszka.croninfo.parser.range.RangeType;
import com.galuszka.croninfo.parser.range.WildcardRange;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.galuszka.croninfo.parser.range.RangeType.DAY_OF_WEEK_RANGE;
import static com.galuszka.croninfo.parser.range.RangeType.MONTH_RANGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildcardRangeTest {

    @ParameterizedTest
    @MethodSource(value = "ranges")
    void correctlyResolves(RangeType rangeType, String cron, String expectedValue) {
        // given
        var selectionRange = new WildcardRange(rangeType);

        // expect
        assertEquals(expectedValue, selectionRange.resolve(cron));

    }

    static Stream<Arguments> ranges() {
        return Stream.of(
                Arguments.of(DAY_OF_WEEK_RANGE, "*", "1 2 3 4 5 6 7"),
                Arguments.of(MONTH_RANGE, "*", "1 2 3 4 5 6 7 8 9 10 11 12")
        );
    }
}
