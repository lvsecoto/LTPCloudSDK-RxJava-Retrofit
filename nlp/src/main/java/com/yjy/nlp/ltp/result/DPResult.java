package com.yjy.nlp.ltp.result;

import com.google.gson.annotations.SerializedName;

public class DPResult extends BaseResult {

    @SerializedName("pos")
    private String mPartOfSpeech = null;

    @SerializedName("parent")
    private int mParentId = -2;

    @SerializedName("relate")
    private String mRelate = null;

    public DPResult(int id, String content, String partOfSpeech, int parentId, String relate) {
        super(id, content);
        mPartOfSpeech = partOfSpeech;
        mParentId = parentId;
        mRelate = relate;
    }

    public String getPartOfSpeech() {
        return mPartOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        mPartOfSpeech = partOfSpeech;
    }

    public int getParentId() {
        return mParentId;
    }

    public void setParentId(int parentId) {
        mParentId = parentId;
    }

    public String getRelate() {
        return mRelate;
    }

    public void setRelate(String relate) {
        mRelate = relate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DPResult)) return false;
        if (!super.equals(o)) return false;

        DPResult that = (DPResult) o;

        if (getParentId() != that.getParentId()) return false;
        if (getPartOfSpeech() != null ? !getPartOfSpeech().equals(that.getPartOfSpeech()) : that.getPartOfSpeech() != null)
            return false;
        return getRelate() != null ? getRelate().equals(that.getRelate()) : that.getRelate() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getPartOfSpeech() != null ? getPartOfSpeech().hashCode() : 0);
        result = 31 * result + getParentId();
        result = 31 * result + (getRelate() != null ? getRelate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DP{" +
                "mId=" + mId +
                ", mContent='" + mContent + '\'' +
                ", mPartOfSpeech='" + mPartOfSpeech + '\'' +
                ", mParentId=" + mParentId +
                ", mRelate='" + mRelate + '\'' +
                '}';
    }
}
