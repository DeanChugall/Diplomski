/*
 * (C) Copyright 2014 Amaury Crickx
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
package com.dean.chugall;

import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.dean.chugall.distances.DistanceCalculator;

/**
 * Represents a vocal print in the system
 * 
 * @author Dean Chugall
 */
public class VocalPrint
        implements Serializable {

    private static final long serialVersionUID = 5656438598778733593L;
    
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();
    
    private double[] features;
    private int meanCount;

    
    /**
     * Package visible constructor for Hibernate and the likes
     */
    VocalPrint() {}

    /**
     * Contructor for a vocal print
     * @param features the features
     */
    VocalPrint(double[] features) {
        super();
        this.features = features;
        this.meanCount = 1;
    }

    /**
     * Returns the distance between this vocal print and the given one using the calculator.
     * Threading : it is safe to call this method while other threads may merge this vocal print instance
     * with another one in the sense that the distance calculation will not happen on half merged vocal print.
     * Since this method is read only, it is safe to call it from multiple threads for a single instance
     * @param calculator the distance calculator
     * @param vocalPrint the vocal print
     * @return the distance
     */
    double getDistance(DistanceCalculator calculator, VocalPrint vocalPrint) {
        r.lock();
        try { 
            return calculator.getDistance(this.features, vocalPrint.features);
        } 
        finally { r.unlock(); }
    }

    /**
     * Merges this vocal print features with the given one.
     * Threading : it is safe to call this method while other threads may request the distance of this vocal 
     * regarding another one in the sense that the distance calculation will not happen on half merged vocal print
     * @param features the features to merge
     */
    void merge(double[] features) {
        if(this.features.length != features.length) {
            throw new IllegalArgumentException("Features of new VocalPrint is of different size : [" + 
                    features.length + "] expected [" + this.features.length + "]");
        }
        w.lock();
        try { 
            merge(this.features, features);
            meanCount++;
        } 
        finally { w.unlock(); }
    }

    /**
     * Recomputes the mean values for the inner features when adding the outer features
     * @param inner the inner features
     * @param outer the outer features
     */
    private void merge(double[] inner, double[] outer) {
        for (int i = 0; i < inner.length; i++) {
            inner[i] = (inner[i] * meanCount + outer[i]) / (meanCount + 1);
        }
    }
}
