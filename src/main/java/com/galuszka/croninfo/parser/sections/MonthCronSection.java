package com.galuszka.croninfo.parser.sections;

import com.galuszka.croninfo.parser.range.DefaultSupportedRanges;

import static com.galuszka.croninfo.parser.range.RangeType.MONTH_RANGE;

public class MonthCronSection implements CronSection {
    private static final DefaultSupportedRanges defaultSupportedRanges = new DefaultSupportedRanges(MONTH_RANGE);

    @Override
    public String resolve(String cronValue) {
        return defaultSupportedRanges.resolve(cronValue);
    }
}
