package ir.imansoft.chargeexpress.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import ir.imansoft.chargeexpress.R;

/**
 * Android ZarinPal SDK Library v0.1 Project.
 * Created by ImanX on 12/2/16.
 * Copyright Alireza Tarazani All Rights Reserved.
 */
public class Toolbar extends LinearLayout {


    private int    color;
    private String title;


    public Toolbar(Context context) {
        super(context);
    }

    public Toolbar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typed = context.obtainStyledAttributes(attrs, R.styleable.toolbar);
        this.color = typed.getColor(R.styleable.toolbar_color, 0);
        this.title = typed.getString(R.styleable.toolbar_title);
        typed.recycle();
    }

    public Toolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        addView(initializeView());
    }

    private View initializeView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.toolbar, null, true);

        FrameLayout  btnBack    = (FrameLayout) view.findViewById(R.id.btnBack);
        LinearLayout rootLayout = (LinearLayout) view.findViewById(R.id.rootLayout);
        TextView     txtTitle   = (TextView) view.findViewById(R.id.txtTitle);


        if (this.color != 0) {
            rootLayout.setBackgroundColor(this.color);
        }


        if (this.title != null) {
            txtTitle.setText(this.title);
            txtTitle.setVisibility(VISIBLE);
        }


        btnBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG Back", "Clicked");
            }
        });

        return view;
    }
}
