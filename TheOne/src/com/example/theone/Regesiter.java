package com.example.theone;

import java.util.ArrayList;
import java.util.List;

import mysqldao.LoginBean;
import mysqldao.LoginDao;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
 * 注册的操作类，相当于向数据库中插入一条数据
 */

public class Regesiter extends Activity {
	public String mUsernanme;
	public String mPassword;
	public EditText name_edit;
	public EditText pass_edit;
	public Button btn;
	
	public LoginDao dao;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regesiter);
		name_edit =(EditText) findViewById(R.id.youname_id_regesite);
		pass_edit =(EditText) findViewById(R.id.password_num_regesite);
		btn=(Button) findViewById(R.id.masure_regesite);
	}
	public void makesure(View v)
	{
		dao =new LoginDao(this);
		//从键盘中获取输入的信息
		mUsernanme  = name_edit.getText().toString();
		mPassword = pass_edit.getText().toString();
		//创建Bean的实例对象
		LoginBean bean = new LoginBean();
		//通过set方法将值存放进去
		bean.setUsername(mUsernanme);
	    bean.setPassword(mPassword);	
		dao.myInsert(bean);
		System.out.println(dao.myInsert(bean));
		Toast.makeText(this, "注册成功", 0).show();
		//注册成功，跳转回到登录界面
			Intent intent = new Intent(Regesiter.this, MainActivity.class);
			startActivity(intent);
			finish();
	}
	
}
