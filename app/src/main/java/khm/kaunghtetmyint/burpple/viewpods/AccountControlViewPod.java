package khm.kaunghtetmyint.burpple.viewpods;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import khm.kaunghtetmyint.burpple.R;
import khm.kaunghtetmyint.burpple.data.models.LoginModel;
import khm.kaunghtetmyint.burpple.delegates.BeforeLoginDelegate;
import khm.kaunghtetmyint.burpple.delegates.LoginUserDelegate;
import khm.kaunghtetmyint.burpple.event.SuccessLoginEvent;
import khm.kaunghtetmyint.burpple.event.UserLogoutEvent;

/**
 * Created by User on 1/25/2018.
 */

public class AccountControlViewPod extends FrameLayout{
    @BindView(R.id.vp_login_form)
    LoginFormViewPod vpLoginForm;

    @BindView(R.id.vp_before_login)
    BeforeLoginViewPod vpBeforeLogin;

    public AccountControlViewPod(@NonNull Context context) {
        super(context);
    }

    private void refreshUserSession(){
        if(LoginModel.getObjInstance().isUserLogin()){
            vpBeforeLogin.setVisibility(View.GONE);
            vpLoginForm.setVisibility(View.VISIBLE);
        }else{
            vpBeforeLogin.setVisibility(View.VISIBLE);
            vpLoginForm.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
        refreshUserSession();

        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        vpBeforeLogin.setVisibility(View.GONE);
        vpLoginForm.setVisibility(View.VISIBLE);

        vpLoginForm.bindData(event.getLoginUser());
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDelegate(BeforeLoginDelegate beforeLoginDelegate){
        vpBeforeLogin.setDelegate(beforeLoginDelegate);
    }

    public void setDelegate(LoginUserDelegate loginUserDelegate){
        vpLoginForm.setDelegate(loginUserDelegate);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public  void onLogoutUser(UserLogoutEvent event){
        vpBeforeLogin.setVisibility(View.VISIBLE);
        vpLoginForm.setVisibility(View.GONE);
    }
}
