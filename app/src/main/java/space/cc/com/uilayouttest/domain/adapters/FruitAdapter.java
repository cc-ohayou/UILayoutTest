package space.cc.com.uilayouttest.domain.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import space.cc.com.uilayouttest.ListViewActivity;
import space.cc.com.uilayouttest.R;
import space.cc.com.uilayouttest.domain.bizobject.Fruit;


/*@Dat警告:
 Generating equals/hashCode implementation but without a call to superclass,
 even though this class does not extend java.lang.Object.
  If this is intentional（有意的）, add '@EqualsAndHashCode(callSuper=false)' to your type.
        */
@Data
@EqualsAndHashCode(callSuper=false)
public class FruitAdapter extends ArrayAdapter<Fruit> {
    //每个子item的平均高度
    private int height;
    //一般是对应ListView中的子项资源文件对应的id 譬如此处是R.layout.fruit_item 显示每条水果数据的子项布局
    int resourceId;
    public FruitAdapter(@NonNull Context context, int textViewId, @NonNull List<Fruit> objects) {
        super(context, textViewId, objects);
        resourceId = textViewId;
    }
  /**
     * @description 每个子项被滚动到屏幕时会调用getView方法
     * @author CF
     * created at 2018/10/28/028  18:12
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //获取当前项的Fruit 实例
        Fruit fruit =  getItem(position);
        //第三个参数 表示只让我们在父布局中声明的属性生效
        // 但不为这个View添加父布局
        //因为一旦View有了父布局之后就不嗯能够再添加到LIstView中了
       /*
       在实际开发中LayoutInflater这个类还是非常有用的，
        它的作用类似于findViewById()。不同点是LayoutInflater是
        用来找res/layout/下的xml布局文件，并且实例化；
        而findViewById()是找xml布局文件下的具体widget控件(如Button、TextView等)。
        通俗的说,inflate就相当于将一个xml中定义的布局找出来
        */
        View view;
        //convertView可用于缓存加载过的布局 此处判断下可提高性能 不必每次都去重新加载创建布局
        ViewHolder viewHolder;
        if(convertView!=null){
           view=convertView;
           //获取缓存中的viewHolder
            viewHolder= (ViewHolder) view.getTag();

       }else {
           //性能消耗点 此处每次都会去加载布局的实例
           view = LayoutInflater.from(getContext())
                   .inflate(resourceId, parent, false);
           viewHolder=new ViewHolder();
            viewHolder.fruitImage=view.findViewById(R.id.fruit_image);
            viewHolder.fruitName=view.findViewById(R.id.fruit_name);
            //存储到view中 第一次加载的view会被系统自动缓存 对应convertView
            view.setTag(viewHolder);
            //设置高度
            ViewGroup.LayoutParams linearParams =view.getLayoutParams();
            linearParams.height=height;
            view.setLayoutParams(linearParams);
       }
       //性能消耗点 每次都会去加载组件的实例findViewById
       /* ImageView fruitImage=view.findViewById(R.id.fruit_image);
        TextView fruitName=view.findViewById(R.id.fruit_name);*/
        //设置图片到ImageView中
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        //设置名称到TextView中
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }


    /**
     * @description 用于缓存每次的组件实例到view（也即缓存到ConvertView）中
     * @author CF
     * created at 2018/10/28/028  18:54
     */
    class  ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
