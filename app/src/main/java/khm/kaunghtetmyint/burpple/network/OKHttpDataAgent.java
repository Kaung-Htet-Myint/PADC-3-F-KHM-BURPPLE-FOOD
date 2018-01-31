package khm.kaunghtetmyint.burpple.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import khm.kaunghtetmyint.burpple.BurppleFoodApp;
import khm.kaunghtetmyint.burpple.event.LoadedFeaturedEvent;
import khm.kaunghtetmyint.burpple.event.LoadedGuidesEvent;
import khm.kaunghtetmyint.burpple.event.LoadedPromotionsEvent;
import khm.kaunghtetmyint.burpple.network.responses.GetBurppleFeaturedResponse;
import khm.kaunghtetmyint.burpple.network.responses.GetBurppleGuidesResponse;
import khm.kaunghtetmyint.burpple.network.responses.GetBurpplePromotionsResponse;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by User on 1/15/2018.
 */

public class OKHttpDataAgent implements BurppleDataAgent{
    private static OKHttpDataAgent sObjInstance;

    private OKHttpDataAgent(){

    }

    public static OKHttpDataAgent getsObjInstance(){
        if(sObjInstance == null){
            sObjInstance = new OKHttpDataAgent();
        }
        return sObjInstance;
    }

    @Override
    public void loadBurppleFeatures() {
        new LoadBurppleFoodsTask().execute("http://padcmyanmar.com/padc-3/mm-news/apis/v1/getFeatured.php","F");
    }

    @Override
    public void loadBurpplePromotions() {
        new LoadBurppleFoodsTask().execute("http://padcmyanmar.com/padc-3/mm-news/apis/v1/getPromotions.php","P");
    }

    @Override
    public void loadBurppleGuides() {
        new LoadBurppleFoodsTask().execute("http://padcmyanmar.com/padc-3/mm-news/apis/v1/getGuides.php","G");
    }

    @Override
    public void loginUser(String phoneNo,String password) {

    }

    @Override
    public void RegisterUser(String name, String phoneNo, String password) {

    }


    private static class LoadBurppleFoodsTask extends AsyncTask<String,Void,String>{
        private String burppleType="";
        @Override
        protected String doInBackground(String... urls) {
            String url = urls[0];
            burppleType = urls[1];
            OkHttpClient okHttpClient = new OkHttpClient.Builder().
                    connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15,TimeUnit.SECONDS)
                    .readTimeout(60,TimeUnit.SECONDS)
                    .build();

            //2
            RequestBody formbody = new FormBody.Builder()
                    .add("access_token", "b002c7e1a528b7cb460933fc2875e916")
                    .add("page", "1")
                    .build();

            //3
            Request request = new Request.Builder()
                    .url(url)
                    .post(formbody)
                    .build();

            //4
            String responseString = null;
            try {
                Response response = okHttpClient.newCall(request).execute();
                if (response.isSuccessful() && response.body() != null){
                    responseString = response.body().string();
                    return responseString;
                }
            }catch (IOException e){
                Log.e(BurppleFoodApp.LOG_TAG,e.getMessage());
            }

            return responseString;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            Gson gson = new Gson();

            if(burppleType.equalsIgnoreCase("F")) {
                GetBurppleFeaturedResponse getBurppleFeaturedResponse = gson.fromJson(response, GetBurppleFeaturedResponse.class);
                LoadedFeaturedEvent featuredEvent = new LoadedFeaturedEvent(getBurppleFeaturedResponse.getFeatured());
                EventBus eventBus = EventBus.getDefault();
                eventBus.post(featuredEvent);

            }else if(burppleType.equalsIgnoreCase("P")) {
                GetBurpplePromotionsResponse getBurpplePromoResponse = gson.fromJson(response, GetBurpplePromotionsResponse.class);
                LoadedPromotionsEvent promotionsEvent = new LoadedPromotionsEvent(getBurpplePromoResponse.getPromotions());
                EventBus eventBus = EventBus.getDefault();
                eventBus.post(promotionsEvent);

            } else  if(burppleType.equalsIgnoreCase("G")) {
                GetBurppleGuidesResponse getBurppleGuidesResponse = gson.fromJson(response, GetBurppleGuidesResponse.class);
                LoadedGuidesEvent loadedGuidesEvent = new LoadedGuidesEvent(getBurppleGuidesResponse.getGuides());
                EventBus eventBus = EventBus.getDefault();
                eventBus.post(loadedGuidesEvent);
            }



        }
    }
}
