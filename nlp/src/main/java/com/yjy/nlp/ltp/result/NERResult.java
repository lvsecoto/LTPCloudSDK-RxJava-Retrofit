package com.yjy.nlp.ltp.result;

import com.google.gson.annotations.SerializedName;

public class NERResult extends BaseResult {

    @SerializedName("ne")
    private String mNamedEntity = null;

    public NERResult(int id, String content, String namedEntity) {
        super(id, content);
        mNamedEntity = namedEntity;
    }

    public String getNamedEntity() {
        return mNamedEntity;
    }

    public void setNamedEntity(String namedEntity) {
        mNamedEntity = namedEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NERResult)) return false;
        if (!super.equals(o)) return false;

        NERResult that = (NERResult) o;

        return getNamedEntity() != null ? getNamedEntity().equals(that.getNamedEntity()) : that.getNamedEntity() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getNamedEntity() != null ? getNamedEntity().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NERResult{" +
                "mId=" + mId +
                ", mContent='" + mContent + '\'' +
                ", mNamedEntity='" + mNamedEntity + '\'' +
                '}';
    }
}
