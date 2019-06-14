package uiza.test.android.dependencies.app;

import android.support.multidex.MultiDexApplication;

import uizacoresdk.util.UZUtil;
import vn.uiza.core.common.Constants;

public class LSApplication extends MultiDexApplication {

    public static final String DF_DOMAIN_API = "ap-southeast-1-api.uiza.co";
    public static final String DF_TOKEN = "uap-f785bc511967473fbe6048ee5fb7ea59-69fefb79";
    public static final String DF_APP_ID = "f785bc511967473fbe6048ee5fb7ea59";
    public static final String entityIdDefaultVOD = "33812ed9-4b02-408d-aab4-e77c12d16bb0";

    @Override
    public void onCreate() {
        super.onCreate();
        Constants.setDebugMode(true);
        int apiVersion = Constants.API_VERSION_4;
        UZUtil.initWorkspace(this, apiVersion, DF_DOMAIN_API, DF_TOKEN, DF_APP_ID, Constants.ENVIRONMENT_PROD, uizacoresdk.R.layout.uz_player_skin_0);
    }
}
