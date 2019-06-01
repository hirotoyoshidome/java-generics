/**
 * 
 */
package sample.shift;

/**
 * @author H.Yoshi
 *
 */
public class SampleShift {

	public static void main(String[] args) {
		Byte a = 1;
		a = (byte) (a << 1); // 左へ1ビット移動(シフトして空いた右端の部分は0で埋められる)
		System.out.println(a);

		Byte b = 1;
		b = (byte) (b >> 1);
		System.out.println(b); // 右へ1ビット移動(符号あり)(シフトして空いた左端の部分は左端の最上位ビットと同様の符号で埋められる(0 : 正 , 1 : 負))

		Byte c = 1;
		c = (byte) (c >>> 1); // 右へ1ビット移動（符号なし）(シフトして空いた左端の部分は0で埋められる)
		System.out.println(c);

		Byte bit = 0x0F; // 16進数で表記 15 2進数で表現すると[00000000]から[11111111]を表現
		System.out.println(bit); // 0x00から0xFFまで 0-255
		Byte bit2 = (byte) 0xF3; // -13 0xで始めると16進数で表現できる
		System.out.println(bit2);
		Byte bit3 = -1;
		short bitMax = (short) bit3; // 通常の0xFFでは8ビット部分が符号として読み取られてしまうため-を先に設定する
		bitMax &= 0xFF; // &演算子はbooleanを判定している(この場合-1が先に代入されているため0xFFがマイナスの場合代移入される)
		// bit3で代入された値が1だったら0xFFは代入されないため1が出力される
		System.out.println(bitMax); // 255

		System.out.println(bitMax);

		bitMax = (short) ~bitMax;
		System.out.println(bitMax); // ビット反転を行ったため先頭に1が追加されたため符号が逆になる
		// ちなみに& (AND) | (OR) ^ (XOR)(排他的論理和)

		Byte target = (byte) 00000110; // 8進数で表される 64 + 8 （数値の先頭を0で始めると8進数で表現する）
		System.out.println(target); // 72
		Byte leftShift = (byte) (target << 3);
		System.out.println(leftShift); // 64

		Byte rightShift = (byte) (target >> 3);
		System.out.println(rightShift); // 9

		int target2 = 50;
		System.out.println("2進数 : " + Integer.toBinaryString(target2));
		System.out.println("8進数 : " + Integer.toOctalString(target2));
		System.out.println("16進数 : " + Integer.toHexString(target2));

		// 2進数で表現する場合
		String target3 = "00111111";
		System.out.println(Integer.parseInt(target3, 2)); // 2進数から10進数に変換
	}

}
