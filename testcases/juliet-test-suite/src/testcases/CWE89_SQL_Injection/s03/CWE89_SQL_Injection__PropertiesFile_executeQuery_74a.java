/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__PropertiesFile_executeQuery_74a.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-74a.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: executeQuery
 *    GoodSink: Use prepared statement and executeQuery (properly)
 *    BadSink : data concatenated into SQL statement used in executeQuery(), which could result in SQL Injection
 * Flow Variant: 74 Data flow: data passed in a HashMap from one method to another in different source files in the same package
 *
 * */

package testcases.CWE89_SQL_Injection.s03;
import testcasesupport.*;
import java.util.HashMap;

import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;

public class CWE89_SQL_Injection__PropertiesFile_executeQuery_74a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* retrieve the property */
        {
            Properties properties = new Properties();
            FileInputStream streamFileInput = null;

            try
            {
                streamFileInput = new FileInputStream("../common/config.properties");
                properties.load(streamFileInput);

                /* POTENTIAL FLAW: Read data from a .properties file */
                data = properties.getProperty("data");
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                /* Close stream reading object */
                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                }
            }
        }

        HashMap<Integer,String> dataHashMap = new HashMap<Integer,String>();
        dataHashMap.put(0, data);
        dataHashMap.put(1, data);
        dataHashMap.put(2, data);
        (new CWE89_SQL_Injection__PropertiesFile_executeQuery_74b()).badSink(dataHashMap  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        HashMap<Integer,String> dataHashMap = new HashMap<Integer,String>();
        dataHashMap.put(0, data);
        dataHashMap.put(1, data);
        dataHashMap.put(2, data);
        (new CWE89_SQL_Injection__PropertiesFile_executeQuery_74b()).goodG2BSink(dataHashMap  );
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* retrieve the property */
        {
            Properties properties = new Properties();
            FileInputStream streamFileInput = null;

            try
            {
                streamFileInput = new FileInputStream("../common/config.properties");
                properties.load(streamFileInput);

                /* POTENTIAL FLAW: Read data from a .properties file */
                data = properties.getProperty("data");
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                /* Close stream reading object */
                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                }
            }
        }

        HashMap<Integer,String> dataHashMap = new HashMap<Integer,String>();
        dataHashMap.put(0, data);
        dataHashMap.put(1, data);
        dataHashMap.put(2, data);
        (new CWE89_SQL_Injection__PropertiesFile_executeQuery_74b()).goodB2GSink(dataHashMap  );
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
