package com.galuszka.croninfo.parser.range;

public interface Range {
    String resolve(String value);
    boolean applies(String value);
}
