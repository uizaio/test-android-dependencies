package uiza.test.android.uiza_sdk_player_2_2_7.app;

/**
 * Created by MinhNguyen on 15/06/2019.
 * nguyen.thanh.minhb@framgia.com
 */
import android.support.multidex.MultiDexApplication;

import com.google.gson.Gson;

import vn.loitp.core.common.Constants;
import vn.loitp.restapi.restclient.RestClientTracking;
import vn.loitp.restapi.restclient.RestClientV2;
import vn.loitp.uizavideov3.util.UizaUtil;

public class LSApplication extends MultiDexApplication {
    private static LSApplication instance;
    private Gson gson;

    //workspace prod
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

        UizaUtil.initWorkspace(this, DF_DOMAIN_API, DF_TOKEN, DF_APP_ID);
    }

    public Gson getGson() {
        return gson;
    }

    public static LSApplication getInstance() {
        return instance;
    }
}
