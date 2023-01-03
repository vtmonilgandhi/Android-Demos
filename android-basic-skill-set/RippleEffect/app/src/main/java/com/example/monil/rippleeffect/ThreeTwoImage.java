package com.example.monil.rippleeffect;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import java.util.jar.Attributes;

/**
 * Created by Volansys on 14/2/18.
 */
public class ThreeTwoImage extends android.support.v7.widget.AppCompatImageView {

    public ThreeTwoImage(Context context) {
        super(context);
    }
    public ThreeTwoImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public ThreeTwoImage(Context context,AttributeSet attrs,int defStyle) {
        super(context,attrs,defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int Height=MeasureSpec.getSize(widthMeasureSpec)*2/3;
        int HightSpec=MeasureSpec.makeMeasureSpec(Height,MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, HightSpec);
    }
}
