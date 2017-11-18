package com.yjy.nlp.ltp;

import com.yjy.nlp.ltp.result.*;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LTPService {

    @GET("analysis/?&format=json&pattern=ws")
    Observable<WSResult[][][]> getWordSegmentation(
            @Query("api_key") String apiKey,
            @Query("text") String text);

    @GET("analysis/?&format=json&pattern=pos")
    Observable<POSResult[][][]> getPartOfSpeech(
            @Query("api_key") String apiKey,
            @Query("text") String text);

    @GET("analysis/?&format=json&pattern=ner")
    Observable<NERResult[][][]> getNamedEntityRecognition(
            @Query("api_key") String apiKey,
            @Query("text") String text);

    @GET("analysis/?&format=json&pattern=dp")
    Observable<DPResult[][][]> getDependencyParsing(
            @Query("api_key") String apiKey,
            @Query("text") String text);

    @GET("analysis/?&format=json&pattern=sdp")
    Observable<SDPResult[][][]> getSemanticDependencyParsing(
            @Query("api_key") String apiKey,
            @Query("text") String text);
}
