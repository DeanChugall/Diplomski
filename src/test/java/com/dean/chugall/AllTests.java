package com.dean.chugall;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.dean.chugall.algorithms.DiscreteAutocorrelationAtLagJTest;
import com.dean.chugall.algorithms.LinearPredictiveCodingTest;
import com.dean.chugall.algorithms.windowing.HammingWindowFunctionTest;
import com.dean.chugall.algorithms.windowing.HannWindowFunctionTest;
import com.dean.chugall.distances.ChebyshevDistanceCalculatorTest;
import com.dean.chugall.distances.EuclideanDistanceCalculatorTest;
import com.dean.chugall.enhancements.NormalizerTest;
import com.dean.chugall.features.LpcFeaturesExtractorTest;
import com.dean.chugall.vad.AutocorrellatedVoiceActivityDetectorTest;

@RunWith(Suite.class)
@SuiteClasses({ 
    HammingWindowFunctionTest.class,
    HannWindowFunctionTest.class,
    DiscreteAutocorrelationAtLagJTest.class,
    LinearPredictiveCodingTest.class,
    ChebyshevDistanceCalculatorTest.class,
    EuclideanDistanceCalculatorTest.class,
    NormalizerTest.class,
    LpcFeaturesExtractorTest.class,
    AutocorrellatedVoiceActivityDetectorTest.class,
    RecognitoTest.class, 
    VocalPrintConcurrencyTest.class, 
    VocalPrintTest.class
})

public class AllTests {}
