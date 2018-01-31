package khm.kaunghtetmyint.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 1/25/2018.
 */

public class FavFoodPlacesVO {
    @SerializedName("favorite_food_place_id")
    private int favFoodPlaceId;
    private String title;
    private String address;
    private String photoUrl;

    public int getFavFoodPlaceId() {
        return favFoodPlaceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }


}
