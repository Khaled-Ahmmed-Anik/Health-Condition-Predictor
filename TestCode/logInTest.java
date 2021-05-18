package com.khlaedahmmedanik.healthconditionpredictor;

import junit.framework.TestCase;

public class logInTest extends TestCase {

    public void testValidateName() {
        boolean output= logIn.validateName("anik98");
        assertEquals(true,output);
    }

    public void testValidatepass() {
        boolean output= logIn.validatepass("ioiq1234");
        assertEquals(true,output);
    }

    public void testIsMatched() {
        boolean output= logIn.isMatched("anik","ioiq1234");
        assertEquals(true,output);
    }
}