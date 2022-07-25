/**
 *  LogFormatter:  provides color by using the ANSI escape codes.
 * @author Hagar Abdelsamad Elgabry
 */

package com.appium.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
public class LogFormatter extends Formatter
{
    // ANSI escape code
    public static final String ANSI_RESET = "\u001B[0m\t";
    public static final String ANSI_BLACK = "\u001B[30m\t";
    public static final String ANSI_RED = "\u001B[31m\t";
    public static final String ANSI_GREEN = "\u001B[32m\t";
    public static final String ANSI_YELLOW = "\u001B[33m\t";
    public static final String ANSI_BLUE = "\u001B[34m\t";
    public static final String ANSI_PURPLE = "\u001B[35m\t";
    public static final String ANSI_CYAN = "\u001B[36m\t";
    public static final String ANSI_WHITE = "\u001B[37m\t";

    /* Here you can configure the format of the output and
    * its color by using the ANSI escape codes defined above.
     format is called for every console log message
     * */
    @Override
    public String format(LogRecord record)
    {


         /* This example will print date/time, class, and log level in yellow,
          * followed by the log message and it's parameters in white .
         */
        StringBuilder builder = new StringBuilder();
        builder.append(ANSI_YELLOW);
        builder.append("[");
        builder.append(calcDate(record.getMillis()));
        builder.append("]");

        builder.append(" [");
        builder.append(record.getSourceClassName());
        builder.append("]");

        builder.append(" [");
        builder.append(record.getLevel().getName());
        builder.append("]");

        builder.append(ANSI_WHITE);
        builder.append(" - ");
        builder.append(record.getMessage());

        Object[] params = record.getParameters();

        if (params != null)
        {
            builder.append("\t");
            for (int i = 0; i < params.length; i++)
            {
                builder.append(params[i]);
                if (i < params.length - 1)
                    builder.append(", ");
            }
        }

        builder.append(ANSI_RESET);
        builder.append("\n");
        return builder.toString();
    }

    private String calcDate(long milliSecs) {
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date resultDate = new Date(milliSecs);
        return date_format.format(resultDate);
    }
}

