package sample.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正規表現サンプル
 * 
 * @author kichi
 *
 */
public class SampleRegExp {

	public static void main(String[] args) {
		String regExp = ".*?l"; // .一文字 *0回以上 ?最初の一致
		String target = "Hello";
		System.out.println(findMatchRegExp(regExp, target));
	}

	/**
	 * 正規表現と文字列をもらってマッチした結果を返す
	 * 
	 * @param regExp
	 * @param target
	 * @return
	 */
	private static String findMatchRegExp(String regExp, String target) {
		String res = null;
		try {
			Pattern p = Pattern.compile(regExp);
			Matcher m = p.matcher(target);
			if (m.find()) {
				res = m.group();
				return res;
			}
		} catch (Exception e) { // NPE回避
		}
		return null;
	}
}
