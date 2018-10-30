package space.cc.com.uilayouttest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import space.cc.com.uilayouttest.domain.adapters.RecyclerFruitAdapter;
import space.cc.com.uilayouttest.domain.bizobject.Fruit;

public class RecycleViewActivity extends AppCompatActivity {
    List<Fruit> fruits=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        //初始化数据
        initFruits();
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        /*LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //设置布局的排列方向 默认是纵向的此处改为横向排列 这样就可以横向滚动了
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);*/

        //瀑布流布局 构造参数 第一个3 是指有三列 流动方向垂直
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //由于图片不规则统一造成展示不规则的原因 此处将item的宽高都根据屏幕自适应调整
        int standardHeight=getViewIemHeight(7);
        int itemWidth=getViewIemWidth(5);
        //传输数据到适配器
//        RecyclerFruitAdapter adapter=new RecyclerFruitAdapter(fruits,standardHeight,itemWidth);
        //瀑布流时垂直布局尽量不指定高度 水平布局尽量不指定宽度 不然不大容易看出布局特性
        RecyclerFruitAdapter adapter=new RecyclerFruitAdapter(fruits);
        //设置view的适配器从而获取到转化过后可使用的数据
        recyclerView.setAdapter(adapter);
    }

    private int getViewIemWidth(int divide) {
        //获取屏幕高度
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager)RecycleViewActivity.this.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        //屏幕宽度
        int mScreenWidth = dm.widthPixels;
        return (mScreenWidth)/divide;
    }

    private int getViewIemHeight(int divide ) {
        //获取屏幕高度
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager)RecycleViewActivity.this.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        int mScreenHeight = dm.heightPixels;//屏幕高度
        return (mScreenHeight)/divide;
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
        Fruit apple=new Fruit(getRandomLengthName(name),imageId );
        fruits.add(apple);
    }
  /**
     * @description  瀑布流布局为了显示不同 对名字进行随机的加长
     * @author CF
     * created at 2018/10/31/031  0:15
     */
    private String getRandomLengthName(String name) {
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder sb=new StringBuilder(name);
        for(int i=0;i<length;i++){
            sb.append(name);
        }
        return sb.toString();
    }
}
