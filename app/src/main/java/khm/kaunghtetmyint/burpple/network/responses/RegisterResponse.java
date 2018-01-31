package khm.kaunghtetmyint.burpple.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import khm.kaunghtetmyint.burpple.data.vo.FavFoodPlacesVO;
import khm.kaunghtetmyint.burpple.data.vo.FavFoodVO;
import khm.kaunghtetmyint.burpple.data.vo.RegisterUserVO;

/**
 * Created by User on 1/25/2018.
 */

public class RegisterResponse {
    private int code;
    private String message;

    @SerializedName("register_user")
    private RegisterUserVO registerUser;

    @SerializedName("fav_foods")
    private List<FavFoodVO> favFood;

    @SerializedName("fav_food_places")
    private List<FavFoodPlacesVO> favFoodPlaces;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public RegisterUserVO getRegisterUser() {
        return registerUser;
    }

    public List<FavFoodVO> getFavFood() {
        return favFood;
    }

    public List<FavFoodPlacesVO> getFavFoodPlaces() {
        return favFoodPlaces;
    }
}
