package uiza.test.android.uiza_sdk_player_2_2_7.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import uiza.test.android.uiza_sdk_player_2_2_7.R;
import uiza.test.android.uiza_sdk_player_2_2_7.app.LSApplication;
import vn.loitp.core.base.BaseActivity;
import vn.loitp.core.common.Constants;
import vn.loitp.core.utilities.LLog;
import vn.loitp.restapi.restclient.RestClientV2;
import vn.loitp.restapi.uiza.UizaServiceV2;
import vn.loitp.restapi.uiza.model.v2.auth.Auth;
import vn.loitp.restapi.uiza.model.v2.auth.JsonBodyAuth;
import vn.loitp.rxandroid.ApiSubscriber;
import vn.loitp.uizavideov3.util.UizaUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authV2();
        findViewById(R.id.bt_test_cast_ad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, CustomSkinActivity.class);
                startActivity(intent);
            }
        });
    }

    private void authV2() {
        LLog.d(TAG, "authV2");
        UizaServiceV2 service = RestClientV2.createService(UizaServiceV2.class);
        /*String accessKeyId = Constants.A_K_DEV;
        String secretKeyId = Constants.S_K_DEV;*/
        String accessKeyId = Constants.A_K_UQC;
        String secretKeyId = Constants.S_K_UQC;

        JsonBodyAuth jsonBodyAuth = new JsonBodyAuth();
        jsonBodyAuth.setAccessKeyId(accessKeyId);
        jsonBodyAuth.setSecretKeyId(secretKeyId);

        subscribe(service.auth(jsonBodyAuth), new ApiSubscriber<Auth>() {
            @Override
            public void onSuccess(Auth auth) {
                LLog.d(TAG, "authV2 onSuccess");
                UizaUtil.setAuth(activity, auth, LSApplication.getInstance().getGson());
                RestClientV2.addAuthorization(auth.getData().getToken());
            }

            @Override
            public void onFail(Throwable e) {
                LLog.e(TAG, "auth onFail " + e.getMessage());
            }
        });
    }

    @Override
    protected boolean setFullScreen() {
        return false;
    }

    @Override
    protected String setTag() {
        return getClass().getSimpleName();
    }

    @Override
    protected int setLayoutResourceId() {
        return R.layout.activity_main;
    }
}
