package com.galuszka.croninfo.parser;

import com.galuszka.croninfo.parser.sections.DayOfMonthCronSection;
import com.galuszka.croninfo.parser.sections.DayOfWeekCronSection;
import com.galuszka.croninfo.parser.sections.HourCronSection;
import com.galuszka.croninfo.parser.sections.MinuteCronSection;
import com.galuszka.croninfo.parser.sections.MonthCronSection;

public class CronParser {
    public ParsedCron parse(String cronJob) {
        var segments = cronJob.split(" ");
        if (segments.length != 6) {
            throw new IllegalArgumentException("Incorrect cron");
        }

        var minuteCron = new MinuteCronSection();
        var hourCron = new HourCronSection();
        var dayOfMonthCron = new DayOfMonthCronSection();
        var monthCron = new MonthCronSection();
        var dayOfWeekCron = new DayOfWeekCronSection();
        return ParsedCron.builder()
                .minute(minuteCron.resolve(segments[0]))
                .hour(hourCron.resolve(segments[1]))
                .dayOfMonth(dayOfMonthCron.resolve(segments[2]))
                .month(monthCron.resolve(segments[3]))
                .dayOfWeek(dayOfWeekCron.resolve(segments[4]))
                .command(segments[5])
                .build();
    }
}
