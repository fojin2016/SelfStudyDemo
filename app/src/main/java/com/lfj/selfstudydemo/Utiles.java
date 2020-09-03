package com.lfj.selfstudydemo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import java.lang.reflect.Field;

/**
 * @author LFJ
 * @description
 * @date 2020/8/28 14:30
 */
class Utiles {

    public static void getNumberPicker(DatePicker datePicker) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends DatePicker> c =DatePicker.class;
        Field fd = null, fm = null, fy = null;
        View daySpinner = null;
        View monthSpinner= null;
        View yearSpinner = null;
        // 系统版本大于5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //获取资源的id
            int daySpinnerId = Resources.getSystem().getIdentifier("day", "id", "android");
            int monthSpinnerId = Resources.getSystem().getIdentifier("month", "id", "android");
            int yearSpinnerId = Resources.getSystem().getIdentifier("year", "id", "android");
            if (daySpinnerId != 0 && monthSpinnerId!=0 && yearSpinnerId!=0) {
                daySpinner = datePicker.findViewById(daySpinnerId);
                monthSpinner = datePicker.findViewById(monthSpinnerId);
                yearSpinner = datePicker.findViewById(yearSpinnerId);
            }
            //或者
           LinearLayout llFirst = (LinearLayout)datePicker. getChildAt(0);
            LinearLayout mSpinners = (LinearLayout) llFirst.getChildAt(0);
            for (int i = 0; i < mSpinners.getChildCount(); i++)
            {
                NumberPicker picker = (NumberPicker) mSpinners.getChildAt(i);
//                mPickers.add(i, picker);
                Yr.d();
            }
            return;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            // 系统版本大于4.0
            fd = c.getDeclaredField("mDaySpinner");
            fm = c.getDeclaredField("mMonthSpinner");
            fy = c.getDeclaredField("mYearSpinner");
            if(fd!=null && fm!=null &&fy!=null){
                // 对字段获取设置权限
                fd.setAccessible(true);
                fm.setAccessible(true);
                fy.setAccessible(true);
                // 得到对应的控件
                daySpinner = (View) fd.get(datePicker);
                monthSpinner= (View) fm.get(datePicker);
                yearSpinner= (View) fy.get(datePicker);
            }
        } else {
            fd = c.getDeclaredField("mDayPicker");
            fm = c.getDeclaredField("mMonthPicker");
            fy = c.getDeclaredField("mYearPicker");
            if(fd!=null && fm!=null &&fy!=null){
                // 对字段获取设置权限
                fd.setAccessible(true);
                fm.setAccessible(true);
                fy.setAccessible(true);
                // 得到对应的控件
                daySpinner = (View) fd.get(datePicker);
                monthSpinner= (View) fm.get(datePicker);
                yearSpinner= (View) fy.get(datePicker);
            }
        }
        if (daySpinner != null && monthSpinner != null && yearSpinner != null) {
            daySpinner.setVisibility(View.GONE);
            if(daySpinner instanceof NumberPicker && monthSpinner instanceof NumberPicker && yearSpinner instanceof NumberPicker ){
//                mPickers.add((NumberPicker) daySpinner);
//                mPickers.add((NumberPicker) monthSpinner);
//                mPickers.add((NumberPicker) yearSpinner);
            }
        }

    }
}
