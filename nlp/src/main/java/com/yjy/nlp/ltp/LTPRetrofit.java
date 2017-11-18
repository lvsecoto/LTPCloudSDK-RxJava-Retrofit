package com.yjy.nlp.ltp;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class LTPRetrofit {

    private static Retrofit mRetrofit = null;

    private LTPRetrofit() {
    }

    public static Retrofit getRetrofit() {

        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("https://api.ltp-cloud.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        return mRetrofit;
    }
}
