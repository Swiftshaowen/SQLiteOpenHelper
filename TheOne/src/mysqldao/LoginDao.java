package mysqldao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/*
 * 数据库的操作类 ：增加数据   查询数据
 */

public class LoginDao {
	
	public MyHelper myhelper;
	public LoginDao(Context context) {
		//创建数据库的实例对象  并且建立表名为login.db
		myhelper =new MyHelper(context);
	}
	
	
	//接下来就可以执行对数据库的操作
	
	//查询操作
	public boolean myQuery(String username,String password){
		//操作数据库的实例对象
		SQLiteDatabase db = myhelper.getReadableDatabase();
		Cursor c = db.rawQuery("select * from login where username=? and password=?", new String[]{username,password});
		if(c.moveToFirst()==true)
		{
			//不为空的Cursor，说明有结果集，也就是查询成功
			c.close();
            return true;
		}
		return false;
	}
	//注册的时候还需要一个向数据库插入数据的操作
	//增加一条数据
	//增加用户的数据
	public  boolean myInsert(LoginBean bean)
	{
		
		SQLiteDatabase db = myhelper.getReadableDatabase();
		db.execSQL("insert into login(username,password) values(?,?)", new Object[]{bean.getUsername(),bean.getPassword()});
		return true;
	}
}
