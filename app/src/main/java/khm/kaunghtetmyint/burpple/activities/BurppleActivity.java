package khm.kaunghtetmyint.burpple.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import khm.kaunghtetmyint.burpple.BurppleFoodApp;
import khm.kaunghtetmyint.burpple.R;
import khm.kaunghtetmyint.burpple.adpaters.BurppleGuidesAdapter;
import khm.kaunghtetmyint.burpple.adpaters.BurpplePromotionsAdpater;
import khm.kaunghtetmyint.burpple.adpaters.ImageInBurppleAdapter;;
import khm.kaunghtetmyint.burpple.data.models.BurppleModel;
import khm.kaunghtetmyint.burpple.data.models.LoginModel;
import khm.kaunghtetmyint.burpple.delegates.BeforeLoginDelegate;
import khm.kaunghtetmyint.burpple.delegates.BurppleActionDelegates;
import khm.kaunghtetmyint.burpple.delegates.LoginUserDelegate;
import khm.kaunghtetmyint.burpple.event.LoadedFeaturedEvent;
import khm.kaunghtetmyint.burpple.event.LoadedGuidesEvent;
import khm.kaunghtetmyint.burpple.event.LoadedPromotionsEvent;
import khm.kaunghtetmyint.burpple.viewpods.AccountControlViewPod;
import khm.kaunghtetmyint.burpple.viewpods.BeforeLoginViewPod;

/**
 * Created by User on 1/4/2018.
 */

public class BurppleActivity extends AppCompatActivity implements BurppleActionDelegates,BeforeLoginDelegate,LoginUserDelegate{

    @BindView(R.id.vp_burpple_food_background_img)
    ViewPager vpBurppleFoodBackgroundImg;

    @BindView(R.id.rv_burpple_promotions)
    RecyclerView rvBurpplePromotions;

    @BindView(R.id.rv_burpple_guides)
    RecyclerView getRvBurppleGuides;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fl_search)
    FrameLayout flSearch;

    private ImageInBurppleAdapter mBurppleAdapter;
    private BurpplePromotionsAdpater mBurpplePromotionsAdapter;
    private BurppleGuidesAdapter mBurppleGuidesAdapter;
    private BeforeLoginViewPod vpBeforeLogin;
    private AccountControlViewPod vpAccountControl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_burpple);

        ButterKnife.bind(this,this);

        mBurppleAdapter = new ImageInBurppleAdapter();
        vpBurppleFoodBackgroundImg.setAdapter(mBurppleAdapter);

        mBurpplePromotionsAdapter = new BurpplePromotionsAdpater();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager
        (getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvBurpplePromotions.setLayoutManager(linearLayoutManager);
        rvBurpplePromotions.setAdapter(mBurpplePromotionsAdapter);

        mBurppleGuidesAdapter = new BurppleGuidesAdapter();
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager
        (getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        getRvBurppleGuides.setLayoutManager(linearLayoutManager1);
        getRvBurppleGuides.setAdapter(mBurppleGuidesAdapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);

                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

        vpAccountControl = (AccountControlViewPod) navigationView.getHeaderView(0);
        vpAccountControl.setDelegate((BeforeLoginDelegate) this);
        vpAccountControl.setDelegate((LoginUserDelegate) this);

        //setSupportActionBar(toolbar);

        BurppleModel.getsObjInstance().loadBurppleFeatures();
    //    BurppleModel.getsObjInstance().loadBurpplePromotions();
    //    BurppleModel.getsObjInstance().loadBurppleGuides();
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPromotionLoaded(LoadedPromotionsEvent promotionsEvent){
        Log.d(BurppleFoodApp.LOG_TAG, "onFeaturedLoaded :"+promotionsEvent.getPromotionList().size());
        mBurpplePromotionsAdapter.setData(promotionsEvent.getPromotionList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGuidesLoaded(LoadedGuidesEvent guidesEvent){
        Log.d(BurppleFoodApp.LOG_TAG, "onFeaturedLoaded :"+guidesEvent.getGuidesList().size());
        mBurppleGuidesAdapter.setData(guidesEvent.getGuidesList());
    }

    @Override
    public void onTapToLogin() {
        Intent intent = AccountControlsActivity.newIntentLogin(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapSignUp() {
        Intent intent = AccountControlsActivity.newIntentSignUp(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapLayout() {
        LoginModel.getObjInstance().logout();
    }

    @Override
    public void onTapBurppleGuide() {

    }

    @Override
    public void onTapPromotions() {

    }

    @Override
    public void onTapNewAndTrending() {

    }

    @Override
    public void onTapFoodPlaces() {

    }
}
