package com.pgg.account.config;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class TestUtils {
    public static final EasyRandom EASY_RANDOM =
            new EasyRandom(new EasyRandomParameters().stringLengthRange(1, 5).collectionSizeRange(1, 5));

    private TestUtils() {}
}
