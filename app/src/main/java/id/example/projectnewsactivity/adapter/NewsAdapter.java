package id.example.projectnewsactivity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import id.example.projectnewsactivity.R;
import id.example.projectnewsactivity.model.DataNews;
import id.example.projectnewsactivity.ui.newsActivity;
import id.example.projectnewsactivity.util.Constans;

public class NewsAdapter extends RecyclerView.Adapter {
    public static ArrayList<DataNews>pdflist;
    public static ArrayList<DataNews>mFilteredList;
    public Context context;

    public NewsAdapter(ArrayList<DataNews>pdflist,Context context) {
        this.pdflist=pdflist;
        this.context=context;
        mFilteredList=pdflist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent,int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news,parent,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NotNull final RecyclerView.ViewHolder holder,
                                 @SuppressLint("RecyclerView")final int position) {
        if (holder instanceof RecyclerView.ViewHolder) {
            final DataNews webList = mFilteredList.get(position);
            ((ViewHolder)holder).txtTitle.setText(webList.getTitle());
            Picasso.get()
                    .load(webList.getLink_image())
                    .into(((ViewHolder)holder).imgPost);

            ((ViewHolder)holder).layClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Constans.TITLE = webList.getTitle();
                    Constans.IMAGE = webList.getLink_image();
                    Constans.DESCRIPTION = webList.getDescription();
                    Intent intent = new Intent(context, newsActivity.class);
                    Context.startActivity(intent);
                }
            });
        }
    }
    public int getItemCount() {
        return mFilteredList == null ?0 : mFilteredList.size();
    }
    public  class ViewHolder extends RecyclerView,ViewHolder {
        public TextView txtTitle,txtShort,txtStart,txtDiscount,txtPrice;
        public ImageView imgPost, imgBookmark;
        public CardView layClick;

        public ViewHolde(View itemView) {
            super(itemView);
            imgPost =  itemView.findViewById(R.id.imgPost);
            layClick = itemView.findViewById(R.id.layClick);
            txtTitle = itemView.findViewById(R.id.txtTitle);
        }
    }

}
