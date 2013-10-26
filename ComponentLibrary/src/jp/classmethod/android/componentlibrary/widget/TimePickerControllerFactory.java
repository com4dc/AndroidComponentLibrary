package jp.classmethod.android.componentlibrary.widget;

import android.os.Build;

/**
 * TimePickerControllerをSDKバージョンによって切り替えるFactoryクラス.
 * @author komuro
 *
 */
public class TimePickerControllerFactory {
	
	/**
	 * SDKバージョンに応じたTimePickerControllを生成して返す
	 * @return {@link UITimePickerController}
	 */
	public UITimePickerController getTimePickerController() {

		// GBを境界線にNumberPickerのクラス定義が異なるので、判定
		if(Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
			return new ICSNumberPickerController();
		} else {
			return new GBNumberPickerController();
		}
	}
}
