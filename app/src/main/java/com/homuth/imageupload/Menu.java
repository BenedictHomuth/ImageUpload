package com.homuth.imageupload;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {
    private TextView tv_Menu;
    private Button btn_ChooseFile;
    private Button btn_UploadFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tv_Menu = findViewById(R.id.tv_menuText);
        btn_ChooseFile = findViewById(R.id.btn_ChooseFile);
        btn_UploadFile = findViewById(R.id.btn_UploadFile);

        btn_UploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btn_ChooseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ImageSelector.class);
                startActivity(intent);
            }
        });


    }
}
