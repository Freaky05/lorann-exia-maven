package model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExampleTest {
    private Example example;

    @BeforeClass
    public static void setUpBeforeClass() {
    }

    @AfterClass
    public static void tearDownAfterClass() {
    }

    @Before
    public void setUp() {
        this.example = new Example(1, "Example test");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetId() {
        final int expected = 1;
        assertEquals(expected, this.example.getId());
    }

    @Test
    public void testGetName() {
        final String expected = "Example test";
        assertEquals(expected, this.example.getName());
    }

    @Test
    public void testSetName() {
        String expected = "Example test";
        assertEquals(expected, this.example.getName());
        expected = "Example test modified";
        this.example.setName(expected);
        assertEquals(expected, this.example.getName());
    }

    @Test
    public void testToString() {
        final String expected = "1 : Example test";
        assertEquals(expected, this.example.toString());
    }

}
