package space.cc.com.uilayouttest.domain.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import space.cc.com.uilayouttest.R;
import space.cc.com.uilayouttest.domain.bizobject.Fruit;


public class RecyclerFruitAdapter extends RecyclerView.Adapter<RecyclerFruitAdapter.ViewHolder> {

    private int height;
    private int width;
    private List<Fruit> fruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           fruitView=itemView;
           fruitImage= itemView.findViewById(R.id.fruit_image);
           fruitName= itemView.findViewById(R.id.fruit_name);
       }
   }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Fruit> getFruitList() {
        return fruitList;
    }

    public void setFruitList(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public RecyclerFruitAdapter(List<Fruit> fruitList,int height) {
        this.fruitList = fruitList;
        //此处将自己想要的item的高度传入 在下面的onCreateViewHolder中设置子项view的高度
        this.height=height;
    }

    public RecyclerFruitAdapter(List<Fruit> fruitList,int height,int width) {
        this.fruitList = fruitList;
        //此处将自己想要的item的宽高传入 在下面的onCreateViewHolder中设置子项view的高度
        this.height=height;
        this.width=width;
    }
    public RecyclerFruitAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
        //此处将自己想要的item的高度传入 在下面的onCreateViewHolder中设置子项view的高度
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //找到子项item的view布局 类似findViewById找到组件
       View view= LayoutInflater.from(parent.getContext())
               .inflate(R.layout.fruit_item,parent,false) ;
        ViewGroup.LayoutParams linearParams =view.getLayoutParams();
        //设置高度 一般纵向滚动时有此需求
        if(height>0){
            linearParams.height=height;
        }
//        一般最好宽高都自适应屏幕指定
        //设置宽度 一般横向滚动时有此需求
        if(width>0){
            linearParams.width=width;
        }
        view.setLayoutParams(linearParams);
       final ViewHolder holder=new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fruit fruit=fruitList.get(position);
                Toast.makeText(v.getContext(),"clicked  view "+fruit.getName()
                ,Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fruit fruit=fruitList.get(position);
                Toast.makeText(v.getContext(),"clicked  image "+fruit.getName()
                        ,Toast.LENGTH_SHORT).show();
            }
        });
       return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
           Fruit fruit=fruitList.get(position);
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }
}
