package sample.timer;

import java.util.Timer;
import java.util.TimerTask;

public class MyTask extends TimerTask {
	Timer timer;

	MyTask(Timer timer) {
		this.timer = timer;
	}

	private int count = 0;

	@Override
	public void run() {
		count = count + 1;
		System.out.println("タスク" + count);
		if (count == 3) {
			this.timer.cancel();
		}
	}
}
