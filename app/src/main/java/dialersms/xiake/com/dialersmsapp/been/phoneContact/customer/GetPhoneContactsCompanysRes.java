/**
 * Copyright 2018 bejson.com
 */
package dialersms.xiake.com.dialersmsapp.been.phoneContact.customer;
import java.util.List;

/**
 * Auto-generated: 2018-06-14 17:39:56
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class GetPhoneContactsCompanysRes {

    private List<CountsList> CountsList;
    private String PageInfo;
    private String New_Token;
    private int Code;
    private String Message;
    public void setCountsList(List<CountsList> CountsList) {
        this.CountsList = CountsList;
    }
    public List<CountsList> getCountsList() {
        return CountsList;
    }

    public void setPageInfo(String PageInfo) {
        this.PageInfo = PageInfo;
    }
    public String getPageInfo() {
        return PageInfo;
    }

    public void setNew_Token(String New_Token) {
        this.New_Token = New_Token;
    }
    public String getNew_Token() {
        return New_Token;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }
    public int getCode() {
        return Code;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
    public String getMessage() {
        return Message;
    }

}