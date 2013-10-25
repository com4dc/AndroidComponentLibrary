package jp.classmethod.android.componentlibrary.widget;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.widget.NumberPicker;

public class ICSNumberPickerController {

	
	public static void setNumberPickerConfig(Field f, ExTimePicker picker) {
		try {
			NumberPicker numberPicker = (NumberPicker)f.get(picker);
			numberPicker.setMinValue(0);
			numberPicker.setMaxValue(3);
			numberPicker.setDisplayedValues(createItems());
			numberPicker.setWrapSelectorWheel(true);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private static String[] createItems() {
		List<String> items = new ArrayList<String>();
		for(int i=0; i<4; i++) {
			items.add(String.valueOf(i*15));
		}
		
		String[] res = new String[items.size()];
		int idx = 0;
		for(String val : items) {
			res[idx++] = val;
		}
		
		return res;
	}
	
}
