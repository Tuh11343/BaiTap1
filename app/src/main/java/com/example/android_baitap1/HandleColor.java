package com.example.android_baitap1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Random;

public class HandleColor {
    private Paint mPaint=new Paint();

    private TextView txtRed;
    private TextView txtYellow;
    private TextView txtBlue;
    private TextView txtWhite;
    private TextView txtGreen;

    public HandleColor(TextView txtRed, TextView txtYellow, TextView txtBlue, TextView txtWhite, TextView txtGreen) {
        this.txtRed = txtRed;
        this.txtYellow = txtYellow;
        this.txtBlue = txtBlue;
        this.txtWhite = txtWhite;
        this.txtGreen = txtGreen;
    }

    private int mColorGradient=0;
    public void setColorGradient(int value)
    {
        mColorGradient=value;
    }

    public void ChangeColor()
    {
        int[] redArray = {255, 0, 0};
        int[] blueArray = {0, 0, 255};
        int[] yellowArray = {255, 255, 0};
        int[] greenArray={0,255,10};
        int[] whiteArray={255,255,255};

        redArray[0] = redArray[0] - (255 / 100) * mColorGradient;
        redArray[1] = redArray[1] + (229 / 100) * mColorGradient;
        redArray[2] = redArray[2] + (238 / 100) * mColorGradient;
        blueArray[0] = blueArray[0] + (255 / 100) * mColorGradient;
        blueArray[1] = blueArray[1] + (102 / 100) * mColorGradient;
        blueArray[2] = blueArray[2] - (255 / 100) * mColorGradient;
        yellowArray[0] = yellowArray[0] - (228 / 100) * mColorGradient;
        yellowArray[1] = yellowArray[1] - (255 / 100) * mColorGradient;
        yellowArray[2] = yellowArray[2] + (130 / 100) * mColorGradient;
        greenArray[0] = greenArray[0] - (242 / 100) * mColorGradient;
        greenArray[1] = greenArray[1] - (227 / 100) * mColorGradient;
        greenArray[2] = greenArray[2] + (243 / 100) * mColorGradient;
        whiteArray[0] = whiteArray[0] - (240 / 100) * mColorGradient;
        whiteArray[1] = whiteArray[1] - (110 / 100) * mColorGradient;
        whiteArray[2] = whiteArray[2] + (255 / 100) * mColorGradient;

        txtRed.setBackgroundColor(Color.rgb(redArray[0], redArray[1], redArray[2]));
        txtYellow.setBackgroundColor(Color.rgb(yellowArray[0], yellowArray[1], yellowArray[2]));
        txtBlue.setBackgroundColor(Color.rgb(blueArray[0], blueArray[1], blueArray[2]));
        txtWhite.setBackgroundColor(Color.rgb(whiteArray[0], whiteArray[1], whiteArray[2]));
        txtGreen.setBackgroundColor(Color.rgb(greenArray[0], greenArray[1], greenArray[2]));
    }
}
