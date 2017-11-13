package cn.jwg.materialdesgin.core.ui.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.WindowManager;
import cn.jwg.materialdesgin.core.utils.interceptor.TokenAuthenticator;
import com.blankj.utilcode.util.Utils;
import com.facebook.stetho.Stetho;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okhttp3.OkHttpClient;
import org.greenrobot.greendao.query.QueryBuilder;


/**
 * Created by Juwuguo on 2017/8/17.
 */

public class BaseApplication extends Application {
    private static Context sContext;
    private static BaseApplication sInstance;
    public static int SCREEN_WIDTH;
    private static int APP_ACTIVITY_COUNT = 0;//当前打开的页面的个数

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;

        Utils.init(this);

        init();

        initOkGo();

        initActivityLifecycleCallbacks();
    }

    private void init() {
        sContext = getApplicationContext();
        sInstance = this;
        ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point screen = new Point();
        SCREEN_WIDTH = Math.min(screen.x, screen.y);
    }

    public static Context getContext() {
        if (sContext == null) {
            throw new NullPointerException("APP Context is Null");
        }
        return sContext;
    }

    public static BaseApplication getInstance() {
        if (sInstance == null) {
            throw new NullPointerException("APP sInstance is Null");
        }
        return sInstance;
    }


    /**
     * OkGo
     */
    private void initOkGo() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.WARNING);
        builder.addInterceptor(loggingInterceptor);

        //拦截器
        builder.authenticator(new TokenAuthenticator());

        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", "application/x-www-form-urlencoded");

        //超时时间设置，默认60秒
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);      //全局的读取超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);     //全局的写入超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);   //全局的连接超时时间

        //自动管理cookie（或者叫session的保持），以下几种任选其一就行
        //builder.cookieJar(new CookieJarImpl(new SPCookieStore(this)));            //使用sp保持cookie，如果cookie不过期，则一直有效
        builder.cookieJar(new CookieJarImpl(new DBCookieStore(this)));              //使用数据库保持cookie，如果cookie不过期，则一直有效
        //builder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));            //使用内存保持cookie，app退出后，cookie消失

        //信任所有证书
        HttpsUtils.SSLParams sslParams1 = HttpsUtils.getSslSocketFactory();
        builder.sslSocketFactory(sslParams1.sSLSocketFactory, sslParams1.trustManager);

        OkGo.getInstance().init(this)                               //必须调用初始化
                .setOkHttpClient(builder.build())                   //建议设置OkHttpClient，不设置会使用默认的
                .setCacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)   //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)       //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(3)                                   //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonHeaders(headers);                         //全局公共头


    }




    /**
     * 页面的关闭状态
     */
    private void initActivityLifecycleCallbacks() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            @Override
            public void onActivityStopped(Activity activity) {
                APP_ACTIVITY_COUNT--;
                if (APP_ACTIVITY_COUNT == 0) {
                    // 切到后台

                }
            }

            @Override
            public void onActivityStarted(Activity activity) {
                if (APP_ACTIVITY_COUNT == 0) {
                    // 切到前台

                }
                APP_ACTIVITY_COUNT++;
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }
        });
    }
}
