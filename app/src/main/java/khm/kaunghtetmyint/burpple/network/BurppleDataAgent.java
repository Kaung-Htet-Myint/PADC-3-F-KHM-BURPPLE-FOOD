package khm.kaunghtetmyint.burpple.network;

/**
 * Created by User on 1/15/2018.
 */

public interface BurppleDataAgent {
        void loadBurppleFeatures();
        void loadBurpplePromotions();
        void loadBurppleGuides();

        void loginUser(String phoneNo, String password);
        void RegisterUser(String name,String phoneNo,String password);
}
