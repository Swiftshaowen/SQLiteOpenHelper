package com.example.theone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mysqldao.LoginBean;
import mysqldao.LoginDao;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button mLogin_btn;//登录按钮
	private Button mRege_btn;//注册按钮
	private EditText mNumber_edt;//账号输入框
	private EditText mPassword_edt;//密码输入框
    public String  mUsername; //用户名
    public String  mPassword;//密码
	
	public LoginDao dao ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		innit();//控件的初始化
	}
	//控件的初始化
	public  void innit() {
		mLogin_btn = (Button) findViewById(R.id.login_id);
		mRege_btn = (Button) findViewById(R.id.regesite_id);
		mNumber_edt =(EditText) findViewById(R.id.youname_id);
		mPassword_edt = (EditText) findViewById(R.id.password_num);
	}
	//实现登录 登录的时候肯定要通过查询操作来获取密码和用户名是否匹配
	public void ask( View v1)
	{
		//获取输入框中的信息
		mUsername = mNumber_edt.getText().toString();
	     mPassword = mPassword_edt.getText().toString();
		 dao =new LoginDao(MainActivity.this);
		 //调用Dao类中的查询操作
		 boolean flag =dao.myQuery(mUsername, mPassword);
		 //如果查询成功的话跳转到成功的界面
		if(flag)
		{
			Toast.makeText(this, "登陆成功", 0).show();
			Intent intent  =new Intent(this, LoginSuecces.class);
			startActivity(intent);
			finish();
		}
		else 
		{
			Toast.makeText(this, "登录失败", 0).show();
		}
	}
	//实现注册的点击事件  跳转到另外一个注册的界面去
	public void regesit(View v2)
	{
		Intent intent = new Intent(this, Regesiter.class);
		startActivity(intent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
