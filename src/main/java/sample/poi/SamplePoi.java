/**
 * 
 */
package sample.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * サンプルpoi実装
 * 
 * @author H.Yoshi
 *
 */
public class SamplePoi {
	public static void main(String[] args) throws Exception {
		readExcel();
		createExcel();
	}

	/**
	 * 
	 * Excelファイルを読み込みます
	 * 
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	private static void readExcel() throws Exception {
		// ファイルの読み込み
		String filePath = "sample.xlsx";
		int sheetNum = 0;
		int rowNum = 0;
		int cellNum = 0;
		int cellNum2 = 1;
		// InputStream is = new FileInputStream(filePath); //でも取得可能
		Workbook wb = WorkbookFactory.create(new File(filePath));
		// シートの読み込み
		Sheet sheet = wb.getSheetAt(sheetNum); // シート名での指定も可能 for文で全シートを読み込むことも可能
		// 行の読み込み
		Row row = sheet.getRow(rowNum); // for文で全行を読み込むことも可能
		// セルの読み込み
		Cell cell = row.getCell(cellNum); // for文で全セルを読み込むことも可能
		Cell cell2 = row.getCell(cellNum2);
		String cellVal = cell.getStringCellValue(); // セルの値を取得
		String cellVal2 = cell2.getStringCellValue();
		System.out.println(cellVal);
		System.out.println(cellVal2);

		CellStyle cs; // セルの書式設定を取得することも可能(省略)
		// BuildPathの設定をする必要あり(読み込みまでは完了した)
	}

	/**
	 * Excelファイルを出力します
	 * 
	 * @throws IOException
	 */
	private static void createExcel() throws Exception {
		String filePath = "output.xlsx";
		Workbook book = null;
		FileOutputStream out = null;
		try {
			book = new SXSSFWorkbook();
			Font font = book.createFont();
			CellStyle cellStyle = book.createCellStyle();
			Sheet sheet = book.createSheet();
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue("test");
			out = new FileOutputStream(filePath);
			book.write(out);
		} catch (Exception e) {
			System.out.println("エラー発生");
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					System.out.println("クローズできませんでした。");
				}
			}
		}
	}
}
