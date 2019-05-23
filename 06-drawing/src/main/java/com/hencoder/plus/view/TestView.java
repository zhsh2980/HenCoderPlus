package com.hencoder.plus.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.hencoder.plus.Utils;

/**
 * Created by zhangshan on 2019-05-23 16:10.
 */
public class TestView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();


    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        path.reset();
        path.addRect(getWidth() / 2 - 150, getHeight() / 2 - 300
                , getWidth() / 2 + 150, getHeight() / 2, Path.Direction.CCW);
        path.addCircle(getWidth() / 2, getHeight() / 2, 150, Path.Direction.CCW);
//        path.addCircle(getWidth()/2 , getHeight()/2 , 400 , Path.Direction.CCW);
        // CCW 顺时针
        // CW 逆时针
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();//周长
        //pathMeasure.getPosTan()  点的坐标
        Log.i("bro" , length+"");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        path.setFillType(Path.FillType.EVEN_ODD);
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        canvas.drawPath(path, paint);
//        canvas.drawLine(100 , 100,200 , 200 , paint);
//        canvas.drawCircle(getWidth()/2 , getHeight()/2 , Utils.dp2px(100) , paint);
    }
}
