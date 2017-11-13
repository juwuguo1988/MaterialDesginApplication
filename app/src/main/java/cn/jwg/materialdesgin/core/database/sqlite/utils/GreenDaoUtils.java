package cn.jwg.materialdesgin.core.database.sqlite.utils;

import android.database.sqlite.SQLiteDatabase;
import cn.jwg.materialdesgin.core.database.sqlite.context.DatabaseContext;
import cn.jwg.materialdesgin.core.database.sqlite.greendao.DaoMaster;
import cn.jwg.materialdesgin.core.database.sqlite.greendao.DaoSession;
import cn.jwg.materialdesgin.core.ui.base.BaseApplication;
import cn.jwg.materialdesgin.core.utils.config.AppConfig;


public class GreenDaoUtils {

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private static GreenDaoUtils greenDaoUtils;

    private GreenDaoUtils() {
    }

    public static GreenDaoUtils getSingleTon() {
      /*  if (greenDaoUtils == null) {
            synchronized (GreenDaoUtils.class) {
                if (greenDaoUtils == null) {
                    greenDaoUtils = new GreenDaoUtils();
                }
            }
        }*/
        greenDaoUtils = new GreenDaoUtils();
        return greenDaoUtils;
    }

    private void initGreenDao() {
        DatabaseContext databaseContext = new DatabaseContext(BaseApplication.getContext());
        mHelper = new DaoMaster.DevOpenHelper(databaseContext, AppConfig.DATABASE_NAME, null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        if (mDaoMaster == null) {
            initGreenDao();
        }
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        if (db == null) {
            initGreenDao();
        }
        return db;
    }

}
