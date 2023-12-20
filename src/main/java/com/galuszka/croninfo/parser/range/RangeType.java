package com.galuszka.croninfo.parser.range;

public enum RangeType {
    MINUTE_RANGE(0, 59),
    HOUR_RANGE(0, 23),
    DAY_OF_MONTH_RANGE(1, 31),
    MONTH_RANGE(1, 12),
    DAY_OF_WEEK_RANGE(1, 7);

    int from;
    int to;

    RangeType(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
