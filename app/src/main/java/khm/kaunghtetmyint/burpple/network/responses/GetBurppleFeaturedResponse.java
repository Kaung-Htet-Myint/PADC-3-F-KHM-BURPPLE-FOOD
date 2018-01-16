package khm.kaunghtetmyint.burpple.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import khm.kaunghtetmyint.burpple.data.vo.FeaturedVO;

/**
 * Created by User on 1/15/2018.
 */

public class GetBurppleFeaturedResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<FeaturedVO> featured;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<FeaturedVO> getFeatured() {
        return featured;
    }
}
