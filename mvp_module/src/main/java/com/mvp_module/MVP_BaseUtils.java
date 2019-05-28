package com.mvp_module;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;


public class MVP_BaseUtils {

    private Context context;

    private static MVP_BaseUtils instance;

    private MVP_BaseUtils(Context context) {

        this.context = context;
    }

    public static MVP_BaseUtils getInstance(Context context) {

        if (instance == null)
            instance = new MVP_BaseUtils(context);
        return instance;
    }

    public int getScreenSize(boolean isWidth) {

        int width = 0;
        int height = 0;

        if (context != null) {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();

            final Point point = new Point();
            try {
                display.getSize(point);

                width = point.x;
                height = point.y;
            } catch (NoSuchMethodError ignore) { // Older device

                width = point.x = display.getWidth();
                height = point.y = display.getHeight();

            }
        }
        if (isWidth)
            return width;
        else
            return height;

    }

    public void log(String nameClass, String methodName, String error) {

        Log.e("className :".concat("\n").concat(nameClass).concat("\n")
                .concat("methodName :").concat("\n").concat(methodName).concat("\n")
                .concat(methodName), error);


    }

    public void log(String nameClass, String methodName, Exception error) {

        Log.e("className :".concat("\n").concat(nameClass).concat("\n")
                .concat("methodName :").concat("\n").concat(methodName).concat("\n")
                .concat(methodName), error.getMessage());
    }

    public String getMethodName() {

        try {

            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            return stackTraceElements[3].getMethodName();

        } catch (Exception e) {

            log(getClass().getSimpleName(), "getMethodName", e.toString());
        }

        return "getMethodName";
    }

    public void normalDialogStyle(Dialog dialog, int width, int height) {

        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;

        wlp.y = 15;

        wlp.width = width - 30;
        if (height != -1)
            wlp.height = height;


        window.getAttributes().windowAnimations = R.style.animation_dialog_normal;

        window.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        window.setAttributes(wlp);


    }


}
