package com.contacts.test.contacts;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by niraj.kumar.chauhan on 31-01-2015.
 */
public class ScribbleActivityFinal extends Activity implements View.OnTouchListener{
    ImageView scribbleImageView;
    Bitmap bmp,alteredBitmap;
    Canvas canvas;
    Paint paint;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downx = event.getX();
                downy = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                upx = event.getX();
                upy = event.getY();
                canvas.drawLine(downx, downy, upx, upy, paint);
                scribbleImageView.invalidate();
                downx = upx;
                downy = upy;
                break;
            case MotionEvent.ACTION_UP:
                upx = event.getX();
                upy = event.getY();
                canvas.drawLine(downx, downy, upx, upy, paint);
                scribbleImageView.invalidate();
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            default:
                break;
        }
        return true;
    }

    Matrix matrix;
    float downx=0,downy=0,upx=0,upy=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scribble);
        int scribbleDrawable = getIntent().getIntExtra("skilldrawable",R.drawable.background);
        scribbleImageView = (ImageView) findViewById(R.id.scribbleImageView);
        bmp = BitmapFactory.decodeResource(getResources(),scribbleDrawable);
        alteredBitmap = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(),bmp.getConfig());
        canvas = new Canvas(alteredBitmap);
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        matrix = new Matrix();
        canvas.drawBitmap(bmp,matrix,paint);
        scribbleImageView.setImageBitmap(alteredBitmap);
        scribbleImageView.setOnTouchListener(this);
    }
}

