package com.example.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CustomView extends View {
    public CustomView(Context context,AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        // 创建画笔
        Paint p = new Paint();
        p.setColor(Color.RED);// 设置红色
        canvas.drawLine(60, 40, 500, 40, p);// 画线
        canvas.drawRoundRect(new RectF(100, 100, 800, 400), 80, 70, p);//圆角矩形



    }
}
