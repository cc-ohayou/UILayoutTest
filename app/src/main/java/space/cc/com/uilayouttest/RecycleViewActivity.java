package space.cc.com.uilayouttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //传输数据到适配器
        RecyclerFruitAdapter adapter=new RecyclerFruitAdapter(fruits);
        //设置view的适配器从而获取到转化过后可使用的数据
        recyclerView.setAdapter(adapter);
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
