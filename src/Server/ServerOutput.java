package Server;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Print log
 */
public class ServerOutput {
    public static void println(String s) {
    	//Get time now
        Date date = new Date();
            SimpleDateFormat sdf =
                    new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");

        //Print log with time
        System.out.print("\n>> " + sdf.format(date) + ": " + s);
    }
}
