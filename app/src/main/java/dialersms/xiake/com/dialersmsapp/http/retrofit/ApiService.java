package dialersms.xiake.com.dialersmsapp.http.retrofit;


import dialersms.xiake.com.dialersmsapp.been.phoneContact.customer_level.GetPhoneContactLevelsRes;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by helin on 2016/10/9 17:09.
 *
 * http数据请求的
 */

public interface ApiService {

    //客户等级列表 API（接口）
    @POST("PhoneContact/GetPhoneContactLevels")
    Observable<GetPhoneContactLevelsRes> getPhoneContactsCompanys(@Body RequestBody body);
}
