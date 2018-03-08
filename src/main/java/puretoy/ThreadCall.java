package puretoy;

public class ThreadCall{

	private int count;

	private int loopNum = 0;

	public synchronized void process() {
		if (loopNum > 0) {
			for (int i = 0; i < loopNum; i++) {
				count++;
			}
		}
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void returnCount() {
		System.out.println("Thread Count is:" + count);
	}

	public int getLoopNum() {
		return loopNum;
	}

	public void setLoopNum(int loopNum) {
		this.loopNum = loopNum;
	}



}
