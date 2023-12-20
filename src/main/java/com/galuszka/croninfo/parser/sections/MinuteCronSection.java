package com.galuszka.croninfo.parser.sections;

import com.galuszka.croninfo.parser.range.DefaultSupportedRanges;

import static com.galuszka.croninfo.parser.range.RangeType.MINUTE_RANGE;

public class MinuteCronSection implements CronSection {
    private static final DefaultSupportedRanges defaultSupportedRanges = new DefaultSupportedRanges(MINUTE_RANGE);

    @Override
    public String resolve(String cronValue) {
        return defaultSupportedRanges.resolve(cronValue);
    }
}
