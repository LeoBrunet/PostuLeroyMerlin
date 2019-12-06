package com.example.postuleroymerlin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.postuleroymerlin.Model.Avis;
import com.example.postuleroymerlin.R;

import java.util.List;

public class AvisAdapter extends RecyclerView.Adapter<AvisAdapter.MyViewHolder> {
    private List<Avis> mDataset;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout linearLayout;


        public MyViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            this.linearLayout = linearLayout;
        }


    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AvisAdapter(List<Avis> avis, Context context) {
        mDataset = avis;
        this.context=context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AvisAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.avis1, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView note = holder.linearLayout.findViewById(R.id.note);
        TextView titre = holder.linearLayout.findViewById(R.id.titre);
        TextView create = holder.linearLayout.findViewById(R.id.create);
        TextView description = holder.linearLayout.findViewById(R.id.description);


        note.setText(mDataset.get(position).getNote()+"");
        titre.setText(mDataset.get(position).getTitre());
        create.setText(mDataset.get(position).getCreate());
        description.setText(mDataset.get(position).getDescription());

        if (position==mDataset.size()){
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) holder.linearLayout.getLayoutParams();

            final float scale = context.getResources().getDisplayMetrics().density;
            int left=5;
            int top=5;
            int right=5;
            int bottom=20;
            // convert the DP into pixel
            int pixel_left = (int) (left * scale + 0.5f);
            int pixel_top = (int) (top * scale + 0.5f);
            int pixel_right = (int) (right * scale + 0.5f);
            int pixel_bottom = (int) (bottom * scale + 0.5f);

            lp.setMargins(pixel_left, pixel_top, pixel_right, pixel_bottom);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}