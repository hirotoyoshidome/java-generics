/**
 * 
 */
package sample.enum_;

/**
 * <h1>Enumの列挙</h1>
 * <ul>
 * <li>引数はコンストラクタによって変わる</li>
 * <li>列挙したものはインスタンスを生成することで使用できる</li>
 * </ul>
 * 
 * @author H.Yoshi
 *
 */
public enum Type {
	/** type1 */
	TYPE1("1", 1),
	/** type2 */
	TYPE2("2", 2),
	/** type3 */
	TYPE3("3", 3);
	private final String text;
	private final int num;

	/**
	 * <ul>
	 * <li>コンストラクタで設定した値がenumで設定できる値となる</li>
	 * <li>裏でenumの列挙型に指定された引数がコンストラクタで設定されたインスタンスが生成される</li>
	 * </ul>
	 * 
	 * @param text
	 * @param num
	 */
	private Type(final String text, final int num) {
		this.text = text;
		this.num = num;
	}

	public String getText() {
		return this.text;
	}

	public int getNum() {
		return this.num;
	}
}
