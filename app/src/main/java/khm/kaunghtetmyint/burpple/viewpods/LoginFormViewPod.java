package khm.kaunghtetmyint.burpple.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import khm.kaunghtetmyint.burpple.R;
import khm.kaunghtetmyint.burpple.data.vo.LoginUserVO;
import khm.kaunghtetmyint.burpple.delegates.LoginUserDelegate;

/**
 * Created by User on 1/24/2018.
 */

public class LoginFormViewPod extends RelativeLayout {

    private LoginUserDelegate mDelegate;

    public LoginFormViewPod(Context context) {
        super(context);
    }

    public LoginFormViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginFormViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDelegate(LoginUserDelegate loginUserDelegate){
        mDelegate = loginUserDelegate;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);

    }

    public void bindData(LoginUserVO loginUser){
        String phoneNo = loginUser.getPhoneNo().toString();
        String profileUrl = loginUser.getProfileUrl().toString();
        String coverUrl = loginUser.getCoverUrl().toString();
        String name = loginUser.getName().toString();
        String email = loginUser.getEmail().toString();

    }

    @OnClick(R.id.btn_logout)
    public void onTapLogout(View view){
        mDelegate.onTapLayout();
    }

}
