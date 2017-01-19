package com.test.bubenivanov.mytestproj;

import android.app.Activity;
import android.app.MediaRouteActionProvider;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class CameraCompass extends Activity {
Button button;

    static final int cam_request=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_compass);

        button=(Button) findViewById(R.id.capture);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file=getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(file));
                startActivityForResult(camera_intent,cam_request);


            }
        });


    }
    private File getFile()
    {
        File folder=new File("sdcard/camera_app");
    if(!folder.exists())

    {folder.mkdir();}

        File image_file=new File(folder,"cam_image.jpg");
        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path="sdcard/camera_app/cam_image.jpg";

    }
}
