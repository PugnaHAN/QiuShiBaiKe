package com.hp.qiushibaike.ui.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.hp.qiushibaike.utils.LogUtils;

import java.util.jar.Attributes;

/**
 * Created by zhangjuh on 2016/3/1.
 */
public class RoundImageView extends ImageView {
    private static final String TAG = LogUtils.makeLogTag(RoundImageView.class);

    public RoundImageView(Context context){
        super(context);
    }

    public RoundImageView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Drawable drawable = getDrawable();
        if(drawable == null){
            return;
        }

        if(getWidth() == 0 || getHeight() == 0){
            return;
        }

        Paint paint = new Paint();
        // 抗锯齿
        paint.setAntiAlias(true);
        // Paint 的Xfermode， PorterDuff.Mode.SRC_IN 取两层图像的交集部分，只显示上层图像
        PorterDuffXfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        // 获取Bitmap
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

        // 标志
        int saveFlags = Canvas.MATRIX_SAVE_FLAG | Canvas.CLIP_SAVE_FLAG |
                Canvas.HAS_ALPHA_LAYER_SAVE_FLAG;
        canvas.saveLayer(0, 0, getWidth(), getHeight(), null, saveFlags);

        //画遮罩，画出来就是一个和空间大小匹配的圆形
        canvas.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2, paint);
        paint.setXfermode(xfermode);

        //空间的大小 / Bitmap的大小 = bitmap的缩放倍数
        float scaleWidth = ((float) getWidth())/bitmap.getWidth();
        float scaleHeight = ((float) getHeight()/bitmap.getHeight());

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

        // 画上去
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();
    }
}
