/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__int_getCookies_Servlet_square_21.java
Label Definition File: CWE190_Integer_Overflow__int.label.xml
Template File: sources-sinks-21.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 21 Control flow: Flow controlled by value of a private variable. All functions contained in one file.
 *
 * */

package testcases.CWE190_Integer_Overflow.s02;
import testcasesupport.*;

import javax.servlet.http.*;


import java.util.logging.Level;

public class CWE190_Integer_Overflow__int_getCookies_Servlet_square_21 extends AbstractTestCaseServlet
{
    /* The variable below is used to drive control flow in the sink function */
    private boolean badPrivate = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* initialize data in case there are no cookies */

        /* Read data from cookies */
        {
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                /* POTENTIAL FLAW: Read data from the first cookie value */
                String stringNumber = cookieSources[0].getValue();
                try
                {
                    data = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception reading data from cookie", exceptNumberFormat);
                }
            }
        }

        badPrivate = true;
        badSink(data , request, response);
    }

    private void badSink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (badPrivate)
        {
            /* POTENTIAL FLAW: if (data*data) > Integer.MAX_VALUE, this will overflow */
            int result = (int)(data * data);
            IO.writeLine("result: " + result);
        }
    }

    /* The variables below are used to drive control flow in the sink functions. */
    private boolean goodB2G1Private = false;
    private boolean goodB2G2Private = false;
    private boolean goodG2BPrivate = false;

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodB2G1(request, response);
        goodB2G2(request, response);
        goodG2B(request, response);
    }

    /* goodB2G1() - use BadSource and GoodSink by setting the variable to false instead of true */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* initialize data in case there are no cookies */

        /* Read data from cookies */
        {
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                /* POTENTIAL FLAW: Read data from the first cookie value */
                String stringNumber = cookieSources[0].getValue();
                try
                {
                    data = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception reading data from cookie", exceptNumberFormat);
                }
            }
        }

        goodB2G1Private = false;
        goodB2G1Sink(data , request, response);
    }

    private void goodB2G1Sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (goodB2G1Private)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: Add a check to prevent an overflow from occurring */
            /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
            if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Integer.MAX_VALUE)))
            {
                int result = (int)(data * data);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too large to perform squaring.");
            }

        }
    }

    /* goodB2G2() - use BadSource and GoodSink by reversing the blocks in the if in the sink function */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        data = Integer.MIN_VALUE; /* initialize data in case there are no cookies */

        /* Read data from cookies */
        {
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                /* POTENTIAL FLAW: Read data from the first cookie value */
                String stringNumber = cookieSources[0].getValue();
                try
                {
                    data = Integer.parseInt(stringNumber.trim());
                }
                catch(NumberFormatException exceptNumberFormat)
                {
                    IO.logger.log(Level.WARNING, "Number format exception reading data from cookie", exceptNumberFormat);
                }
            }
        }

        goodB2G2Private = true;
        goodB2G2Sink(data , request, response);
    }

    private void goodB2G2Sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (goodB2G2Private)
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            /* NOTE: Math.abs of the minimum int or long will return that same value, so we must check for it */
            if ((data != Integer.MIN_VALUE) && (data != Long.MIN_VALUE) && (Math.abs(data) <= (long)Math.sqrt(Integer.MAX_VALUE)))
            {
                int result = (int)(data * data);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too large to perform squaring.");
            }
        }
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        goodG2BPrivate = true;
        goodG2BSink(data , request, response);
    }

    private void goodG2BSink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (goodG2BPrivate)
        {
            /* POTENTIAL FLAW: if (data*data) > Integer.MAX_VALUE, this will overflow */
            int result = (int)(data * data);
            IO.writeLine("result: " + result);
        }
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
