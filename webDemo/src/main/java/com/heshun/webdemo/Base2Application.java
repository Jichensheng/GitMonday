package com.heshun.webdemo;

import android.app.Application;

import com.heshun.hslibrary.common.config.BaseApplication;


/**
 * author：Jics
 * 2016/9/20 17:34
 */
public class Base2Application extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		new BaseApplication(this).onCreate();
	}
}
