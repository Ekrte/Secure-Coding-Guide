public class Sample1 {
	public static void generateKey() {
		try {
			final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(RSA);
			keyGen.initialize(512);
			final KeyPair key = keyGen.generateKeyPair();
		} catch (Exception e) {

		}
	}
}