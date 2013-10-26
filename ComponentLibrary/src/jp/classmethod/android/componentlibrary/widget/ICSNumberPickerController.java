package jp.classmethod.android.componentlibrary.widget;

import java.lang.reflect.Field;

import android.annotation.TargetApi;
import android.os.Build;
import android.widget.NumberPicker;
import android.widget.TimePicker;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ICSNumberPickerController extends UITimePickerController {

	@Override
	public void setIncrementTimeUnit(int unit) {
		this.unit = unit;
	}

	@Override
	public void overrideTimePicker(UITimePicker picker) {
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
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
	
}
