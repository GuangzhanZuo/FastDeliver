package com.qingyang.fastdeliver.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

    private static final AtomicInteger atomicInt = new AtomicInteger(0);

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHH");

    public static String generateOrderNumber() {
        int sequenceNum = atomicInt.getAndIncrement();
        String currentTime = sdf.format(new Date());
        return currentTime + String.format("%02d", sequenceNum);
    }
}
