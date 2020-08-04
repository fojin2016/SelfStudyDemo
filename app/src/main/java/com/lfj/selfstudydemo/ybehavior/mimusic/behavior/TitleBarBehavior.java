package com.lfj.selfstudydemo.ybehavior.mimusic.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;

import com.lfj.selfstudydemo.R;
import com.lfj.selfstudydemo.Yr;

import java.util.List;

/**
 * @function: TitleBar部分的Behavior
 */
public class TitleBarBehavior extends CoordinatorLayout.Behavior {
    private float contentTransY;//滑动内容初始化TransY
    private int topBarHeight;//topBar内容高度

    @SuppressWarnings("unused")
    public TitleBarBehavior(Context context) {
        this(context, null);
    }

    @SuppressWarnings("WeakerAccess")
    public TitleBarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        //引入尺寸值
        contentTransY = (int) context.getResources().getDimension(R.dimen.content_trans_y);
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        topBarHeight = (int) context.getResources().getDimension(R.dimen.top_bar_height) + statusBarHeight;
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        //依赖content
        return dependency.getId() == R.id.ll_content;
    }


    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        //调整TitleBar位置要紧贴Content顶部上面
        adjustPosition(parent, child, dependency);
        //这里只计算Content上滑范围一半的百分比
        float start = (contentTransY + topBarHeight) / 2;
        float upPro = (contentTransY - MathUtils.clamp(dependency.getTranslationY(), start, contentTransY)) / (contentTransY - start);
//        child.setAlpha(1 - upPro);
            changChildView(child,upPro);
        return true;
    }


    private void  changChildView(View child,float upPro){

        View searchView = child.findViewById(R.id.search_ll_search);
        int padoff= (int) (20*upPro);
        searchView.setPadding(padoff,0,padoff,0);

    }

    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull View child, int layoutDirection) {
        //找到Content的依赖引用
        List<View> dependencies = parent.getDependencies(child);
        View dependency = null;
        for (View view : dependencies) {
            if (view.getId() == R.id.ll_content) {
                dependency = view;
                break;
            }
        }



        if (dependency != null) {
            //调整TitleBar位置要紧贴Content顶部上面
            Yr.d();
            adjustPosition(parent, child, dependency);
            return true;
        } else {
            return false;
        }
    }

    private void adjustPosition(@NonNull CoordinatorLayout parent, @NonNull View child, View dependency) {


        final CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        int left = parent.getPaddingLeft() + lp.leftMargin;
        int top = (int) (dependency.getY() - child.getMeasuredHeight() + lp.topMargin);
        int right = child.getMeasuredWidth() + left - parent.getPaddingRight() - lp.rightMargin;
        int bottom = (int) (dependency.getY() - lp.bottomMargin);
        Yr.d(dependency.getY(),child.getMeasuredHeight());
        Yr.d(left,top,right,bottom);
        child.layout(left, top, right, bottom);
    }
}
