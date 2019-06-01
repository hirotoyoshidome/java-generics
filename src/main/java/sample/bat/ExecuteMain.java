package sample.bat;

public class ExecuteMain {

	public static void main(String[] args) {
		// テキストを開く
		String[] text = { "cmd.exe", "/C", "start", "sample.txt" };
		String[] bat = { "cmd.exe", "/C", "start", "sample.bat" };
		try {
			Runtime.getRuntime().exec(bat);
		} catch (Exception e) {
			System.out.println("エラー発生");
		}
	}

}
