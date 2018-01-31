package khm.kaunghtetmyint.burpple.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import khm.kaunghtetmyint.burpple.data.vo.LoginUserVO;
import khm.kaunghtetmyint.burpple.event.SuccessLoginEvent;
import khm.kaunghtetmyint.burpple.event.UserLogoutEvent;
import khm.kaunghtetmyint.burpple.network.BurppleDataAgent;
import khm.kaunghtetmyint.burpple.network.RetrofitDataAgent;

/**
 * Created by User on 1/25/2018.
 */

public class LoginModel {
    private static LoginModel objInstance;

    private BurppleDataAgent mDataAgent;

    private LoginUserVO mLoginUser;

    private LoginModel() {
        mDataAgent = RetrofitDataAgent.getsObjectInstance();

        EventBus.getDefault().register(this);
    }

    public static LoginModel getObjInstance(){
        if(objInstance == null){
            objInstance = new LoginModel();
        }
        return objInstance;
    }

    public void loginUser(String phoneNo,String password){
        mDataAgent.loginUser(phoneNo,password);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoginUserSuccess(SuccessLoginEvent event){
        mLoginUser = event.getLoginUser();
    }

    public boolean isUserLogin(){
        return mLoginUser!=null;
    }

    public void logout(){
        mLoginUser=null;
        UserLogoutEvent event=new UserLogoutEvent();
        EventBus.getDefault().post(event);
    }
}
