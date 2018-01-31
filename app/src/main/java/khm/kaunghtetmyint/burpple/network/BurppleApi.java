package khm.kaunghtetmyint.burpple.network;

import khm.kaunghtetmyint.burpple.network.responses.GetBurppleFeaturedResponse;
import khm.kaunghtetmyint.burpple.network.responses.GetBurppleGuidesResponse;
import khm.kaunghtetmyint.burpple.network.responses.GetBurpplePromotionsResponse;
import khm.kaunghtetmyint.burpple.network.responses.LoginResponse;
import khm.kaunghtetmyint.burpple.network.responses.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by User on 1/16/2018.
 */

public interface BurppleApi {
    @FormUrlEncoded
    @POST("getFeatured.php")
    Call<GetBurppleFeaturedResponse> loadFeatured(@Field("page") int page,
                                                  @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getPromotions.php")
    Call<GetBurpplePromotionsResponse> loadPromotions(@Field("page") int page,
                                                      @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getGuides.php")
    Call<GetBurppleGuidesResponse> loadGuides(@Field("page") int page,
                                              @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> LoginUser(@Field("phoneNo") String phoneNo,
                                  @Field("password") String password);

    Call<RegisterResponse> RegisterUser(@Field("name") String name,
                                        @Field("phoneNo") String phoneNo,
                                        @Field("password") String password);
}
