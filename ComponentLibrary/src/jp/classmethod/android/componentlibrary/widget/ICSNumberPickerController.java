package jp.classmethod.android.componentlibrary.widget;

import java.lang.reflect.Field;
import java.util.Calendar;


import android.annotation.TargetApi;
import android.os.Build;
import android.widget.NumberPicker;
import android.widget.TimePicker;

/**
 * ICS以降のNumberPickerの操作を行うクラス
 * @author komuro
 *
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ICSNumberPickerController extends UITimePickerController {

	@Override
	public void overrideTimePicker(UITimePicker picker, Calendar calendar) {
		try {
			Field f = TimePicker.class.getDeclaredField("mMinuteSpinner");
			f.setAccessible(true);
			
			NumberPicker numberPicker = (NumberPicker)f.get(picker);
			String[] items = createMinItems(unit);
			maxIdx = items.length - 1;
			numberPicker.setMinValue(0);
			numberPicker.setMaxValue(maxIdx);
			numberPicker.setDisplayedValues(items);
			numberPicker.setWrapSelectorWheel(true);
			
			// TODO: Minutes変更時にHourが追随するようにNumberPicker.onValueChangedListenerの設定が必要
			picker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
			picker.setCurrentMinute(calendar.get(Calendar.MINUTE));
			
			// 編集不可
			picker.setDescendantFocusability(TimePicker.FOCUS_BLOCK_DESCENDANTS);
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
	
}
