package dialersms.xiake.com.dialersmsapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dialersms.xiake.com.dialersmsapp.R;
import dialersms.xiake.com.dialersmsapp.base.BaseFragment;

/**
 * Created by Administrator on 2018/6/13.
 */

public class FragmentOne extends BaseFragment{

    //使用getActivity， 可能导致Activity无法被回收
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        rootView = View.inflate(getActivity(), R.layout.fragment_one, null);

        return rootView;
    }

}
