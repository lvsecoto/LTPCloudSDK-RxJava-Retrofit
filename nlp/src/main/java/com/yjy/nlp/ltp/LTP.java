package com.yjy.nlp.ltp;

public class LTP {

    private static LTPService mService;

    private LTP() {
    }

    public static LTPService getService() {

        if (mService == null) {
            mService = LTPRetrofit.getRetrofit().create(LTPService.class);
        }

        return mService;
    }

}
