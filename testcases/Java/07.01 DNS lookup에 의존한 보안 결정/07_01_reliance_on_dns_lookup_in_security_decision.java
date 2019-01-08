public class Sample1 {
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		boolean trusted = false;
		String ip = req.getRemoteAddr();
		InetAddress addr = InetAddress.getByName(ip);
		if(addr.getCanonicalHostName().endsWith("trustme.com")) { //vulnearble
			do_something_for_trust_system();
		}
		if(addr.getCanonicalHostName().endsWith("127.0.0.1")) { //safe
			do_something_for_trust_system();
		}
		String trustedAddr = "127.0.0.1";
		// Actually, it could not detect cases which use variable.
		if(addr.getCanonicalHostName().endsWith(trustedAddr)) { //safe
			do_something_for_trust_system();
		}
		if(addr.getCanonicalHostName().endsWith("danger.com")) { //vulnearble
			do_something_for_trust_system();
		}
	}
}