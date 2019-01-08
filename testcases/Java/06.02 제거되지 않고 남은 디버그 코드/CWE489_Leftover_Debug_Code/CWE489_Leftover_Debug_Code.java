package testcode.sparrow;

public class DebugCode {

    private static boolean DEBUG = false;
    private boolean deBug = true;

    public static void good(Boolean bool) {
        // Just do something
        System.out.println("good");
    }

    public static void bad(Boolean bool) {
        if(DEBUG) {
            // Do something if debug flag is set
            System.out.println("bad");
        }
        // Do something
    }

    public void bad2(Boolean bool) {
        // Check ignoreCase, we cannot know which name for variable is used
        if(deBug) {
            // Do something if debug flag is set
            System.out.println("bad2");
        }
    }

    public void main(String[] args) {
        good(true);
        bad(true);
        bad2(false);
    }
}
