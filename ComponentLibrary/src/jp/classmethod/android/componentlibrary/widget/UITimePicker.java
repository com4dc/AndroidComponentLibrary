package jp.classmethod.android.componentlibrary.widget;

import jp.classmethod.android.componentlibrary.R;
import jp.classmethod.android.componentlibrary.exception.IllegalNumberException;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TimePicker;

/**
 * Custom TimePicker Widget<br>
 * 何分ごとの選択肢を表示します. 
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
		int min = selectIdx * timePickerController.unit;
		return min;
	}

	/**
	 * Constructor
	 * @param context
	 * @param attrs
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
