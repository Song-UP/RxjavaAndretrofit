package dialersms.xiake.com.dialersmsapp;

import android.app.Application;

import com.orhanobut.hawk.Hawk;

/**
 * Created by Administrator on 2018/6/14.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
    }
}
