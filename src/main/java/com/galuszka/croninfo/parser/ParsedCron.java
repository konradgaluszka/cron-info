package com.galuszka.croninfo.parser;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ParsedCron {
    String minute;
    String hour;
    String dayOfMonth;
    String month;
    String dayOfWeek;
    String command;
}
