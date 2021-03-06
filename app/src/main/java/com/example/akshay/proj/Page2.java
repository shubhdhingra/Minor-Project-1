package com.example.akshay.proj;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.akshay.proj.wifi.Home_Screen;

public class Page2 extends Activity {
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        Toast.makeText(getApplicationContext(),"TURN ON WIFI FOR Share/Chat",Toast.LENGTH_LONG).show();

        Switch toggle = (Switch) findViewById(R.id.wifi_switch);
        WifiManager wifiManager1 = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        if(wifiManager1.isWifiEnabled()) {
            toggle.setChecked(true);
        }

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggleWiFi(true);
                    Toast.makeText(getApplicationContext(), "Wi-Fi Enabled!", Toast.LENGTH_LONG).show();
                } else {
                    toggleWiFi(false);
                    Toast.makeText(getApplicationContext(), "Wi-Fi Disabled!", Toast.LENGTH_LONG).show();
                }
            }
        });
        click1();
    }
    public void toggleWiFi(boolean status) {
        WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        if (status == true && !wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        } else if (status == false && wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);
        }
    }


    public void click1()
    {
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i1=new Intent("com.example.akshay.proj.WiFiDirectActivity");
                startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i2 = new Intent("com.example.akshay.proj.MainScreenActivity");
                startActivity(i2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1=new Intent(Page2.this,Home_Screen.class);
                startActivity(i1);
            }
        });
    }
}
