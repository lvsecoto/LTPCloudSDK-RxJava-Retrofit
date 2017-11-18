package com.yjy.nlp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class WordSegmentationTest {

    private WordSegmentation mWordSegmentation;

    @Before
    public void setUp() throws Exception {
        mWordSegmentation = new WordSegmentation(APIKey.API_KEY);
    }

    @Test
    public void segment() throws Exception {
        mWordSegmentation.segment("今晚打老虎").test()
                .await()
                .assertValue(Arrays.asList("今晚", "打", "老虎"));
    }
}