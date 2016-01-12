package com.paul.ctcalculator.logger;

/**
 * Log is designed to display the information on 3 diff levels accordingly
 * Log level is used to define the level of information
 *
 * Log_Level can be used to setup from the command line to display 3 levels of information
 * Error - covers Error only
 * Info - covers Info & Error
 * Debug - covers Info & Error & Debug *
 *
 */
public class Log {

    public static final int DEBUG = 0;
    public static final int INFO = 1;
    public static final int ERROR = 2;

    private static int level = DEBUG;

    private static Log instance;


    private Log(){};

    public static Log getInstance(){
        if (instance == null)
        {
            instance = new Log();
            instance.SetDebugLevel(DEBUG);
        }

        return instance;
    }

    public void SetDebugLevel(int number)
    {
        level = number;
    }

    public void Debug(String content)
    {
        if(level <= DEBUG)
        {
            System.out.println("Debug - "+content);
        }
    }

    public void Info(String content)
    {
        if(level <= INFO)
        {
            System.out.println("Info - "+content);
        }
    }

    public void Error(String content)
    {
        if (level <= ERROR ) {
            System.out.println("Error - "+content);
        }
    }

}
