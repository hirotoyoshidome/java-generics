/**
 * 
 */
package sample.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * SJISからUTF-8に変換
 * 
 * @author H.Yoshi
 *
 */
public class CherTypeConvert {
	public static void main(String[] args) throws IOException {
		System.out.println("文字コードを変換します");
		File dir = new File("in");
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			convert(file);
		}
		System.out.println("変換を終了します");
	}

	private static void convert(File file) throws IOException {
		File out = new File("out");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Shift_jis"));
				PrintWriter pw = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), "UTF-8")))) {
			String s;
			while ((s = br.readLine()) != null) {
				pw.println(s);
			}
		}
	}
}
