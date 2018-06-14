package dialersms.xiake.com.dialersmsapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import dialersms.xiake.com.dialersmsapp.R;
import dialersms.xiake.com.dialersmsapp.base.BaseFragment;

/**
 * Created by Administrator on 2018/6/13.
 */

public class FragmentFour extends BaseFragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = View.inflate(getActivity(), R.layout.fragment_one, null);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

}
