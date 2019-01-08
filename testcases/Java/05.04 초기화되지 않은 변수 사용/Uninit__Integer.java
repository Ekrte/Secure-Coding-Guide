import java.io.File;

public class Uninit__Integer extends Thread {
    private Integer dataBad;
    private Integer dataGoodG2B;
    private Integer dataGoodB2G;

    private void badSink() throws Throwable
    {
        Integer data = dataBad;

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        System.out.println("" + data.toString());

    }

    public void bad() throws Throwable
    {
        Integer data;

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
        Integer data = dataGoodG2B;

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        System.out.println("" + data.toString());

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        Integer data;

        /* FIX: hardcode data to non-null */
        data = Integer.valueOf(5);

        dataGoodG2B = data;
        goodG2BSink();
    }

    private void goodB2GSink() throws Throwable
    {
        Integer data = dataGoodB2G;

        /* FIX: validate that data is non-null */
        if (data != null)
        {
            System.out.println("" + data.toString());
        }
        else
        {
            System.out.println("data is null");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        Integer data;

        /* POTENTIAL FLAW: data is null */
        data = null;

        dataGoodB2G = data;
        goodB2GSink();
    }
}
