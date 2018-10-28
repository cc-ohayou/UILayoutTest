package space.cc.com.uilayouttest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import space.cc.com.uilayouttest.domain.adapters.FruitAdapter;
import space.cc.com.uilayouttest.domain.bizobject.Fruit;

public class ListViewActivity extends AppCompatActivity {

    List<Fruit> fruits=new ArrayList<>();
    private String[] data={"Apple","banana","orange","pear","grape","pineApple","mango","cherry"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
       /*
        //ListView和数据之间需要adapter来进行适配转换
        // android.R.layout.simple_list_item_1是android内置的一个布局文件
        //此处使用此布局作为listView的子项 用于显示简单的文本
        ArrayAdapter<String> adapter=new ArrayAdapter<>(
                ListViewActivity.this,android.R.layout.simple_list_item_1,data
        );*/
       //初始化水果数据
        initFruits();
        FruitAdapter fruitAdapter=new FruitAdapter(ListViewActivity.this,
                R.layout.fruit_item,fruits);
        ListView listView=findViewById(R.id.list_view_01);
        int standardHeight =getViewIemHeight();
        fruitAdapter.setHeight(standardHeight);
        listView.setAdapter(fruitAdapter);
    }

    private int getViewIemHeight( ) {
            //获取屏幕高度
            DisplayMetrics dm = new DisplayMetrics();
            WindowManager wm = (WindowManager)ListViewActivity.this.getSystemService(Context.WINDOW_SERVICE);
            wm.getDefaultDisplay().getMetrics(dm);
            int mScreenHeight = dm.heightPixels;//屏幕高度
            return (mScreenHeight)/4;
    }

    private void initFruits() {
        for (int i=0;i<2;i++){
            addFruit("apple",R.drawable.apple);
            addFruit("banana",R.drawable.banana);
            //注意命名必须小写a-z和下划线才行 大写会报错
            addFruit("pineApple",R.drawable.pine_apple);
            addFruit("mango",R.drawable.mango);
            addFruit("pear",R.drawable.pear);
            addFruit("grape",R.drawable.grape);
            addFruit("strawberry",R.drawable.strawberry);
        }
    }

    private void addFruit(String name,int imageId) {
        Fruit apple=new Fruit(name,imageId );
        fruits.add(apple);
    }
}
