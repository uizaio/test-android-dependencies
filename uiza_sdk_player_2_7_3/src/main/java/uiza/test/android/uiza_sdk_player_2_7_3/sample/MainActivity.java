package uiza.test.android.uiza_sdk_player_2_7_3.sample;

import android.content.Intent;
import android.os.Bundle;
import uiza.test.android.uiza_sdk_player_2_7_3.R;
import uiza.test.android.uiza_sdk_player_2_7_3.app.LSApplication;
import vn.uiza.core.base.BaseActivity;
import vn.uiza.core.common.Constants;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.bt_test_cast_ad).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CustomSkinXMLActivity.class);
            intent.putExtra(Constants.KEY_UIZA_ENTITY_ID, LSApplication.entityIdDefaultVOD);
            startActivity(intent);
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
