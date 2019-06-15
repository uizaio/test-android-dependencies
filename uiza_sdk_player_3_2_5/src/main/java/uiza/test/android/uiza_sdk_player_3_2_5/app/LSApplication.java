package uiza.test.android.uiza_sdk_player_3_2_5.app;

import android.support.multidex.MultiDexApplication;
import uizacoresdk.util.UZUtil;
import vn.uiza.core.common.Constants;

public class LSApplication extends MultiDexApplication {

    public static final String DF_DOMAIN_API = "teamplayer.uiza.co";
    public static final String DF_TOKEN = "uap-01e137ad1b534004ad822035bf89b29f-b9b31f29";
    public static final String DF_APP_ID = "01e137ad1b534004ad822035bf89b29f";
    public static final String entityIdDefaultVOD = "7699e10e-5ce3-4dab-a5ad-a615a711101e";

    @Override
    public void onCreate() {
        super.onCreate();
        UZUtil.initWorkspace(this, DF_DOMAIN_API, DF_TOKEN, DF_APP_ID);
    }
}
