/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE129_Improper_Validation_of_Array_Index__large_fixed_array_write_no_check_22a.java
Label Definition File: CWE129_Improper_Validation_of_Array_Index.label.xml
Template File: sources-sinks-22a.tmpl.java
*/
/*
 * @description
 * CWE: 129 Improper Validation of Array Index
 * BadSource: large_fixed Set data to a value greater than the size of the array
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: array_write_no_check
 *    GoodSink: Write to array after verifying index
 *    BadSink : Write to array without any verification of index
 * Flow Variant: 22 Control flow: Flow controlled by value of a public static variable. Sink functions are in a separate file from sources.
 *
 * */

package testcases.CWE129_Improper_Validation_of_Array_Index.s03;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE129_Improper_Validation_of_Array_Index__large_fixed_array_write_no_check_22a extends AbstractTestCase
{
    /* The public static variable below is used to drive control flow in the sink function.
     * The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean badPublicStatic = false;

    public void bad() throws Throwable
    {
        int data = 0;

        /* POTENTIAL FLAW: Set data to a value greater than the size of the array */
        data = 100;

        badPublicStatic = true;
        (new CWE129_Improper_Validation_of_Array_Index__large_fixed_array_write_no_check_22b()).badSink(data );
    }

    /* The public static variables below are used to drive control flow in the sink functions.
     * The public static variable mimics a global variable in the C/C++ language family. */
    public static boolean goodB2G1PublicStatic = false;
    public static boolean goodB2G2PublicStatic = false;
    public static boolean goodG2BPublicStatic = false;

    public void good() throws Throwable
    {
        goodB2G1();
        goodB2G2();
        goodG2B();
    }

    /* goodB2G1() - use badsource and goodsink by setting the static variable to false instead of true */
    private void goodB2G1() throws Throwable
    {
        int data = 0;

        /* POTENTIAL FLAW: Set data to a value greater than the size of the array */
        data = 100;

        goodB2G1PublicStatic = false;
        (new CWE129_Improper_Validation_of_Array_Index__large_fixed_array_write_no_check_22b()).goodB2G1Sink(data );
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the if in the sink function */
    private void goodB2G2() throws Throwable
    {
        int data = 0;

        /* POTENTIAL FLAW: Set data to a value greater than the size of the array */
        data = 100;

        goodB2G2PublicStatic = true;
        (new CWE129_Improper_Validation_of_Array_Index__large_fixed_array_write_no_check_22b()).goodB2G2Sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data = 0;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        goodG2BPublicStatic = true;
        (new CWE129_Improper_Validation_of_Array_Index__large_fixed_array_write_no_check_22b()).goodG2BSink(data );
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
