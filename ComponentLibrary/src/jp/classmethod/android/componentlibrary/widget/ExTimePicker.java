package jp.classmethod.android.componentlibrary.widget;

import java.lang.reflect.Field;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TimePicker;

public class ExTimePicker extends TimePicker {
	
	/** 最大値 */
	private static final int TIME_MAX = 60;
	
	public ExTimePicker(Context context) {
		super(context);
	}
	
	public ExTimePicker(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	private int mIncrementUnit = 1;

	public ExTimePicker(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		try {
			if(Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
				Field f = TimePicker.class.getDeclaredField("mMinuteSpinner");
				f.setAccessible(true);
				ICSNumberPickerController.setNumberPickerConfig(f, this);
			} else {
				Field f = TimePicker.class.getDeclaredField("mMinutePicker");
				f.setAccessible(true);
				GBNumberPickerController.setNumberPickerConfig(f, this);
			}
			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 
	}
	
	private int getMax() {
		return (TIME_MAX / mIncrementUnit - 1);
	}

}
