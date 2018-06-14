package dialersms.xiake.com.dialersmsapp.been.phoneContact.customer;

/**
 * Created by Administrator on 2018/6/14.
 */

public class GetPhoneContactsCompanysReq {
    private String Token;
    private String DeviceUuid;

    public GetPhoneContactsCompanysReq(String token, String deviceUuid) {
        Token = token;
        DeviceUuid = deviceUuid;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getDeviceUuid() {
        return DeviceUuid;
    }

    public void setDeviceUuid(String deviceUuid) {
        DeviceUuid = deviceUuid;
    }
}
