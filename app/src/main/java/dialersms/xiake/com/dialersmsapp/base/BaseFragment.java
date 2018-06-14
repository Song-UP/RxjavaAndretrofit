package dialersms.xiake.com.dialersmsapp.base;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Unbinder;
import dialersms.xiake.com.dialersmsapp.http.retrofit.ActivityLifeCycleEvent;
import rx.subjects.PublishSubject;

/**
 * Created by Administrator on 2018/6/13.
 * 注意内存不足时，fragment的销毁，重建而重叠
 */

public class BaseFragment extends Fragment {

    public final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject = PublishSubject.create();

    protected View rootView;
    public Unbinder unbinder;


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
        if (rootView != null)
            ((ViewGroup)rootView.getParent()).removeView(rootView);
        unbinder.unbind();


    }
}
