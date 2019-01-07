/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__Environment_68a.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded string
 * BadSink:  data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE90_LDAP_Injection__Environment_68a extends AbstractTestCase
{
    public static String data;

    public void bad() throws Throwable
    {

        /* get environment variable ADD */
        /* POTENTIAL FLAW: Read data from an environment variable */
        data = System.getenv("ADD");

        (new CWE90_LDAP_Injection__Environment_68b()).badSink();
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE90_LDAP_Injection__Environment_68b()).goodG2BSink();
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
