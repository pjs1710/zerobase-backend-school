package dev.timer.javachange.java8.interfacedefaultmethod;

import java.time.ZonedDateTime;

import static java.time.ZoneId.of;

public class J8Class2 implements J8Interface {

    @Override
    public String getTime() {
        return ZonedDateTime.now(of("UTC")).toString();
    }
}
