/**
 * Copyright 2018 bejson.com
 */
package dialersms.xiake.com.dialersmsapp.been.phoneContact.customer_level;
import java.util.List;

/**
 * Auto-generated: 2018-06-14 12:24:13
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class GetPhoneContactLevelsRes {

    private int Code;
    private String New_Token;
    private String Message;

    private String PageInfo;
    private List<Levels> Levels;
    public void setLevels(List<Levels> Levels) {
        this.Levels = Levels;
    }
    public List<Levels> getLevels() {
        return Levels;
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