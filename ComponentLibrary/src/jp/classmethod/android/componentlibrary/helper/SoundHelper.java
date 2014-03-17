package jp.classmethod.android.componentlibrary.helper;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

public final class SoundHelper {
	
	private static SoundPool soundPool;

	/**
	 * SoundPoolにLoadして、再生する
	 * @param context {@link Context}
	 * @param resId 鳴らす音声のResource ID
	 */
	public static final void playSound(Context context, int resId) {
		soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		final int soundId = soundPool.load(context, resId, 1);
		soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
			
			@Override
			public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
				soundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f);
			}
		});
	}
}
