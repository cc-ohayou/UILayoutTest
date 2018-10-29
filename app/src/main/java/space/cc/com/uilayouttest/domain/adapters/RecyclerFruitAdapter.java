package space.cc.com.uilayouttest.domain.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import space.cc.com.uilayouttest.R;
import space.cc.com.uilayouttest.domain.bizobject.Fruit;


public class RecyclerFruitAdapter extends RecyclerView.Adapter<RecyclerFruitAdapter.ViewHolder> {

    private int height;
   private List<Fruit> fruitList;
   static class ViewHolder extends RecyclerView.ViewHolder{
       ImageView fruitImage;
       TextView fruitName;

       public ViewHolder(@NonNull View itemView) {
           super(itemView);
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

    public RecyclerFruitAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //找到子项item的view布局 类似findViewById找到组件
       View view= LayoutInflater.from(parent.getContext())
               .inflate(R.layout.fruit_item,parent,false) ;
       ViewHolder holder=new ViewHolder(view);
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
