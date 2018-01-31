package khm.kaunghtetmyint.burpple.viewpods;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import khm.kaunghtetmyint.burpple.R;
import khm.kaunghtetmyint.burpple.delegates.BeforeLoginDelegate;

/**
 * Created by User on 1/24/2018.
 */

public class BeforeLoginViewPod extends RelativeLayout {
    private BeforeLoginDelegate mDelegates;

    public BeforeLoginViewPod(Context context) {
        super(context);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDelegate(BeforeLoginDelegate delegate){
        mDelegates = delegate;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    @OnClick(R.id.btn_to_login)
    public void onTapToLogin(View view){
        mDelegates.onTapToLogin();
    }

    @OnClick(R.id.btn_to_sign_up)
    public void onTapToSignUp(View view){
        mDelegates.onTapSignUp();
    }
}
