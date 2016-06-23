package com.example.theone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/*
 * 登录成功之后进入的界面
 */
public class LoginSuecces extends Activity {
	public TextView  mtext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginsucess);
		mtext = (TextView) findViewById(R.id.success);
	}
	

}
