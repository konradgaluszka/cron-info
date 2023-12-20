package com.galuszka.croninfo;

import com.galuszka.croninfo.parser.ParsedCron;

class CronInfoFormatter {
    public String format(ParsedCron parsed) {
        return "%-14s%s\n".formatted("minute", parsed.getMinute()) +
                "%-14s%s\n".formatted("hour", parsed.getHour()) +
                "%-14s%s\n".formatted("day of month", parsed.getDayOfMonth()) +
                "%-14s%s\n".formatted("month", parsed.getMonth()) +
                "%-14s%s\n".formatted("day of week", parsed.getDayOfWeek()) +
                "%-14s%s".formatted("command", parsed.getCommand());
    }
}
