package sample.robot;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class SampleRobot {
	private static final String OUTPUTDIR = "out\\";
	private static final SimpleDateFormat format = new SimpleDateFormat("MMdd_hhmmss");

	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
		takeScreenCap(robot);
	}

	/**
	 * スクショを撮影する
	 * 
	 * @param robot
	 * @throws Exception
	 */
	private static void takeScreenCap(Robot robot) throws Exception {
		// サイズを決める
		Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		System.out.println("取ります");
		// １秒止まって撮影
		robot.delay(1000);
		// スクショ撮影
		BufferedImage imag = robot.createScreenCapture(rectangle);
		// ディレクトリと名前を設定
		File file = new File(OUTPUTDIR, format.format(new Date()) + "-sampleShot.png");
		// 出力
		ImageIO.write(imag, "png", file);
		System.out.println("スクリーンショット保存しました。");
	}
}
