package uiza.test.android.uiza_sdk_player_3_0_3.app;

import android.support.multidex.MultiDexApplication;
import uizacoresdk.util.UZUtil;
import vn.uiza.core.common.Constants;
import vn.uiza.restapi.restclient.RestClientTracking;
import vn.uiza.restapi.restclient.RestClientV2;

public class LSApplication extends MultiDexApplication {

    public static final String DF_DOMAIN_API = "teamplayer.uiza.co";
    public static final String DF_TOKEN = "uap-01e137ad1b534004ad822035bf89b29f-b9b31f29";
    public static final String DF_APP_ID = "01e137ad1b534004ad822035bf89b29f";
    public static final String entityIdDefaultVOD = "7699e10e-5ce3-4dab-a5ad-a615a711101e";

    @Override
    public void onCreate() {
        super.onCreate();
        RestClientV2.init(Constants.URL_DEV_UIZA_VERSION_2_STAG);
        RestClientTracking.init(Constants.URL_TRACKING_STAG);
        UZUtil.initWorkspace(this, DF_DOMAIN_API, DF_TOKEN, DF_APP_ID);
    }
}
