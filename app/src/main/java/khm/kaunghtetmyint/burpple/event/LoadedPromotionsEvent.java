package khm.kaunghtetmyint.burpple.event;

import java.util.List;

import khm.kaunghtetmyint.burpple.data.vo.PromotionVO;

/**
 * Created by User on 1/15/2018.
 */

public class LoadedPromotionsEvent {
    private List<PromotionVO> promotionList;

    public List<PromotionVO> getPromotionList() {
        return promotionList;
    }

    public LoadedPromotionsEvent(List<PromotionVO> promotionList) {
        this.promotionList = promotionList;
    }
}
