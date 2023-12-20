package com.galuszka.croninfo.parser.sections;

import com.galuszka.croninfo.parser.range.DefaultSupportedRanges;

import static com.galuszka.croninfo.parser.range.RangeType.DAY_OF_MONTH_RANGE;

public class DayOfMonthCronSection implements CronSection {
    private static final DefaultSupportedRanges defaultSupportedRanges = new DefaultSupportedRanges(DAY_OF_MONTH_RANGE);

    @Override
    public String resolve(String cronValue) {
        return defaultSupportedRanges.resolve(cronValue);
    }
}
