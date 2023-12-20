package com.galuszka.croninfo.parser.range;

import java.util.List;

public class DefaultSupportedRanges {
    private final List<Range> defaultSupportedRanges;

    public DefaultSupportedRanges(RangeType rangeType) {
        defaultSupportedRanges = List.of(
                new IntervalRange(rangeType),
                new SelectionRange(rangeType),
                new StepRange(rangeType),
                new WildcardRange(rangeType));
    }

    public String resolve(String cronValue) {
        return defaultSupportedRanges.stream()
                .filter(r -> r.applies(cronValue))
                .findFirst().orElseThrow(IllegalArgumentException::new)
                .resolve(cronValue);
    }
}
