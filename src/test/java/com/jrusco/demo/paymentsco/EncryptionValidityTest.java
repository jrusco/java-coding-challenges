package com.jrusco.demo.paymentsco;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Test;

public class EncryptionValidityTest {
    
    @Test
    public void test1(){
        assertTrue(Arrays.equals(new int[]{0,200000}, encryptionValidity(100, 1000, new int[]{2,4})));
    }

    public int[] encryptionValidity(int instructionCount, int validityPeriod, int[] keys){
        //find the key with the maximum number of divisors
        int key = keys[0];
        int maxDegreeOfDiv = 1;
        if (keys.length > 1){
            for (int k : keys) {
                int degreeOfDiv = 0;
                for (int k2 : keys) {
                    if (k%k2 == 0){
                        degreeOfDiv++;
                    }
                }
                if (degreeOfDiv > maxDegreeOfDiv){
                    maxDegreeOfDiv = degreeOfDiv;
                    key = k;
                }
            }
        }
        int strenghtOfEncryption = Double.valueOf(maxDegreeOfDiv * Math.pow(10, 5)).intValue();
        int hijackerProcessingPower = instructionCount * validityPeriod;
        int canBeForced = strenghtOfEncryption > hijackerProcessingPower? 0 : 1;
        return new int[]{canBeForced, strenghtOfEncryption};
    }
}
