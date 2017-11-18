package com.yjy.nlp.ltp.result;

public class WSResult extends BaseResult {

    public WSResult(int id, String content) {
        super(id, content);
    }

    @Override
    public String toString() {
        return "WSResult{" +
                "mId=" + mId +
                ", mContent='" + mContent + '\'' +
                '}';
    }
}
