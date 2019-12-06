package com.example.postuleroymerlin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.postuleroymerlin.Model.OffrePreface;
import com.example.postuleroymerlin.R;

import java.util.List;

public class OffreAdapter extends RecyclerView.Adapter<OffreAdapter.MyViewHolder> {
    private List<OffrePreface> mDataset;
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
    public OffreAdapter(List<OffrePreface> offres, Context context) {
        mDataset = offres;
        this.context=context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public OffreAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.offre, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        LinearLayout linear = holder.linearLayout.findViewById(R.id.linear);
        TextView titreOffre = linear.findViewById(R.id.titreOffre);
        TextView publi = holder.linearLayout.findViewById(R.id.publi);

        TextView lieu = holder.linearLayout.findViewById(R.id.lieu);
        TextView experience = holder.linearLayout.findViewById(R.id.experience);
        TextView filiere = holder.linearLayout.findViewById(R.id.filiere);

        titreOffre.setText(mDataset.get(position).getTitre());
        publi.setText("Publié le "+mDataset.get(position).getPublication());
        lieu.setText(mDataset.get(position).getLieu());
        experience.setText(mDataset.get(position).getExperience());
        filiere.setText(mDataset.get(position).getFiliere());

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