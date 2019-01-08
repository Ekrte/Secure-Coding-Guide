package java.secure;

class Element {
	public String s;
	public String[] sa;
}

public class PublicDataAssignedToPrivateArray {
	private String[] userRoles = { "abc", "def", "ghi" };
	private String[][] userDRoles;
	
	public String[] publicRoles;
	
	public void setUserRoles(String[] userRoles, Element e) {
		String k = userRoles[0];
		
		this.userRoles = publicRoles; // Violation
		this.userRoles[0] = k; // NOT violation
		
		this.userRoles = userRoles; // Violation		
		this.userRoles[0] = k; // NOT violation
		
		this.userRoles = e.sa; // Violation
		this.userRoles[0] = e.s; // NOT violation
		this.userRoles[1] = e.sa[0]; // NOT violation
		
		this.userRoles = (String[])new String[userRoles.length];
		this.userRoles = userRoles; // Violation
		this.userRoles[0] = userRoles[0]; // // NOT violation
		
		this.userDRoles[0][1] = userRoles[1]; // // NOT violation
		this.userDRoles[0] = userRoles; // // NOT violation
		
		this.userDRoles = new String[5][2];		
		this.userDRoles[0][1] = userRoles[1]; // // NOT violation
		this.userDRoles[0] = userRoles; // // NOT violation
	}
}

// Test for Excluding Dto class
class userDTO{
    private String[] userRoles = { "abc", "def", "ghi" };
    private String[][] userDRoles;

    public String[] publicRoles;

    public void setUserRoles(String[] userRoles, Element e) {
        String k = userRoles[0];

        this.userRoles = publicRoles; // Violation
        this.userRoles[0] = k; // NOT violation

        this.userRoles = userRoles; // Violation
        this.userRoles[0] = k; // NOT violation

        this.userRoles = e.sa; // Violation
        this.userRoles[0] = e.s; // NOT violation
        this.userRoles[1] = e.sa[0]; // NOT violation

        this.userRoles = (String[])new String[userRoles.length];
        this.userRoles = userRoles; // Violation
        this.userRoles[0] = userRoles[0]; // // NOT violation

        this.userDRoles[0][1] = userRoles[1]; // // NOT violation
        this.userDRoles[0] = userRoles; // // NOT violation

        this.userDRoles = new String[5][2];
        this.userDRoles[0][1] = userRoles[1]; // // NOT violation
        this.userDRoles[0] = userRoles; // // NOT violation
    }
}
