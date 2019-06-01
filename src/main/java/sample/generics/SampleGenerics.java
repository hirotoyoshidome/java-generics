/**
 * 
 */
package sample.generics;

import java.util.List;

/**
 * <h1>ジェネリクスの使用方法</h1>
 * <p>
 * ジェネリクスヲ使用することで多態性（ポリモーフィズム）を利用して宣言可能
 * </p>
 * <ul>
 * <li>クラス宣言でジェネリクスの宣言をする</li>
 * <li>extends Classを使用することでそのクラスを継承したものをジェネリクスとして指定可能</li>
 * <li>Eの部分に?を指定することで非境界ワイルドカードとなり何にでも設定可能</li>
 * </ul>
 * 
 * @author H.Yoshi
 * @param <E>
 *
 */
public class SampleGenerics<E> {
	List<E> list; // 指定されたE(ジェネリクス)
	List<?> list2; // 何でもよい
	List<? extends E> list3; // Eを継承しているのも
	List<? extends Number> list4; // Numberを継承しているもの
}
