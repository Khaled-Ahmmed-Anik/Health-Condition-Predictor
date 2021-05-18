package com.khlaedahmmedanik.healthconditionpredictor;

import junit.framework.TestCase;

public class userFirstInterfaceTest extends TestCase {

    public void testMatchedDiscease() {
        String output= userFirstInterface.matchedDiscease("sleeplessness, pale face, diarrhoea, deformed skull");
        assertEquals("Rickets",output);
    }

    public void testGetUserName() {
        String output= userFirstInterface.getUserName(1);
        assertEquals("anik98",output);
    }

    public void testGetUserMail() {
        String output= userFirstInterface.getUserMail(1);
        assertEquals("khaledahmmedanik@gmail.com",output);
    }

    public void testGetPreviousRecords() {
        String output= userFirstInterface.getPreviousRecords(1);
        assertEquals("no records found",output);
    }
}