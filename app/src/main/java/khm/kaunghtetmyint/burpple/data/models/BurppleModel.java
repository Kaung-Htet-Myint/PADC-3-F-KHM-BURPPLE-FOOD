package khm.kaunghtetmyint.burpple.data.models;

import khm.kaunghtetmyint.burpple.network.BurppleDataAgent;
import khm.kaunghtetmyint.burpple.network.OKHttpDataAgent;
import khm.kaunghtetmyint.burpple.network.RetrofitDataAgent;
import okhttp3.OkHttpClient;

/**
 * Created by User on 1/14/2018.
 */

public class BurppleModel {

    private static  BurppleModel sObjInstance;
    private BurppleDataAgent mDataAgent;

    private BurppleModel(){
        //mDataAgent = OKHttpDataAgent.getsObjInstance();
        mDataAgent = RetrofitDataAgent.getsObjectInstance();
    }

    public static BurppleModel getsObjInstance(){
        if(sObjInstance == null){
            sObjInstance = new BurppleModel();
        }
        return sObjInstance;
    }

    public void loadBurppleFeatures(){
        mDataAgent.loadBurppleFeatures();
    }

    public void loadBurppleGuides() {
        mDataAgent.loadBurppleGuides();
    }

    public void loadBurpplePromotions(){
        mDataAgent.loadBurpplePromotions();
    }

}
