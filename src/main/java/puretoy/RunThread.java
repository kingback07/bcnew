package puretoy;

public class RunThread implements Runnable {

	private int runIndex=0;
	
	private ThreadCall instance;
	
	public RunThread(ThreadCall th) {
		instance=th;
	}
	
	@Override
	public void run() {
		System.out.println("正在执行task "+runIndex);
		
		instance.process();
		instance.returnCount();

		System.out.println("task "+runIndex+"执行完毕");
		
	}

	public int getRunIndex() {
		return runIndex;
	}

	public void setRunIndex(int runIndex) {
		this.runIndex = runIndex;
	}

}
