package jp.classmethod.android.componentlibrary.widget;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import android.widget.TimePicker;

public class GBNumberPickerController extends UITimePickerController {

	@Override
	public void overrideTimePicker(UITimePicker picker) {
		try {
			Field f = TimePicker.class.getDeclaredField("mMinutePicker");
			f.setAccessible(true);
			Object numberPicker = f.get(picker);
			Class<?>[] args = {
				int.class,
				int.class,
				String[].class
			};
			Class<?> clazz = Class.forName("android.widget.NumberPicker");
			Method m = clazz.getDeclaredMethod("setRange", args);
			
			String[] items = createMinItems(unit);
			maxIdx = items.length - 1;
			
			Object[] params = {
				0,
				maxIdx, 
				items
			};
			m.invoke(numberPicker, params);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}
