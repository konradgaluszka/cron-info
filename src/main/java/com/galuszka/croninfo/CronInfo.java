package com.galuszka.croninfo;

import com.galuszka.croninfo.parser.CronParser;

class CronInfo {

    private final CronParser cronParser = new CronParser();
    private final CronInfoFormatter cronInfoFormatter = new CronInfoFormatter();
    private final String cronJob;

    public CronInfo(String cronJob) {
        this.cronJob = cronJob;
    }

    public String get() {
        var parsed = cronParser.parse(cronJob);
        return cronInfoFormatter.format(parsed);
    }
}
