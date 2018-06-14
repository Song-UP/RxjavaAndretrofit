package dialersms.xiake.com.dialersmsapp.base;

import android.support.v7.app.AppCompatActivity;

import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/6/13.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public Unbinder unbinder;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null){
            unbinder.unbind();
            unbinder = null;
        }
    }

}
