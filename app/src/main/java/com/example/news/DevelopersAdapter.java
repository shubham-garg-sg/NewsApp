package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DevelopersAdapter extends RecyclerView.Adapter<DevelopersAdapter.ViewHolder> {

    private static final String TITLE = "title";
    private static final String IMAGE = "urlToImage";
    private static final String URL = "url";

    private List<DevelopersList> developersLists;
    private Context context;

    public DevelopersAdapter(List<DevelopersList> developersLists, Context context) {
        this.context = context;
        this.developersLists =  developersLists;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final DevelopersList developersList = developersLists.get(position);

        holder.title.setText(developersList.getTitle());
        Picasso.get()
                .load(developersList.getUrlToImage())
                .into(holder.urlToImage);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DescriptionActivity.class);
                intent.putExtra("url", developersList.getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return developersLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView urlToImage;
        private CardView cardView;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(), DescriptionActivity.class));
                }
            });

            title = itemView.findViewById(R.id.textView);
            urlToImage = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
        }

    }
}
