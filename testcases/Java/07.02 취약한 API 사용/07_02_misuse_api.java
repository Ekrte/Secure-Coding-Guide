public class U382 extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse reponse)
	throws ServletException, IOException {
		try {
			do_something();
		} catch(IOException ase) {
			System.exit(1);
		} catch(ServletExcpetion se) {
			System.out.println("Error");
		}
	}
}