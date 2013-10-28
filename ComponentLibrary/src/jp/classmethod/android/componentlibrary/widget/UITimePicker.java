package jp.classmethod.android.componentlibrary.widget;

import jp.classmethod.android.componentlibrary.R;
import jp.classmethod.android.componentlibrary.exception.IllegalNumberException;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TimePicker;

/**
 * Custom TimePicker Widget<br>
 * 指定された分ごとの選択肢を表示します. <br>
 * <ul>
 * <li>xmlで指定する場合は、カスタム属性を追加します. <br>
 * 	<strong>宣言：</strong>jp.classmethod.android.componentlibrary.widget.UITimePicker <br>
 * 	<strong>名前空間：</strong>xmlns:app="http://schemas.android.com/apk/res-auto" <br>
 * 	<strong>属性値指定：</strong>app:unit="10" <br>
 * </li>
 * <li>コード上で指定する場合は、overrideTimePicker を自分で呼び出す必要があります<br>
 * 	<strong>手順１：</strong>setIncrementTimeUnit()で何分ごとにするかを指定する<br>
 * 	<strong>手順２：</strong>overrideTimePicker()でTimePickerの描画を上書き
 * </li>
 * </ul>
 * 
 * @author komuro
 *
 */
public class UITimePicker extends TimePicker {
	
	private TimePickerControllerFactory factory = new TimePickerControllerFactory();
	
	private UITimePickerController timePickerController;
	
	/**
	 * Constructor
	 * @param context {@link Context}
	 */
	public UITimePicker(Context context) {
		this(context, null);
	}
	
	/**
	 * Constructor
	 * @param context {@link Context}
	 * @param attrs {@link AttributeSet}
	 */
	public UITimePicker(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	@Override
	public Integer getCurrentMinute() {
		// 選択している値を返します
		int selectIdx = super.getCurrentMinute();
		if(timePickerController == null) {
			return selectIdx;
		}
		int min = selectIdx * timePickerController.unit;
		return min;
	}

	/**
	 * Constructor
	 * @param context {@link Context}
	 * @param attrs {@link AttributeSet}
	 * @param defStyle 
	 */
	public UITimePicker(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		// TimePickerを上書き
		timePickerController = factory.getTimePickerController();
		if(attrs != null) {
			// 属性値を読み込む
			TypedArray attrArray=context.obtainStyledAttributes(attrs,R.styleable.UITimePicker);
			int unit=attrArray.getInt(R.styleable.UITimePicker_unit, 1); // ここで取得！
			try {
				timePickerController.setIncrementTimeUnit(unit);
			} catch (IllegalNumberException e) {
				e.printStackTrace();
			}
			attrArray.recycle();
		}
		// 上書き
		timePickerController.overrideTimePicker(this);
	}
}
