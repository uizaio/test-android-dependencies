package uiza.test.android.a.sample;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import uiza.test.android.a.R;
import uiza.test.android.a.app.LSApplication;
import vn.uiza.core.common.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_test_no_cast_no_ad).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CustomSkinXMLActivity.class);
            intent.putExtra(Constants.KEY_UIZA_ENTITY_ID, LSApplication.entityIdDefaultVOD);
            startActivity(intent);
        });

        if (LSApplication.DF_DOMAIN_API.equals("input")) {
            showDialogInitWorkspace();
        }
    }

    private void showDialogInitWorkspace() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please correct your workspace's information first..");
        builder.setCancelable(false);
        builder.setPositiveButton(
                "Yes",
                (dialog, id) -> {
                    dialog.cancel();
                    onBackPressed();
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
