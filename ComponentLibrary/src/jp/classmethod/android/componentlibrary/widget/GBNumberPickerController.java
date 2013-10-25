package jp.classmethod.android.componentlibrary.widget;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GBNumberPickerController {

	public static void setNumberPickerConfig(Field f, ExTimePicker picker) {
		try {
			Object numberPicker = f.get(picker);
			Class<?>[] args = {
				int.class,
				int.class,
				String[].class
			};
			Class<?> clazz = Class.forName("android.widget.NumberPicker");
			Method m = clazz.getDeclaredMethod("setRange", args);
			
			Object[] params = {
				0,
				3, 
				createItems()
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
