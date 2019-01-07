package testcases.CWE338_Weak_PRNG;

import testcasesupport.*;

public class Main {

	public static void main(String[] args) {
		
		if(args.length != 0) {
		
			if(args[0].equals("-h") || args[0].equals("--help")) {
		
				System.err.println("To use this main, you can either run the program with no " +
				"command line arguments to run all test cases or you can specify one or more classes to test");
				System.err.println("For example:");
				System.err.println("java testcasesupport.Main testcases.CWE690_Unchecked_Return_Value_to_NULL_Pointer_Dereference.custom_function.CWE690_Unchecked_Return_Value_to_NULL_Pointer_Dereference__custom_function_01 testcases.CWE481_Assigning_instead_of_Comparing.bool.CWE481_Assigning_instead_of_Comparing__bool_01");
				System.exit(1);
			}
			
			/* User supplied some class names on the command line, just use those with introspection
			 *
			 * String classNames[] = { "CWE481_Assigning_instead_of_Comparing__boolean_01",
			 *		"CWE476_Null_Pointer_Dereference__getProperty_01" };
 			 * could read class names from command line or use
			 * http://sadun-util.sourceforge.net/api/org/sadun/util/
			 * ClassPackageExplorer.html
			 */

			for (String className : args) {

				try {
					
					/* String classNameWithPackage = "testcases." + className; */
					
					/* IO.writeLine("classNameWithPackage = " + classNameWithPackage); */

					Class<?> myClass = Class.forName(className);

					AbstractTestCase myObject = (AbstractTestCase) myClass
							.newInstance();

					myObject.runTest(className);

				} catch (Exception ex) {

					IO.writeLine("Could not run test for class " + className);
					ex.printStackTrace();

				}
				
				IO.writeLine(""); /* leave a blank line between classes */

			}

		} else {
		
			/* No command line args were used, we want to run every testcase */
			
			/* needed to separate these calls into other methods because
			   we were running into the size limit Java has for a single method */
			runTestCWE1();
			runTestCWE2();
			runTestCWE3();
			runTestCWE4();
			runTestCWE5();
			runTestCWE6();
			runTestCWE7();
			runTestCWE8();
			runTestCWE9();
		}			
	}

private static void runTestCWE1() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-1 */

			/* END-AUTOGENERATED-JAVA-TESTS-1 */
}

private static void runTestCWE2() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-2 */

			/* END-AUTOGENERATED-JAVA-TESTS-2 */
}

private static void runTestCWE3() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-3 */
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_01()).runTest("CWE338_Weak_PRNG__math_01");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_02()).runTest("CWE338_Weak_PRNG__math_02");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_03()).runTest("CWE338_Weak_PRNG__math_03");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_04()).runTest("CWE338_Weak_PRNG__math_04");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_05()).runTest("CWE338_Weak_PRNG__math_05");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_06()).runTest("CWE338_Weak_PRNG__math_06");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_07()).runTest("CWE338_Weak_PRNG__math_07");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_08()).runTest("CWE338_Weak_PRNG__math_08");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_09()).runTest("CWE338_Weak_PRNG__math_09");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_10()).runTest("CWE338_Weak_PRNG__math_10");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_11()).runTest("CWE338_Weak_PRNG__math_11");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_12()).runTest("CWE338_Weak_PRNG__math_12");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_13()).runTest("CWE338_Weak_PRNG__math_13");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_14()).runTest("CWE338_Weak_PRNG__math_14");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_15()).runTest("CWE338_Weak_PRNG__math_15");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_16()).runTest("CWE338_Weak_PRNG__math_16");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__math_17()).runTest("CWE338_Weak_PRNG__math_17");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_01()).runTest("CWE338_Weak_PRNG__util_01");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_02()).runTest("CWE338_Weak_PRNG__util_02");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_03()).runTest("CWE338_Weak_PRNG__util_03");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_04()).runTest("CWE338_Weak_PRNG__util_04");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_05()).runTest("CWE338_Weak_PRNG__util_05");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_06()).runTest("CWE338_Weak_PRNG__util_06");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_07()).runTest("CWE338_Weak_PRNG__util_07");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_08()).runTest("CWE338_Weak_PRNG__util_08");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_09()).runTest("CWE338_Weak_PRNG__util_09");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_10()).runTest("CWE338_Weak_PRNG__util_10");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_11()).runTest("CWE338_Weak_PRNG__util_11");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_12()).runTest("CWE338_Weak_PRNG__util_12");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_13()).runTest("CWE338_Weak_PRNG__util_13");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_14()).runTest("CWE338_Weak_PRNG__util_14");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_15()).runTest("CWE338_Weak_PRNG__util_15");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_16()).runTest("CWE338_Weak_PRNG__util_16");
			(new testcases.CWE338_Weak_PRNG.CWE338_Weak_PRNG__util_17()).runTest("CWE338_Weak_PRNG__util_17");
			/* END-AUTOGENERATED-JAVA-TESTS-3 */
}

private static void runTestCWE4() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-4 */

			/* END-AUTOGENERATED-JAVA-TESTS-4 */
}

private static void runTestCWE5() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-5 */

			/* END-AUTOGENERATED-JAVA-TESTS-5 */
}

private static void runTestCWE6() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-6 */

			/* END-AUTOGENERATED-JAVA-TESTS-6 */
}

private static void runTestCWE7() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-7 */

			/* END-AUTOGENERATED-JAVA-TESTS-7 */
}

private static void runTestCWE8() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-8 */

			/* END-AUTOGENERATED-JAVA-TESTS-8 */
}

private static void runTestCWE9() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-9 */

			/* END-AUTOGENERATED-JAVA-TESTS-9 */
}
}