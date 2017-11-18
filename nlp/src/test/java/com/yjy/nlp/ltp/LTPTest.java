package com.yjy.nlp.ltp;

import com.yjy.nlp.APIKey;
import com.yjy.nlp.ltp.result.*;
import io.reactivex.functions.Predicate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnit4.class)
public class LTPTest {

    private LTPService mService;

    @Before
    public void setUp() throws Exception {
        mService = LTP.getService();
    }

    @Test
    public void getWordSegmentation() throws Exception {
        mService.getWordSegmentation(APIKey.API_KEY, "今晚打老虎").test()
                .await()
                .assertNoErrors()
                .assertValue(new Predicate<WSResult[][][]>() {
                    @Override
                    public boolean test(WSResult[][][] WSResult) throws Exception {
                        assertArrayEquals(new WSResult[][][]{{{
                                new WSResult(0, "今晚"),
                                new WSResult(1, "打"),
                                new WSResult(2, "老虎"),
                        }}}, WSResult);
                        return true;
                    }
                });
    }

    @Test
    public void getPartOfSpeech() throws Exception {
        mService.getPartOfSpeech(APIKey.API_KEY, "今晚打老虎").test().await()
                .assertNoErrors()
                .assertValue(new Predicate<POSResult[][][]>() {
                    @Override
                    public boolean test(POSResult[][][] POSResults) throws Exception {
                        assertArrayEquals(
                                new POSResult[][][]{{{
                                        new POSResult(0, "今晚", "nt"),
                                        new POSResult(1, "打", "v"),
                                        new POSResult(2, "老虎", "n"),
                                }}}
                                , POSResults);
                        return true;
                    }
                });
    }

    @Test
    public void getNamedEntityRecognition() throws Exception {
        mService.getNamedEntityRecognition(APIKey.API_KEY, "武松打老虎").test()
                .await()
                .assertNoErrors()
                .assertValue(
                        new Predicate<NERResult[][][]>() {
                            @Override
                            public boolean test(NERResult[][][] NERResults) throws Exception {
                                assertArrayEquals(
                                        new NERResult[][][]{{{
                                                new NERResult(0, "武松", "S-Nh"),
                                                new NERResult(1, "打", "O"),
                                                new NERResult(2, "老虎", "O"),
                                        }}}
                                        , NERResults);
                                return true;
                            }
                        }
                );
    }

    @Test
    public void getDependencyParsing() throws Exception {
        mService.getDependencyParsing(APIKey.API_KEY, "今晚打老虎").test()
                .await()
                .assertNoErrors()
                .assertValue(new Predicate<DPResult[][][]>() {
                    @Override
                    public boolean test(DPResult[][][] DPResults) throws Exception {
                        assertArrayEquals(new DPResult[][][]{{{
                                new DPResult(0, "今晚", "nt", 1, "ADV"),
                                new DPResult(1, "打", "v", -1, "HED"),
                                new DPResult(2, "老虎", "n", 1, "VOB"),
                        }}}, DPResults);

                        return true;
                    }
                });
    }

    @Test
    public void getSemanticDependencyParsing() throws Exception {
        mService.getSemanticDependencyParsing(APIKey.API_KEY, "今晚打老虎").test()
                .await()
                .assertNoErrors()
                .assertValue(new Predicate<SDPResult[][][]>() {
                    @Override
                    public boolean test(SDPResult[][][] SDPResults) throws Exception {
                        assertArrayEquals(new SDPResult[][][]{{{
                                new SDPResult(0, "今晚", "nt", 1, "Time"),
                                new SDPResult(1, "打", "v", -1, "Root"),
                                new SDPResult(2, "老虎", "n", 1, "Pat"),
                        }}}, SDPResults);
                        return true;
                    }
                });
    }
}