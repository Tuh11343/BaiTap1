package com.example.android_baitap1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private TextView red,blue,yellow,green,white;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpComponents();
    }

    public void setUpComponents()
    {
        red=findViewById(R.id.red);
        blue=findViewById(R.id.blue);
        green=findViewById(R.id.green);
        yellow=findViewById(R.id.yellow);
        white=findViewById(R.id.white);
        seekBar=findViewById(R.id.seekbar);
        setTextViewBackgroundColor();
        seekbarHandle();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.itemLinearLayout:
                setContentView(R.layout.activity_main);
                setUpComponents();
                return true;
            case R.id.itemRelativeLayout:
                setContentView(R.layout.relative_layout);
                setUpComponents();
                return true;
            case R.id.itemTableLayout:
                setContentView(R.layout.table_layout);
                setUpComponents();
                return true;
            case R.id.itemMoreInfo:
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.dialog_title)
                        .setMessage(R.string.dialog_content)
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                                startActivity(browserIntent);
                            }
                        })
                        .setNegativeButton("No,thank you", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void seekbarHandle()
    {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                HandleColor linearLayoutView=new HandleColor(red,yellow,blue,white,green);
                linearLayoutView.setColorGradient(i);
                linearLayoutView.ChangeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setTextViewBackgroundColor()
    {
        red.setBackgroundColor(Color.RED);
        blue.setBackgroundColor(Color.BLUE);
        green.setBackgroundColor(Color.GREEN);
        yellow.setBackgroundColor(Color.YELLOW);
        white.setBackgroundColor(Color.WHITE);
    }
}