package khm.kaunghtetmyint.burpple.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import khm.kaunghtetmyint.burpple.data.vo.FavFoodPlacesVO;
import khm.kaunghtetmyint.burpple.data.vo.FavFoodVO;
import khm.kaunghtetmyint.burpple.data.vo.LoginUserVO;

/**
 * Created by User on 1/25/2018.
 */

public class LoginResponse {
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LoginUserVO getLoginUser() {
        return loginUser;
    }

    public List<FavFoodVO> getFavFood() {
        return favFood;
    }

    public List<FavFoodPlacesVO> getFavFoodPlaces() {
        return favFoodPlaces;
    }

    private int code;
    private String message;

    @SerializedName("login_user")
    private LoginUserVO loginUser;

    @SerializedName("fav_foods")
    private List<FavFoodVO> favFood;

    @SerializedName("fav_food_places")
    private List<FavFoodPlacesVO> favFoodPlaces;

}
