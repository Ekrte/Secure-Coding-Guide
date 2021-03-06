import java.io.File;

public class Uninit__int_array extends Thread {
    private int [] dataBad;
    private int [] dataGoodG2B;
    private int [] dataGoodB2G;

    private void badSink() throws Throwable
    {
        int [] data = dataBad;

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        System.out.println("" + data.length);

    }

    public void bad() throws Throwable
    {
        int [] data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        dataBad = data;
        badSink();
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2BSink() throws Throwable
    {
        int [] data = dataGoodG2B;

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        System.out.println("" + data.length);

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int [] data;

        /* FIX: hardcode data to non-null */
        data = new int[5];

        dataGoodG2B = data;
        goodG2BSink();
    }

    private void goodB2GSink() throws Throwable
    {
        int [] data = dataGoodB2G;

        /* FIX: validate that data is non-null */
        if (data != null)
        {
            System.out.println("" + data.length);
        }
        else
        {
            System.out.println("data is null");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int [] data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        dataGoodB2G = data;
        goodB2GSink();
    }
}
