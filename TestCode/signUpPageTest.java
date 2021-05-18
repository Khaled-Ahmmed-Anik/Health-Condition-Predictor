package com.khlaedahmmedanik.healthconditionpredictor;

import junit.framework.TestCase;

public class signUpPageTest extends TestCase {

    public void testIsNameValid() {
        boolean output= signUpPage.isNameValid("anik98");
        assertEquals(true,output);
    }

    public void testIsMailValid() {
        boolean output= signUpPage.isMailValid("khaledahmmedanik@gmail.com");
        assertEquals(true,output);
    }

    public void testIsPassValid() {
        boolean output= signUpPage.isPassValid("ioiq1234");
        assertEquals(true,output);
    }

    public void testIsPassMatched() {
        boolean output= signUpPage.isPassMatched("ioiq1234","ioiq1234");
        assertEquals(true,output);
    }

    public void testIsRoleValid() {
        boolean output= signUpPage.isRoleValid("user");
        assertEquals(true,output);
    }
}