package uiza.test.android.uiza_sdk_player_2_4_0.app;

import android.support.multidex.MultiDexApplication;
import com.google.gson.Gson;
import vn.uiza.core.common.Constants;
import vn.uiza.restapi.restclient.RestClientTracking;
import vn.uiza.restapi.restclient.RestClientV2;
import vn.uiza.uzv3.util.UZUtil;

public class LSApplication extends MultiDexApplication {
    private static LSApplication instance;
    private Gson gson;

    private final String DF_DOMAIN_API = "loctbprod01.uiza.co";
    private final String DF_TOKEN = "uap-9816792bb84642f09d843af4f93fb748-b94fcbd1";
    private final String DF_APP_ID = "9816792bb84642f09d843af4f93fb748";
    public static String entityIdDefaultVOD = "fe0c0ba1-dc1c-4d1e-96dd-9c5558c104bf";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (gson == null) {
            gson = new Gson();
        }

        RestClientV2.init(Constants.URL_DEV_UIZA_VERSION_2_STAG);
        RestClientTracking.init(Constants.URL_TRACKING_STAG);

        UZUtil.initWorkspace(this, DF_DOMAIN_API, DF_TOKEN, DF_APP_ID);
    }

    public Gson getGson() {
        return gson;
    }

    public static LSApplication getInstance() {
        return instance;
    }
}
