package com.yjy.nlp.ltp.result;

import com.google.gson.annotations.SerializedName;

public class SDPResult extends BaseResult {

    @SerializedName("pos")
    private String mPartOfSpeech = null;

    @SerializedName("semparent")
    private int mSemParent = -2;

    @SerializedName("semrelate")
    private String mSemRelate = null;

    public SDPResult(int id, String content, String partOfSpeech, int semParent, String semRelate) {
        super(id, content);
        mPartOfSpeech = partOfSpeech;
        mSemParent = semParent;
        mSemRelate = semRelate;
    }

    public String getPartOfSpeech() {
        return mPartOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        mPartOfSpeech = partOfSpeech;
    }

    public int getSemParent() {
        return mSemParent;
    }

    public void setSemParent(int semParent) {
        mSemParent = semParent;
    }

    public String getSemRelate() {
        return mSemRelate;
    }

    public void setSemRelate(String semRelate) {
        mSemRelate = semRelate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SDPResult)) return false;
        if (!super.equals(o)) return false;

        SDPResult that = (SDPResult) o;

        if (getSemParent() != that.getSemParent()) return false;
        if (getPartOfSpeech() != null ? !getPartOfSpeech().equals(that.getPartOfSpeech()) : that.getPartOfSpeech() != null)
            return false;
        return getSemRelate() != null ? getSemRelate().equals(that.getSemRelate()) : that.getSemRelate() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getPartOfSpeech() != null ? getPartOfSpeech().hashCode() : 0);
        result = 31 * result + getSemParent();
        result = 31 * result + (getSemRelate() != null ? getSemRelate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SDPResult{" +
                "mId=" + mId +
                ", mContent='" + mContent + '\'' +
                ", mPartOfSpeech='" + mPartOfSpeech + '\'' +
                ", mSemParent=" + mSemParent +
                ", mSemRelate='" + mSemRelate + '\'' +
                '}';
    }
}
