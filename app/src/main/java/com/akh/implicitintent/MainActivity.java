package com.akh.implicitintent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("KTU website");
        menu.add("Call Number");
        menu.add("View Map");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        Uri uri;
        switch (item.toString()){
            case "KTU website":
                Log.d("MainActivity","View Action");
                uri = Uri.parse("http://kyauksetu.edu.mm/");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                break;
            case "Call Number":
                uri = Uri.parse("tel:09798802184");
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(uri);
                break;
            case "View Map":
                uri = Uri.parse("geo:21.604339, 96.126451");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                break;
        }
        startActivity(intent);
        return true;
    }
}