package com.galuszka.croninfo.parser.range;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WildcardRange implements Range {
    private final RangeType rangeType;

    public WildcardRange(RangeType rangeType) {
        this.rangeType = rangeType;
    }

    @Override
    public String resolve(String value) {
        validate(value);
        return IntStream.range(rangeType.getFrom(), rangeType.getTo() + 1)
                .mapToObj(t -> "" + t)
                .collect(Collectors.joining(" "));
    }

    private void validate(String value) {
        if (!value.equals("*")) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean applies(String value) {
        return "*".equals(value);
    }
}
