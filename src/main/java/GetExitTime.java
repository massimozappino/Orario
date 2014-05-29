import java.text.ParseException;

public class GetExitTime {

    static String cartellino =// "E08:21 U13:05 E13:56 U16:10";

             "LUNEDÌ 05/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:15 U13:07 E13:59 U16:11\n" +
                     " MARTEDÌ 06/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:56 U13:06 E14:08 U18:10\n" +
                     " MERCOLEDÌ 07/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:27 U13:04 E13:54 U17:33\n" +
                     " GIOVEDÌ 08/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:41 U13:09 E14:08 U17:35\n" +
                     " VENERDÌ 09/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:36 U13:07 E14:01 U17:38\n" +
                     " SABATO 10/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\t - \n" +
                     " DOMENICA 11/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\t - \n" +
                     " LUNEDÌ 12/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:13 U13:05\n" +
                     " MARTEDÌ 13/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\t - \n" +
                     " MERCOLEDÌ 14/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:33 U13:04 E14:05 U17:52\n" +
                     " GIOVEDÌ 15/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:06 U13:03 E14:01 U17:23\n" +
                     " VENERDÌ 16/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\t - \n" +
                     " SABATO 17/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\t - \n" +
                     " DOMENICA 18/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\t - \n" +
                     " LUNEDÌ 19/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:42 U13:05 E14:03 U17:47\n" +
                     " MARTEDÌ 20/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:25 U12:55 E14:00 U17:40\n" +
                     " MERCOLEDÌ 21/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:29 U13:06 E14:06 U17:38\n" +
                     " GIOVEDÌ 22/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:21 U13:05 E13:56 U16:10\n" +
                     " VENERDÌ 23/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:08 U12:18 E14:18 U18:13\n" +
                     " SABATO 24/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\t - \n" +
                     " DOMENICA 25/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\t - \n" +
                     " LUNEDÌ 26/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:31 U13:05 E13:54 U17:57\n" +
                     " MARTEDÌ 27/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\t - \n" +
                     " MERCOLEDÌ 28/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:31 U13:03 E14:06 U18:06\n" +
                     " GIOVEDÌ 29/05/2014\t Aggiungi Timbratura \n" +
                     "Timbrature:\tE08:30 U13:04";

    public static void main(String[] args) throws ParseException {

        TimeTable t;
        String s;
        String day = "";
        if(cartellino.indexOf("\t") > 0)
        {
            for(String riga : cartellino.split("\n"))
            {
                if(riga.startsWith("Timbrature:"))
                {
                    s = riga.substring(riga.indexOf("\t")+1);
                    if(!s.equals(" - "))
                    {
                        t = new TimeTable(s);
                        System.out.print(day);
                        System.out.print("\t\t\t" + t.getTimeWorked());
                        System.out.println("\t\t\t" + t.toString());
                    }
                }
                else
                {
                    day = riga.substring(Math.max(0, riga.indexOf("Ì")+1), Math.max(0, riga.indexOf("\t")));
                }
            }
        }
        else
        {
            t = new TimeTable(cartellino);
            System.out.print(t.getTimeWorked());
            System.out.println("\t\t\t" + t.toString());
        }
    }
}
