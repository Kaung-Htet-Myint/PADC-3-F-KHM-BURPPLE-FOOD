package khm.kaunghtetmyint.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 1/14/2018.
 */

public class PromotionVO {
    @SerializedName("burpple-promotion-id")
    private String burpplePromotionId;

    @SerializedName("burpple-promotion-image")
    private String burpplePromotionImage;

    @SerializedName("burpple-promotion-title")
    private String burpplePromotionTitle;

    @SerializedName("burpple-promotion-until")
    private String burpplePromotionUntitle;

    @SerializedName("burpple-promotion-shop")
    private BurpplePromotionShopVO burpplePromotionShop;

    @SerializedName("is-burpple-exclusive")
    private boolean isBurppleExclusive;

    @SerializedName("burpple-promotion-terms")
    private List<String> burpplePromotionTerms;

    public boolean isBurppleExclusive() {
        return isBurppleExclusive;
    }

    public List<String> getBurpplePromotionTerms() {
        return burpplePromotionTerms;
    }

    public String getBurpplePromotionId() {
        return burpplePromotionId;
    }

    public String getBurpplePromotionImage() {
        return burpplePromotionImage;
    }

    public String getBurpplePromotionTitle() {
        return burpplePromotionTitle;
    }

    public String getBurpplePromotionUntitle() {
        return burpplePromotionUntitle;
    }

    public BurpplePromotionShopVO getBurpplePromotionShop() {
        return burpplePromotionShop;
    }
}
