package sample.stream;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Streamのサンプル<br />
 * 文字コードはUTF-8で設定(Shift_jisでは参照不可)
 */
public class SampleStream {
	/** 読込パス */
	private static final String INPUT_PATH = "in\\in.txt";
	/** 出力パス */
	private static final String OUTPUT_PATH = "out\\out.txt";

	public static void main(String[] args) throws Exception {
		// FileSystemを取得
		FileSystem fs = FileSystems.getDefault();
		// ファイルのパスを設定
		Path path = fs.getPath(INPUT_PATH);
		// 出力用のパスを設定
		Path out = fs.getPath(OUTPUT_PATH);
		/*
		 * // 読み込み方その1 // Files.linesを使用して読み込む try (Stream<String> stream =
		 * Files.lines(path, StandardCharsets.UTF_8)) { stream.filter(s ->
		 * s.contains("link")).map(s -> s.replace("html", "form")) .map(s ->
		 * s.replace("action", "href")).forEach(System.out::println); } catch
		 * (IOException e) { System.out.println("error"); }
		 * 
		 * // 読み方その2 // Files.readAllLinesを使用して読み込む List<String> lines =
		 * Files.readAllLines(path, StandardCharsets.UTF_8); List<String> output = new
		 * ArrayList<String>(); lines.stream().filter(s -> s.contains("link")).forEach(s
		 * -> output.add(s));
		 * 
		 * // 抽出したデータをListに詰めてテキストに出力 // Files.write(out, output,
		 * StandardCharsets.UTF_8, StandardOpenOption.APPEND);
		 * 
		 * // 出力したデータを拡張for文で出力して確認 for (String put : output) { System.out.println(put);
		 * }
		 */
		List<String> blank = Files.readAllLines(path, StandardCharsets.UTF_8);
		/*
		 * //一度Listに格納されているためここでのcontainsはbooleanの結果を返すためSysoutの結果はtrue or falseである
		 * //mapメソッドの中で&&等を使用して複数の条件を指定するときは型によって限定される blank.stream().map(s ->
		 * s.contains("form")).forEach(System.out::println);
		 */
		// 複数の変換処理を行う場合
		List<String> result = new ArrayList<String>(); // 最終変換結果出力用
		// pageをhrefに変換する
		blank.stream().map(s -> s.replace("page", "href")).forEach(s -> result.add(s));

		// blankに格納されているデータを消去しresultのデータを詰め替えresultを消去する
		blank.clear();
		for (String res : result) {
			blank.add(res);
		}
		result.clear();

		// actionをhrefに変換する
		blank.stream().map(s -> s.replace("action", "href")).forEach(s -> result.add(s));

		for (String res : result) {
			System.out.println(res);
		}

		// private List<String> fix (List<String> oldList, List<String> newList) {
		// newList.clear();
		// for(String old : oldList) {
		// newList.add(old);
		// }
		// return newList;
		// }

	}

}
