package mysqldao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
	
    //创建数据库 这里也可以只保留一个上下文参数
	//不然每次调用的时候都会传四个参数
	public MyHelper(Context context) {
		super(context, "login.db", null, 6);
	}
	//安卓默认的主键是"_id",当然也可以写"id"
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table login(_id integer primary key autoincrement,username varchar(20),password varchar(20))");
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}
