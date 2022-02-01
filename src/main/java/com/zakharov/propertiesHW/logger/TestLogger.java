package com.zakharov.propertiesHW.logger;

public class TestLogger implements Logger{
    @Override
    public void logMessage(String message) {
        System.out.println("TEST: " + message);
    }
}
