package dialersms.xiake.com.dialersmsapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import dialersms.xiake.com.dialersmsapp.R;
import dialersms.xiake.com.dialersmsapp.adapter.baseRc.BaseRCAdapter;
import dialersms.xiake.com.dialersmsapp.adapter.baseRc.BaseRCViewHold;
import dialersms.xiake.com.dialersmsapp.base.BaseFragment;
import dialersms.xiake.com.dialersmsapp.been.phoneContact.customer.GetPhoneContactsCompanysReq;
import dialersms.xiake.com.dialersmsapp.been.phoneContact.customer_level.GetPhoneContactLevelsRes;
import dialersms.xiake.com.dialersmsapp.been.phoneContact.customer_level.Levels;
import dialersms.xiake.com.dialersmsapp.http.retrofit.ActivityLifeCycleEvent;
import dialersms.xiake.com.dialersmsapp.http.retrofit.Api;
import dialersms.xiake.com.dialersmsapp.http.retrofit.HttpUtil;
import dialersms.xiake.com.dialersmsapp.http.retrofit.ProgressSubscriber;
import okhttp3.RequestBody;
import rx.Observable;
import utils.NetUtil;

/**
 * Created by Administrator on 2018/6/13.
 */

public class FragmentTwo extends BaseFragment{

    @BindView(R.id.recycleview) RecyclerView recycleview;
    BaseRCAdapter<Levels> rcAdapter;
    GetPhoneContactLevelsRes getPhoneContactsCompanysReq;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = View.inflate(getActivity(), R.layout.fragment_two, null);
        unbinder = ButterKnife.bind(this, rootView);

        initData();
        initView();
        return rootView;
    }

    public void initView(){
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        rcAdapter = new BaseRCAdapter<Levels>(getContext(),R.layout.item_fragement_two, null) {
            @Override
            public void onBindView(BaseRCViewHold holder, Levels data, int pos) {
                holder.setImageGlide(getContext(),R.id.iv_left, data.getLevelIconUrl(), R.drawable.ic_bar_home_selected);
//                holder.setText(R.id.iv_company, data.getLevelName());

            }
        };

        recycleview.setAdapter(rcAdapter);




    }



    public void initData(){
        GetPhoneContactsCompanysReq getPhoneContactsCompanysReq = new GetPhoneContactsCompanysReq(
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwaWQiOjEsInVpZCI6MSwidW5tIjoiYWRtaW4iLCJleHAiOjE1Mjk1NDUyNTYuMH0.txkzSJz6S1m6C8KqjVd2j3JtQPCVZ2_R5-nZHSBsWvM",
                "B858056F5A624CC2852EC3F87B61F9B1");

        RequestBody requestBody = NetUtil.getGsonRequestBody(getPhoneContactsCompanysReq);


        Observable ob = Api.getDefault().getPhoneContactsCompanys(requestBody);
                HttpUtil.getInstance().toSubscribe(ob, new ProgressSubscriber<GetPhoneContactLevelsRes>(getContext()) {
            @Override
            protected void _onError(String message) {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }

            @Override
            protected void _onNext(GetPhoneContactLevelsRes getPhoneContactsCompanys) {

            }
        }, "cacheKey", ActivityLifeCycleEvent.DESTROY, lifecycleSubject, false, false);



    }

}
