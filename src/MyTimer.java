/*
 * Code was taken from High School Prject MyWordyBeta
 */

public class MyTimer implements Runnable{
    private Thread theThread;
    private boolean running;
    private long delta;

    // Initialize a new MyTimer object.  This will simply create the object and
    // initialize variables to default values.
    public MyTimer()
    {
        running = false;
        theThread = null;
    }

    // Set the duration of the timer.  These determines how long the timer will
    // run before it expires.  Note that the time is in milliseconds.
    public synchronized void set(long millis)
    {
        if (!running)
        {
            delta = millis;
        }
        else
            System.out.println("Cannot set timer while running");
    }

    // Start the timer running.  It will continue to run until the set time
    // expires.
    public synchronized void start()
    {
        if (!running)
        {
            running = true;
            new Thread(this).start();
        }
    }

    // This method will return true as long as the timer is running.  It will
    // return false when the timer is not running.
    public synchronized boolean check()
    {
        return running;
    }

    // This method is necessary for the timer but the user of the timer does
    // not need to know it -- it is abstracted out.
    public void run()
    {
        try
        {
            Thread.sleep(delta);
        }
        catch (InterruptedException e)
        {
            System.out.println("Thread Error");
        }
        running = false;
    }
}
