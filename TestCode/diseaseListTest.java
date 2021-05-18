package com.khlaedahmmedanik.healthconditionpredictor;

import junit.framework.TestCase;

public class diseaseListTest extends TestCase {

    public void testDisceaseSyntomps() {
        String output= diseaseList.disceaseSyntomps("Goitre");
        assertEquals("painful joints",output);
    }
}