package khm.kaunghtetmyint.burpple.event;

import khm.kaunghtetmyint.burpple.data.vo.LoginUserVO;

/**
 * Created by User on 1/25/2018.
 */

public class SuccessLoginEvent {
    private LoginUserVO loginUser;

    public LoginUserVO getLoginUser() {
        return loginUser;
    }

    public SuccessLoginEvent(LoginUserVO loginUser){
        this.loginUser = loginUser;
    }
}
