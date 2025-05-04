package dev.timer.javachange.java8.interfacedefaultmethod;

public interface J8Interface {
    default void printTime() {
        System.out.println(getTime());
    }

    String getTime();

}
