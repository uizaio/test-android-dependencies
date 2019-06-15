package uiza.test.android.uiza_sdk_player_1_4_2.app;

import android.support.multidex.MultiDexApplication;
import com.google.gson.Gson;
import vn.loitp.core.common.Constants;
import vn.loitp.restapi.restclient.RestClientTracking;
import vn.loitp.restapi.restclient.RestClientV2;
import vn.loitp.uizavideov3.view.util.UizaDataV3;
import vn.loitp.utils.util.Utils;

public class LSApplication extends MultiDexApplication {
    private static LSApplication instance;
    private Gson gson;
    public static final String DF_DOMAIN_API = "loctbprod01.uiza.co";
    public static final String DF_TOKEN = "uap-9816792bb84642f09d843af4f93fb748-b94fcbd1";
    public static final String DF_APP_ID = "9816792bb84642f09d843af4f93fb748";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (gson == null) {
            gson = new Gson();
        }
        Utils.init(this);

        RestClientV2.init(Constants.URL_DEV_UIZA_VERSION_2_STAG);
        RestClientTracking.init(Constants.URL_TRACKING_STAG);
        UizaDataV3.getInstance().setCurrentPlayerId(Constants.PLAYER_ID_SKIN_1);
        UizaDataV3.getInstance().initSDK(DF_DOMAIN_API, DF_TOKEN, DF_APP_ID, Constants.ENVIRONMENT_PROD);
    }

    public Gson getGson() {
        return gson;
    }

    public static LSApplication getInstance() {
        return instance;
    }
}
