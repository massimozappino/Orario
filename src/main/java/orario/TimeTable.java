package orario;

import java.util.ArrayList;

public class TimeTable {
    static final long ONE_MINUTE = 60;

    private ArrayList<EntranceAndExit> timeTable;

    public TimeTable(String stampings) throws Exception
    {
        timeTable = new ArrayList<EntranceAndExit>();

        stampings = stampings.replaceAll(" ", "").replaceAll("E", " E").trim();

        String[] arrStampings = stampings.split(" ");

        for (String stamping : arrStampings)
        {
            timeTable.add(new EntranceAndExit(stamping));
        }
    }

    public String toString()
    {
        String s = "";
        for (EntranceAndExit eu : timeTable)
            s += " " + eu.toString();
        return s.trim();
    }

    public String getTimeWorked()
    {
        long diff = 0;

        for (EntranceAndExit eu : timeTable)
        {
            if (eu.isIncomplete())
            {
                diff += eu.getMinutesWorked(diff);
            }
            else
            {
                diff += eu.getMinutesWorked();
            }
        }

        long diffHours = diff / ONE_MINUTE;
        long diffMinutes = diff - (diffHours * ONE_MINUTE);

        return String.valueOf(diffHours) +
                ":" +
                ((diffMinutes < 10)? "0" : "") + String.valueOf(diffMinutes);
    }
}
