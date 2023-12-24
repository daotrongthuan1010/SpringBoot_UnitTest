package com.example.springtest.testjunit;

import com.example.springtest.utiils.StudyJunit;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TestLifeCycleJunit {

    StudyJunit studyJunit;

    @BeforeEach
    void setupBeforeEach(){
        studyJunit = new StudyJunit();
        System.out.println("@BeforeEach execute test...");
    }

    @BeforeAll
    static void setupSource(){
        System.out.println("Test setupSource");
    }

    @AfterEach
    void tearDownAfterEach(){
        System.out.println("Clear source after test");
       studyJunit = null;
    }

    @Test
    void checkAddSuccess(){
        assertEquals(8, studyJunit.add(4,2), "Result mapping is Ok");
        assertNotEquals(6,studyJunit.add(4,4), "Result not mapping is OK");
    }


    @DisplayName("checkAddSuccess execute unit test")
    @Test
    void checkAddSuccess1(){
        assertEquals(8, studyJunit.add(4,2), "Result mapping is Ok");
        assertNotEquals(6,studyJunit.add(4,4), "Result not mapping is OK");
    }

    @Disabled
    @DisplayName("checkAddSuccess execute unit test")
    @Test
    void checkAddSuccess2(){
        System.out.println("Case disable not test");
        assertEquals(8, studyJunit.add(4,2), "Result mapping is Ok");
        assertNotEquals(6,studyJunit.add(4,4), "Result not mapping is OK");
    }

    @Test
    void checkDevision(){
        assertThrows(ArithmeticException.class, () ->studyJunit.devision(4, 0));
    }

    @Test
    void checkTimeOut(){
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> studyJunit.checkTimeOut());
    }

}
