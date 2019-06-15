package uiza.test.android.uiza_sdk_player_1_4_2.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import uiza.test.android.uiza_sdk_player_1_4_2.R;
import uiza.test.android.uiza_sdk_player_1_4_2.app.LSApplication;
import vn.loitp.core.base.BaseActivity;
import vn.loitp.core.common.Constants;
import vn.loitp.core.utilities.LLog;
import vn.loitp.core.utilities.LPref;
import vn.loitp.restapi.restclient.RestClientV2;
import vn.loitp.restapi.restclient.RestClientV3;
import vn.loitp.restapi.uiza.UizaServiceV2;
import vn.loitp.restapi.uiza.UizaServiceV3;
import vn.loitp.restapi.uiza.model.v2.auth.Auth;
import vn.loitp.restapi.uiza.model.v2.auth.JsonBodyAuth;
import vn.loitp.restapi.uiza.model.v3.UizaWorkspaceInfo;
import vn.loitp.restapi.uiza.model.v3.authentication.gettoken.ResultGetToken;
import vn.loitp.restapi.uiza.util.UizaV3Util;
import vn.loitp.rxandroid.ApiSubscriber;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        authV2();
        authV3();

        findViewById(R.id.bt_test_cast_ad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(activity, V3CannotSlidePlayerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void authV2() {
        UizaServiceV2 service = RestClientV2.createService(UizaServiceV2.class);
        String accessKeyId = Constants.A_K_UQC;
        String secretKeyId = Constants.S_K_UQC;

        JsonBodyAuth jsonBodyAuth = new JsonBodyAuth();
        jsonBodyAuth.setAccessKeyId(accessKeyId);
        jsonBodyAuth.setSecretKeyId(secretKeyId);

        subscribe(service.auth(jsonBodyAuth), new ApiSubscriber<Auth>() {
            @Override
            public void onSuccess(Auth auth) {
                LPref.setAuth(activity, auth, LSApplication.getInstance().getGson());
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

    private void authV3() {
        UizaServiceV3 service = RestClientV3.createService(UizaServiceV3.class);
        UizaWorkspaceInfo uizaWorkspaceInfo = UizaV3Util.getUizaWorkspace(activity);
        if (uizaWorkspaceInfo == null) {
            return;
        }
        subscribe(service.getToken(uizaWorkspaceInfo), new ApiSubscriber<ResultGetToken>() {
            @Override
            public void onSuccess(ResultGetToken resultGetToken) {
                String token = resultGetToken.getData().getToken();
                RestClientV3.addAuthorization(token);
            }

            @Override
            public void onFail(Throwable e) {
                LLog.e(TAG, "auth onFail " + e.getMessage());
            }
        });
    }
}
