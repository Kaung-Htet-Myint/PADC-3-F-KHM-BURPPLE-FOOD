package khm.kaunghtetmyint.burpple.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import khm.kaunghtetmyint.burpple.R;
import khm.kaunghtetmyint.burpple.fragments.LoginFragment;
import khm.kaunghtetmyint.burpple.fragments.RegisterFragment;

/**
 * Created by User on 1/24/2018.
 */

public class AccountControlsActivity extends AppCompatActivity {

    private static final String IE_SCREEN_TYPE = "IE_SCREEN_TYPE";
    private static final int SCREEN_TYPE_LOGIN = 1;
    private static final int SCREEN_TYPE_SIGN_UP = 2;

    public static Intent newIntentLogin(Context context){
        Intent intent = new Intent(context,AccountControlsActivity.class);
        intent.putExtra(IE_SCREEN_TYPE,SCREEN_TYPE_LOGIN);
        return intent;
    }

    public static Intent newIntentSignUp(Context context){
        Intent intent = new Intent(context,AccountControlsActivity.class);
        intent.putExtra(IE_SCREEN_TYPE,SCREEN_TYPE_SIGN_UP);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_controls);

        int screenType = getIntent().getIntExtra(IE_SCREEN_TYPE, -1);

        if (screenType == SCREEN_TYPE_LOGIN) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, new LoginFragment())
                    .commit();
        } else if (screenType == SCREEN_TYPE_SIGN_UP) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, new RegisterFragment())
                    .commit();
        }
    }
}