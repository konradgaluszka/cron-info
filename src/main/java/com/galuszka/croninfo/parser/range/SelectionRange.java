package com.galuszka.croninfo.parser.range;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SelectionRange implements Range {
    private static final Pattern pattern = Pattern.compile("(\\d+)+(,\\d+)*");
    private final RangeType rangeType;

    public SelectionRange(RangeType rangeType) {
        this.rangeType = rangeType;
    }

    @Override
    public String resolve(String value) {
        String[] numbers = value.split(",");
        validate(numbers, this.rangeType);
        return String.join(" ", numbers);
    }

    private void validate(String[] numbers, RangeType rangeType) {
        if (Arrays.stream(numbers).anyMatch(n -> Integer.parseInt(n) < rangeType.getFrom()
                || Integer.parseInt(n) > rangeType.getTo())) {
            throw new IllegalArgumentException("invalid selection");
        }
    }

    @Override
    public boolean applies(String value) {
        return pattern.matcher(value).matches();
    }
}
