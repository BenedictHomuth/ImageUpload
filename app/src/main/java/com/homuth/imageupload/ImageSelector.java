package com.homuth.imageupload;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URI;

public class ImageSelector extends AppCompatActivity {
    private ImageView profileImage;
    private Button btn_SelectFile;
    private TextView tv_FilePath;
    private static final int PICK_IMAGE = 1;
    Bitmap bm;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_selector);

        profileImage = findViewById(R.id.iv_ProfileImage);
        btn_SelectFile = findViewById(R.id.btn_ChooseFile);
        tv_FilePath = findViewById(R.id.tv_FilePath);

        btn_SelectFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery, "Select image"), PICK_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK){
            imageUri = data.getData();
            try {
                bm = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
            }catch (IOException e){
                e.printStackTrace();
            }

            profileImage.setImageBitmap(bm);
            tv_FilePath.setText(imageUri.toString());

        }
    }
}
