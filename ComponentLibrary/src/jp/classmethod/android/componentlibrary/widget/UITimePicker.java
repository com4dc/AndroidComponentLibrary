package jp.classmethod.android.componentlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TimePicker;

/**
 * Custom TimePicker
 * @author komuro
 *
 */
public class UITimePicker extends TimePicker {
	
	public UITimePicker(Context context) {
		super(context);
	}
	
	public UITimePicker(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public UITimePicker(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
	}
}
