package jp.classmethod.android.componentlibrary.widget;

import java.lang.reflect.Field;

import android.os.Build;
import android.widget.TimePicker;

/**
 * TimePickerControllerをSDKバージョンによって切り替えるFactoryクラス
 * @author komuro
 *
 */
public class TimePickerControllerFactory {
	
	public UITimePickerController getTimePickerController() {
		if(Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
			return new ICSNumberPickerController();
		} else {
			return new GBNumberPickerController();
		}
	}
}
