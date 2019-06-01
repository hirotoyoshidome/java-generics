package sample.timer;

import java.util.Timer;

public class SampleTimer {

	public static void main(String[] args) {
		// trueの場合デーモンスレッド化となり通常スレッドの終了とともに終了するらしい
		Timer timer = new Timer(false);
		MyTask task = new MyTask(timer);
		timer.schedule(task, 0, 3000); // 3秒ごとに実行 3回で終了するように設定している
	}
}
