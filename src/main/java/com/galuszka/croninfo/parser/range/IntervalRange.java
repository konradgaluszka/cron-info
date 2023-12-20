package com.galuszka.croninfo.parser.range;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntervalRange implements Range {
    private static final Pattern pattern = Pattern.compile("(\\d+)-(\\d+)");
    private final RangeType rangeType;

    public IntervalRange(RangeType rangeType) {
        this.rangeType = rangeType;
    }

    @Override
    public String resolve(String value) {
        var fromTo = value.split("-");
        var from = Integer.parseInt(fromTo[0]);
        var to = Integer.parseInt(fromTo[1]);
        validate(from, to, this.rangeType);
        return IntStream.range(from, to + 1).mapToObj(t -> "" + t).collect(Collectors.joining(" "));
    }

    private void validate(int from, int to, RangeType rangeType) {
        if (from < rangeType.getFrom() || to > rangeType.getTo()) {
            throw new IllegalArgumentException("invalid range");
        }
    }

    @Override
    public boolean applies(String value) {
        return pattern.matcher(value).matches();
    }
}
