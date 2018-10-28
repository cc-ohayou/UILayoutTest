package space.cc.com.uilayouttest;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout implements View.OnClickListener {
    Button titleBack;
    Button titleEdit;
    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //在其他布局中引入标题栏时，动态加载标题栏的布局
        LayoutInflater.from(context).inflate(R.layout.title,this);
         titleBack=findViewById(R.id.titlt_back);
         titleEdit=findViewById(R.id.titlt_edit);
        titleBack.setOnClickListener(this);
        titleEdit.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.titlt_back:
                ((Activity) getContext()).finish();
            case R.id.titlt_edit:
                Toast.makeText(getContext(), "click edit button",
                        Toast.LENGTH_SHORT).show();
        }
    }
}
