import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String toChange = hamletParser.changeHamlet("Leon");

        Integer expected = 0;

        assertEquals(expected, hamletParser.countHamlet(hamletParser.changeHamlet("Leon")));

        assertTrue(toChange.contains("Leon"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        Integer expected = 0;
        String toChange = hamletParser.changeHoratio("Tariq");
        assertEquals(expected, hamletParser.countHortatio(toChange));

        assertTrue(toChange.contains("Tariq"));
    }

    @Test
    public void testCountHoratio() {
        Integer expected = 158;

        assertEquals(expected, hamletParser.countHortatio(hamletText));
    }

    @Test
    public void testCountHamlet() {
        Integer expected = 472;

        assertEquals(expected, hamletParser.countHamlet(hamletText));
    }
}