package orario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EntranceAndExit {

    private Date entrance;
    private Date exit;

    static final long WORK_DAY_TOTAL_MINUTES = 480;
    static final long ONE_MINUTE_IN_MILLIS = 60000;

    private SimpleDateFormat stampingDateFormat = new SimpleDateFormat("HH:mm");

    public EntranceAndExit(String stamping) throws Exception {
        try {
            String[] stampings = stamping.split("U");
            entrance = stampingDateFormat.parse(stampings[0].substring(1));
            if (stampings.length > 1) {
                exit = stampingDateFormat.parse(stampings[1]);
            } else {
                exit = entrance;
            }
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    public long getMinutesWorked()
    {
        return (exit.getTime() - entrance.getTime()) / (ONE_MINUTE_IN_MILLIS);
    }

    public long getMinutesWorked(long diff)
    {
        exit = new Date(entrance.getTime() + ONE_MINUTE_IN_MILLIS * (WORK_DAY_TOTAL_MINUTES - diff));
        return getMinutesWorked();
    }

    public String toString()
    {
        return "E" + stampingDateFormat.format(entrance) +
              " U" + stampingDateFormat.format(exit);
    }

    public boolean isIncomplete() {
        return exit.equals(entrance);
    }
}
