package com.example.springtest.testjunit;

import com.example.springtest.utiils.StudyJunit;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TestJunit {

    StudyJunit studyJunit = new StudyJunit();

    String  testNull = null;

    @Test
    void checkAddSuccess(){

        assertEquals(8, studyJunit.add(4,2), "Result mapping is Ok");
        assertNotEquals(6,studyJunit.add(4,4), "Result not mapping is OK");

    }

    @Test
    void checkJunitNull(){
        assertNull(testNull, "Result is null");
    }

}
