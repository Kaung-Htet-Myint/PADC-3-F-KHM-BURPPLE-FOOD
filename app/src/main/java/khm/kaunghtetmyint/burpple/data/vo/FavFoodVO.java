package khm.kaunghtetmyint.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 1/25/2018.
 */

public class FavFoodVO {
    @SerializedName("favorite_food_id")
    private int favFoodId;
    private String title;
    private String photoUrl;

    public int getFavFoodId() {
        return favFoodId;
    }

    public String getTitle() {
        return title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }


}

