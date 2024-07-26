package fpt.huyntph.lap1.demo6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Demo6_2MainActivity extends AppCompatActivity {
    Button btnStart, btnStop, btnBackRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo62_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnBackRound = findViewById(R.id.demo62_btn_Background);
        btnStart = findViewById(R.id.demo62_btn_start);
        btnStop = findViewById(R.id.demo62_btn_stop);

        btnStart.setOnClickListener(v -> {
            startService(new Intent(Demo6_2MainActivity.this, ForcegroundService.class));
        });

        btnStop.setOnClickListener(v -> {
            stopService(new Intent(Demo6_2MainActivity.this, ForcegroundService.class));
        });

        btnBackRound.setOnClickListener(v -> {
            startService(new Intent(Demo6_2MainActivity.this, BackgroundService.class));
        });
    }
}
