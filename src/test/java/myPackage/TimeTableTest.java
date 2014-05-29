package myPackage;


import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class TimeTableTest {

    private TimeTable timeTable;

    @Test
    public void completeTimeTable() throws ParseException
    {
        String COMPLETE_STAMPINGS = "E08:30 U13:00 E14:00 U17:30";
        InitTimeTable(COMPLETE_STAMPINGS);

        assertEquals("8:00", timeTable.getTimeWorked());
        assertEquals(COMPLETE_STAMPINGS, timeTable.toString());
    }

    @Test
    public void extraTimeTable() throws ParseException
    {
        String EXTRA_STAMPINGS = "E08:30 U13:30 E14:00 U17:30";
        InitTimeTable(EXTRA_STAMPINGS);

        assertEquals("8:30", timeTable.getTimeWorked());
        assertEquals(EXTRA_STAMPINGS, timeTable.toString());
    }

    @Test
    public void reducedTimeTable() throws ParseException
    {
        String REDUCED_STAMPINGS = "E08:30 U13:00 E14:00 U17:00";
        InitTimeTable(REDUCED_STAMPINGS);

        assertEquals("7:30", timeTable.getTimeWorked());
        assertEquals(REDUCED_STAMPINGS, timeTable.toString());
    }

    @Test
    public void incompleteTimeTableWillBeComplete() throws ParseException
    {
        String INCOMPLETE_STAMPINGS = "E08:00 U13:00 E14:00 ";
        InitTimeTable(INCOMPLETE_STAMPINGS);

        assertEquals("8:00", timeTable.getTimeWorked());
        assertEquals(INCOMPLETE_STAMPINGS + "U17:00", timeTable.toString());
    }

    @Test
    public void multipleTimeTable() throws ParseException
    {
        String MULTIPLE_STAMPINGS = "E08:00 U09:00 E10:00 U13:00 E14:00 U18:00";
        InitTimeTable(MULTIPLE_STAMPINGS);

        assertEquals("8:00", timeTable.getTimeWorked());
    }

    private void InitTimeTable(String stampings) throws ParseException
    {
        timeTable = new TimeTable(stampings);
    }
}
