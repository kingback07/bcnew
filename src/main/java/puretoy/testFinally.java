package puretoy;

public class testFinally {

	public static void main(String[] args) {
		testFinallyCls tfsa = new testFinallyCls();
		//System.out.println(test(tfsa).getSs());
		System.out.println(test(tfsa).getAint());
		System.out.println(testFinally.fun());
	}

	public static int fun() {
		int i = 10;
		try {
			return i;
		} catch (Exception e) {
			return 0;
		} finally {
			i = 20;
		}
	}

	@SuppressWarnings("finally")
	private static testFinallyCls test(testFinallyCls tfs) {
		try {
			tfs.setAint(10);
			//tfs.setSs("aa");
			return tfs;

		} catch (Exception e) {

		} finally {
			tfs=new testFinallyCls();
			//tfs.setSs("bb");
			tfs.setAint(20);
			// return tfs;
		}
		return tfs;

	}

}
