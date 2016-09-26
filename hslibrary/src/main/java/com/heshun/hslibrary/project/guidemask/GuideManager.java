package com.heshun.hslibrary.project.guidemask;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;

import com.heshun.hslibrary.R;


public abstract class GuideManager {

	private static final String TAG = "heshun_guide";

	public static final int TYPE_LIST = 0;//首页扫码

	private Activity mActivity;
	private SharedPreferences sp;
	private GuideLayout mGuideLayout;
	private int mType;

	public GuideManager(Activity activity, int type) {
		mGuideLayout = new GuideLayout(activity);
		sp = activity.getSharedPreferences(TAG, Activity.MODE_PRIVATE);
		mActivity = activity;
		mType = type;
	}

	public GuideManager addView(View view, int shape) {
		mGuideLayout.addHighLightView(view, shape);
		return this;
	}



	public void show() {
		SharedPreferences.Editor editor = sp.edit();
		editor.putBoolean(TAG + mType, false);
		editor.apply();
		switch (mType) {
			case TYPE_LIST:
				makeMask(R.drawable.left_arrow,20,50,150,"点击可以切换到不同地区");
				break;
		}
	}

	public void makeMask(int imgId, int imgX, int imgY, int textY,String content) {
		mGuideLayout.setEveryWhereTouchable(false).addIndicateImg(imgId, ScreenUtils.dpToPx(mActivity, imgX), ScreenUtils.dpToPx(mActivity,
				imgY)).addMsgAndKnowTv(content, ScreenUtils.dpToPx(mActivity, textY)).show();
	}

	public void showWithListener( GuideLayout.OnGuideChangedListener onGuideChangedListener) {
		mGuideLayout.setOnGuideChangedListener(onGuideChangedListener);
		show();
	}

	/**
	 * 判断新手引导也是否已经显示了
	 * true显示
	 */
	public static boolean isNeedShowed(Activity activity, int type) {

		return activity.getSharedPreferences(TAG, Activity.MODE_PRIVATE).getBoolean(TAG + type, true);
	}


}
