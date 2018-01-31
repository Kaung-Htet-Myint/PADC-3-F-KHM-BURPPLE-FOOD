package khm.kaunghtetmyint.burpple.data.models;

import org.greenrobot.eventbus.EventBus;

import khm.kaunghtetmyint.burpple.network.RetrofitDataAgent;

/**
 * Created by User on 1/26/2018.
 */

public class SignUpModel {

    private static SignUpModel objInstance;

    private SignUpModel() {

    }

    public static SignUpModel getObjInstance(){
        if(objInstance == null){
            objInstance = new SignUpModel();
        }
        return objInstance;
    }

    public void SignUpUser(String name,String phoneNo,String pasword){

    }
}
