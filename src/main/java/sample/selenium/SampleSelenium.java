/**
 * 
 */
package sample.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * seleniumサンプル動作確認
 * 
 * @author H.Yoshi
 *
 */
public class SampleSelenium {
	public static void main(String[] args) {
		String url = "https://www.google.com/";
		System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("ねこ"); // 検索用のテキストボックスのxpathを指定しsendKeysで文字を入力する
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).submit(); // 検索用ボタンをサブミットし検索させる
		driver.quit(); // ブラウザを閉じる
		driver.close();
	}
}
