package ru.mirotvortsev.hidemysecret;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import com.huawei.agconnect.apms.APMS;
import com.huawei.agconnect.apms.custom.CustomTrace;

public class MainActivity extends Activity {

    private ArrayList<SecretNote> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomTrace customTrace = APMS.getInstance().createCustomTrace("testTrace");
        customTrace.start();
        customTrace.putProperty("login_success_times", "login_fail_times");
        customTrace.stop();
    }

    public void onClickStartApp(View view) {
        Button button = findViewById(R.id.button);
        Intent intent = new Intent(this, CreateNote.class);
        startActivity(intent);

    }
}