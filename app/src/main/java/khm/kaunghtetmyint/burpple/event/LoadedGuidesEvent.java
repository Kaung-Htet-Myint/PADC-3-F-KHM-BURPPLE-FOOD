package khm.kaunghtetmyint.burpple.event;

import java.util.List;

import khm.kaunghtetmyint.burpple.data.vo.GuidesVO;

/**
 * Created by User on 1/15/2018.
 */

public class LoadedGuidesEvent {
    private List<GuidesVO> guidesList;

    public List<GuidesVO> getGuidesList() {
        return guidesList;
    }

    public LoadedGuidesEvent(List<GuidesVO> guidesList) {
        this.guidesList = guidesList;
    }
}
