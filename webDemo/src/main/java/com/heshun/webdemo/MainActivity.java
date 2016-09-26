package com.heshun.webdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.heshun.hslibrary.common.http.HttpConnection;
import com.heshun.hslibrary.common.http.ResultHandler;


public class MainActivity extends AppCompatActivity {
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv= (TextView) findViewById(R.id.tv);
	}

	@Override
	protected void onResume() {
		super.onResume();
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... params) {
				JSONObject jo = new JSONObject();
				jo.put("mobile", "15062385492");
				jo.put("pwd", "333333");
				HttpConnection.getConnection().httpPostViaJson("member/login", jo, mHandler);
				return null;
			}
		}.execute();


	}

	ResultHandler mHandler = new ResultHandler() {
		@Override
		protected void onSuccess(String response) {
			JSONObject jsonObject = JSONObject.parseObject(response);
			String body = jsonObject.getString("body");
			UserBean userBean = JSON.parseObject(body, UserBean.class);
			tv.setText(userBean.getNickName());
		}
	};
}
