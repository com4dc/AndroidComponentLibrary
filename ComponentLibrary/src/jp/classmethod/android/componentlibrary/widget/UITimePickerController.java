package jp.classmethod.android.componentlibrary.widget;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jp.classmethod.android.componentlibrary.exception.IllegalNumberException;

/**
 * TimePickerをSDKバージョンに依らずに操作するためのControllerクラス. <br>
 * @author komuro
 *
 */
public abstract class UITimePickerController {
	
	/** 分計算用MAX定数(60分) */
	protected static final int MINUTES_MAX = 60;
	
	/** 選択肢の単位 */
	protected int unit = 1;
	
	/** 最後の選択肢のIndex */
	protected int maxIdx = MINUTES_MAX - 1;
	
	/**
	 * 何分ごとに表示するか
	 * @param unit minutes
	 */
	public void setIncrementTimeUnit(int unit) throws IllegalNumberException {
		if(MINUTES_MAX % unit != 0 || unit > 30) {
			throw new IllegalNumberException();
		}
		this.unit = unit;
	}
	
	/**
	 * TimePickerをもろもろ上書き. インスタンス生成後に呼ぶ
	 * @param picker
	 * @param calendar
	 */
	public abstract void overrideTimePicker(UITimePicker picker, Calendar calendar);

	/**
	 * 選択肢Itemを作成する
	 * @param unit 何分ごと
	 * @return 選択肢ItemのString List
	 */
	protected static String[] createMinItems(int unit) {
		List<String> itemList = new ArrayList<String>();
		// 選択肢の数
		int itemLength = MINUTES_MAX / unit;
		for(int i=0; i<itemLength; i++) {
			int num = i * unit;
			if(num < 10) {
				itemList.add("0" + String.valueOf(num));
			} else {
				itemList.add(String.valueOf(num));
			}
		}
		return itemList.toArray(new String[0]);
	}
	
	/**
	 * Indexの最大値を返す
	 * @return
	 */
	public int getItemLength() {
		return MINUTES_MAX / unit;
	}

	public void overrideTimePicker(UITimePicker picker) {
		// TODO Auto-generated method stub
		
	}
	
}
