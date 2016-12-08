package com.study.zefeng.fileuploaddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText filePath;
    private Button upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filePath = (EditText)findViewById(R.id.file_path);
        upload = (Button)findViewById(R.id.upload);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        String requestURL = "http://123.207.233.232/api/upload/image";
                        String path = filePath.getText().toString();
                        File file = new File(path);
                        Log.i("upload", "file exists:" + file.exists());
                        if (file.exists()) {
                            Map<String, String> params = new HashMap<>();

                            String request = UploadUtil.uploadFile(file, requestURL, "CoffeeRhythm=\"CoffeeRhythm-zefengsysu@gmail.com-4c5e1c3262adce2995618e4356af2ad3344bf3c3\"", params, "image");

                            Log.i("upload", request);
                        }
                    }
                }.start();
            }
        });
    }
}
