/*
 * (C) Copyright 2014 Dean Chugall
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.dean.chugall.features;

/**
 * Definition of the FeaturesExtractor interface
 * 
 * @author Dean Chugall
 * @param <T> the kind of features to extract
 */
public interface FeaturesExtractor<T> {

    /**
     * Extracts vocal features from given vocal sample
     * @param vocalSample the vocal sample to analyze
     * @return An objet of type T representing the features
     */
    public T extractFeatures(double[] vocalSample);

}