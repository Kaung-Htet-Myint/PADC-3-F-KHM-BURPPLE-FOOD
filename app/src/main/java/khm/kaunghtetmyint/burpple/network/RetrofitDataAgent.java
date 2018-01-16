package khm.kaunghtetmyint.burpple.network;

import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import khm.kaunghtetmyint.burpple.event.LoadedFeaturedEvent;
import khm.kaunghtetmyint.burpple.event.LoadedGuidesEvent;
import khm.kaunghtetmyint.burpple.event.LoadedPromotionsEvent;
import khm.kaunghtetmyint.burpple.network.responses.GetBurppleFeaturedResponse;
import khm.kaunghtetmyint.burpple.network.responses.GetBurppleGuidesResponse;
import khm.kaunghtetmyint.burpple.network.responses.GetBurpplePromotionsResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 1/16/2018.
 */

public class RetrofitDataAgent implements BurppleDataAgent{

    private static RetrofitDataAgent sObjectInstance;

    private BurppleApi mBurppleApi;

    private RetrofitDataAgent(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().
                connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        mBurppleApi = retrofit.create(BurppleApi.class);
    }

    public static RetrofitDataAgent getsObjectInstance(){
        if(sObjectInstance == null){
            sObjectInstance = new RetrofitDataAgent();
        }
        return sObjectInstance;
    }


    @Override
    public void loadBurppleFeatures() {
        Call<GetBurppleFeaturedResponse> getBurppleFeaturedResponseCall = mBurppleApi.loadFeatured(1,"b002c7e1a528b7cb460933fc2875e916");
        getBurppleFeaturedResponseCall.enqueue(new Callback<GetBurppleFeaturedResponse>() {
            @Override
            public void onResponse(Call<GetBurppleFeaturedResponse> call, Response<GetBurppleFeaturedResponse> response) {
                GetBurppleFeaturedResponse getBurppleFeaturedResponse = response.body();
                if(getBurppleFeaturedResponse != null){
                    LoadedFeaturedEvent event = new LoadedFeaturedEvent(getBurppleFeaturedResponse.getFeatured());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetBurppleFeaturedResponse> call, Throwable t) {
                Log.e("Reftofit:","Retrofit Network Call Failed.");
            }
        });
    }

    @Override
    public void loadBurpplePromotions() {
        Call<GetBurpplePromotionsResponse> getBurpplePromotionsResponseCall = mBurppleApi.loadPromotions(1,"b002c7e1a528b7cb460933fc2875e916");
        getBurpplePromotionsResponseCall.enqueue(new Callback<GetBurpplePromotionsResponse>() {
            @Override
            public void onResponse(Call<GetBurpplePromotionsResponse> call, Response<GetBurpplePromotionsResponse> response) {
                GetBurpplePromotionsResponse getBurpplePromotionsResponse = response.body();
                if(getBurpplePromotionsResponse != null){
                    LoadedPromotionsEvent event = new LoadedPromotionsEvent(getBurpplePromotionsResponse.getPromotions());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetBurpplePromotionsResponse> call, Throwable t) {
                Log.e("Reftofit:","Retrofit Network Call Failed.");
            }
        });
    }

    @Override
    public void loadBurppleGuides() {
        final Call<GetBurppleGuidesResponse> getBurppleGuidesResponseCall = mBurppleApi.loadGuides(1,"b002c7e1a528b7cb460933fc2875e916");
        getBurppleGuidesResponseCall.enqueue(new Callback<GetBurppleGuidesResponse>() {
            @Override
            public void onResponse(Call<GetBurppleGuidesResponse> call, Response<GetBurppleGuidesResponse> response) {
                GetBurppleGuidesResponse getBurpplePromotionsResponse = response.body();
                if(getBurppleGuidesResponseCall != null){
                    LoadedGuidesEvent event = new LoadedGuidesEvent(getBurpplePromotionsResponse.getGuides());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetBurppleGuidesResponse> call, Throwable t) {
                Log.e("Reftofit:","Retrofit Network Call Failed.");
            }
        });
    }
}
