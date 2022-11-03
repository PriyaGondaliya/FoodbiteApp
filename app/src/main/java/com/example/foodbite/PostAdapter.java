package com.example.foodbite;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{


    private List<PostItem> postItems;
    Callback callback;

    public PostAdapter(List<PostItem> postItems,Callback callback){
        this.postItems = postItems;
        this.callback = callback;

    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.post_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.setPostImage(postItems.get(position));
        holder.postImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        RoundedImageView postImageView;
        TextView postTitle;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postImageView = itemView.findViewById(R.id.imagePost);
            postTitle = itemView.findViewById(R.id.title);

        }
        void setPostImage(PostItem postItem){
            //if you want to display image from the internet,
            //here you can put code for loading image using  glid or picaso
            postImageView.setImageResource(postItem.getImage());
            postTitle.setText(postItem.getTitle());
        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Log.d("POSITION","position");
//            Toast.makeText(this,"position",Toast.LENGTH_LONG).show();
        }
    }

}
