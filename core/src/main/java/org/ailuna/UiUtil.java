package org.ailuna;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class UiUtil {

    public static int obtainStyledAttributeColor(Context context, int attr) {
        int[] textSizeAttr = new int[] { attr };
        TypedArray a = context.obtainStyledAttributes(textSizeAttr);
        int color = a.getColor(0, -1);
        a.recycle();
        return color;
    }

    public static int dp2px(Context ctx, int dp) {
        Resources r = ctx.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return Math.round(px);
    }

    public static void hideKeyboard(View v) {
        try {
            InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
