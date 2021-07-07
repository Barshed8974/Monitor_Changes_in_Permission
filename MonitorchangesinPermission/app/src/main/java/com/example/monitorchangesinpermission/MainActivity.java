package com.example.monitorchangesinpermission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mbtn;
    private static int REQ_CODE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn=findViewById(R.id.btnRequestPermission);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String []permission={Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION};
                ActivityCompat.requestPermissions(MainActivity.this,permission,REQ_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED&&grantResults[1]==PackageManager.PERMISSION_GRANTED)
        {
            shown("Location permission granted");
        }
        else if(grantResults[0]== PackageManager.PERMISSION_GRANTED&&grantResults[1]==PackageManager.PERMISSION_DENIED)
        {
            shown("Storage Permission Granted");
        }
        else if(grantResults[0]== PackageManager.PERMISSION_DENIED&&grantResults[1]==PackageManager.PERMISSION_GRANTED)
        {
            shown("Both Are Accepted");
        }
        else
        {
            shown("both denied");
        }
    }
    public void shown(String massage)
    {
        Toast.makeText(this,massage,Toast.LENGTH_SHORT).show();
    }
}