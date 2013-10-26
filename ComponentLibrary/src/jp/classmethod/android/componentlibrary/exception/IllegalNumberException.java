package jp.classmethod.android.componentlibrary.exception;

/**
 * Unitの値が不正な場合にThrowされる例外クラス
 * @author komuro
 *
 */
public class IllegalNumberException extends Exception {

	/** SerialUID */
	private static final long serialVersionUID = 8781964837820519885L;

	@Override
	public String getMessage() {
		String message = "60が割り切れる値かつ30位下の値を指定してください. ";
		return message;
	}
	
	
}
