package com.yjy.nlp.ltp.result;

import com.google.gson.annotations.SerializedName;

public class BaseResult {

    @SerializedName("id")
    protected int mId = -1;

    @SerializedName("cont")
    protected String mContent = null;

    BaseResult(int id, String content) {
        this.mId = id;
        mContent = content;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseResult)) return false;

        BaseResult baseResult = (BaseResult) o;

        if (getId() != baseResult.getId()) return false;
        return getContent() != null ? getContent().equals(baseResult.getContent()) : baseResult.getContent() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "mId=" + mId +
                ", mContent='" + mContent + '\'' +
                '}';
    }
}
