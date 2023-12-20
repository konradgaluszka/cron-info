package com.galuszka.croninfo.parser.sections;

import com.galuszka.croninfo.parser.range.DefaultSupportedRanges;

import static com.galuszka.croninfo.parser.range.RangeType.HOUR_RANGE;

public class HourCronSection implements CronSection {
    private static final DefaultSupportedRanges defaultSupportedRanges = new DefaultSupportedRanges(HOUR_RANGE);

    @Override
    public String resolve(String cronValue) {
        return defaultSupportedRanges.resolve(cronValue);
    }
}
