/**
 * 
 */
package sample.enum_;

/**
 * <h1>Enumの使用方法</h1>
 * <ul>
 * <li>get系は自分で定義したメソッド</li>
 * <li>ordinalは列挙された順に番号を出力する</li>
 * </ul>
 * 
 * @author H.Yoshi
 *
 */
public class UseEnum {
	public static void main(String[] args) {
		Type type = Type.TYPE1;
		System.out.println(type); // TYPE1
		System.out.println(type.getText()); // 1
		System.out.println(type.getNum()); // 1
		System.out.println(type.ordinal()); // 0

		Type type2 = Type.TYPE2;
		System.out.println(type2); // TYPE2
		System.out.println(type2.getText()); // 2
		System.out.println(type2.getNum()); // 2
		System.out.println(type2.ordinal()); // 1

		Type type3 = Type.TYPE3;
		System.out.println(type3.ordinal()); // 2
	}
}
