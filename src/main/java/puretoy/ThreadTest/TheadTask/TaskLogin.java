package puretoy.ThreadTest.TheadTask;

/**
 * Created by kingb on 2018/5/31.
 */
public class TaskLogin {
    private String refUserId;
    private String loginStatue;
    private String uName;
    private String uPwd;

    public String getRefUserId() {
        return refUserId;
    }

    public void setRefUserId(String refUserId) {
        this.refUserId = refUserId;
    }

    public String getLoginStatue() {
        return loginStatue;
    }

    public void setLoginStatue(String loginStatue) {
        this.loginStatue = loginStatue;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public void verifyLogin(){
        System.out.println("第一步，用户初始化认证……");
        return;
    }


}
