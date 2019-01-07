/*
 * @description A class defines equals() but not hashcode(), which possibly breaks a 
 * java invariant that if a.equals(b) == true then a.hashCode() == b.hashCode()
 * 
 * This is the "good" version, which defines both hashCode() and equals().
 * There is no need to implement the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE581_Object_Model_Violation;

import testcasesupport.*;

public class CWE581_Object_Model_Violation__hashCode_01_good1 extends AbstractTestCaseClassIssueGood 
{

    private String message = "test";
    public void setMessage(String message) 
    {
        this.message = message;
    }
    
    public boolean equals(Object object)
    {
        if (object == this)
        {
            return true;
        }
        
        if (object == null)
        {
            return false;
        }
        
        if (object.getClass() != this.getClass())
        {
            return false;
        }
        
        CWE581_Object_Model_Violation__hashCode_01_good1 objectGood1 = (CWE581_Object_Model_Violation__hashCode_01_good1)object;

        if (objectGood1.message.equals(this.message))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private int seed = 12345; /* Helps to prevent collisions */
    /* FIX: hashcode() is defined in addition to equals() */
    public int hashCode() 
    {
        return message.hashCode() + seed;
    }

    private void good1() 
    { 
        /* Class-based issue */
    }
    
    public void good() 
    {
        good1();
    }
        
    /* Below is the main(). It is only used when building this testcase on 
     * its own for testing or for building a binary to use in testing binary 
     * analysis tools. It is not used when compiling all the testcases as one 
     * application, which is how source code analysis tools are tested. 
	 */ 
    public static void main(String[] args) 
            throws ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        mainFromParent(args);
    }
}
