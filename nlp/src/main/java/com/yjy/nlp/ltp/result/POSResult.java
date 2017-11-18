package com.yjy.nlp.ltp.result;

import com.google.gson.annotations.SerializedName;

public class POSResult extends BaseResult {

    @SerializedName("pos")
    private String mPartOfSpeech = null;

    public POSResult(int id, String content, String partOfSpeech) {
        super(id, content);
        mPartOfSpeech = partOfSpeech;
    }

    public String getPartOfSpeech() {
        return mPartOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        mPartOfSpeech = partOfSpeech;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof POSResult)) return false;

        POSResult that = (POSResult) o;

        return mPartOfSpeech != null ? mPartOfSpeech.equals(that.mPartOfSpeech) : that.mPartOfSpeech == null;
    }

    @Override
    public int hashCode() {
        return mPartOfSpeech != null ? mPartOfSpeech.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "POSResult{" +
                "mId=" + mId +
                ", mContent='" + mContent + '\'' +
                ", mPartOfSpeech='" + mPartOfSpeech + '\'' +
                '}';
    }
}
