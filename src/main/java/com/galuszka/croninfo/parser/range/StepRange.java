package com.galuszka.croninfo.parser.range;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StepRange implements Range {
    private static final Pattern pattern = Pattern.compile("\\*/(\\d+)");
    private final RangeType rangeType;

    public StepRange(RangeType rangeType) {
        this.rangeType = rangeType;
    }

    @Override
    public String resolve(String value) {
        var stepRange = value.split("/");
        var step = Integer.parseInt(stepRange[1]);
        validate(step);
        return IntStream.range(rangeType.getFrom(), rangeType.getTo() + 1)
                .filter(i -> i % step == 0)
                .mapToObj(t -> "" + t)
                .collect(Collectors.joining(" "));
    }

    private void validate(int step) {
        if (step <= 0 && step > rangeType.getTo()) {
            throw new IllegalArgumentException("invalid range");
        }
    }

    @Override
    public boolean applies(String value) {
        return pattern.matcher(value).matches();
    }
}
