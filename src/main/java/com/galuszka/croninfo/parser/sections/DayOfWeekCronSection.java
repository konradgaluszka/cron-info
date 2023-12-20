package com.galuszka.croninfo.parser.sections;

import com.galuszka.croninfo.parser.range.DefaultSupportedRanges;

import static com.galuszka.croninfo.parser.range.RangeType.DAY_OF_WEEK_RANGE;

public class DayOfWeekCronSection implements CronSection {
    private static final DefaultSupportedRanges defaultSupportedRanges = new DefaultSupportedRanges(DAY_OF_WEEK_RANGE);

    @Override
    public String resolve(String cronValue) {
        return defaultSupportedRanges.resolve(cronValue);
    }
}
