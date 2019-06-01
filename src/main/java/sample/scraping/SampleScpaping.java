/**
 * 
 */
package sample.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Jsoupを使用したサンプルのスクレイピング実装
 * 
 * @author H.Yoshi
 *
 */
public class SampleScpaping {
	public static void main(String[] args) throws Exception {
		String url = "http://outdoorclub.html.xdomain.jp/outdoor/outdoor.html";
		Document doc = Jsoup.connect(url).get();
		Elements elements = doc.select("p"); // htmlレベルのpタグを選択している
		Elements elements2 = doc.select("img"); // selectの引数はcssSelectorで記述することも可能

		for (Element e : elements) {
			System.out.println(e.text());
		}

		System.out.println("------------------------------------------------------");

		for (Element e : elements2) {
			System.out.println(e.attr("src")); // 属性値を取得する
		}
	}

}
