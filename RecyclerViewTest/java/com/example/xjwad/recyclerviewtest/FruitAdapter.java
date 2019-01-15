package com.example.xjwad.recyclerviewtest;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter {

    private List<Fruit> mFruitList ;

    /*定义一个内部类ViewHolder,继承自RecyclerView.ViewHolder，
     * ViewHolder的构造函数中传入一个View参数,这个参数是RecyclerView子项的最外层布局，
     * 然后就可以通过findViewById()方法来获取到布局中的ImageView和TextView*/
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View view){
            super(view);
            fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
            fruitName = (TextView)view.findViewById(R.id.fruit_name);
        }
    }


    /**/
    public FruitAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


    }

    public int getItemCount(){
        return  mFruitList.size();
    }
}
