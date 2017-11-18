package com.yjy.nlp;

import com.yjy.nlp.ltp.LTP;
import com.yjy.nlp.ltp.result.WSResult;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class WordSegmentation {

    private String mApiKey;

    public WordSegmentation(String apiKey) {
        mApiKey = apiKey;
    }

    public Observable<List<String>> segment(String text) {
        return LTP.getService().getWordSegmentation(mApiKey, text)
                .map(new Function<WSResult[][][], List<String>>() {
                    @Override
                    public List<String> apply(WSResult[][][] wsResults) throws Exception {
                        List<String> result = new ArrayList<>();
                        for (WSResult[][] paragraph : wsResults) {
                            for (WSResult[] sentence : paragraph) {
                                for (WSResult word : sentence) {
                                    result.add(word.getContent());
                                }
                            }
                        }
                        return result;
                    }
                });
    }
}
