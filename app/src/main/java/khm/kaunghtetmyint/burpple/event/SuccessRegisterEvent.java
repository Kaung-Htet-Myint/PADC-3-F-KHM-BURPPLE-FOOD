package khm.kaunghtetmyint.burpple.event;

import khm.kaunghtetmyint.burpple.data.vo.LoginUserVO;
import khm.kaunghtetmyint.burpple.data.vo.RegisterUserVO;

/**
 * Created by User on 1/26/2018.
 */

public class SuccessRegisterEvent {
    private RegisterUserVO registerUser;

    public RegisterUserVO getRegisterUser() {
        return registerUser;
    }

    public SuccessRegisterEvent(RegisterUserVO registerUser){
        this.registerUser = registerUser;
    }
}
