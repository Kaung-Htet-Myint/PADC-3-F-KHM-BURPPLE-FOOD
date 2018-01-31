package khm.kaunghtetmyint.burpple.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import khm.kaunghtetmyint.burpple.R;
import khm.kaunghtetmyint.burpple.data.models.LoginModel;
import khm.kaunghtetmyint.burpple.event.SuccessLoginEvent;

/**
 * Created by User on 1/23/2018.
 */

public class LoginFragment extends Fragment {

    @BindView(R.id.et_mobile_or_email)
    EditText etMobileOrEmail;

    @BindView(R.id.et_password)
    EditText etPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.btn_login)
    public void onTapLogin(View view) {
        String phoneNo = etMobileOrEmail.getText().toString();
        String password = etPassword.getText().toString();
        LoginModel.getObjInstance().loginUser(phoneNo, password);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
