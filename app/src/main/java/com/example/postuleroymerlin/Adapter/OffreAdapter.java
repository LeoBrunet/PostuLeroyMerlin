package com.example.postuleroymerlin.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.postuleroymerlin.Model.Offre;
import com.example.postuleroymerlin.R;

import java.util.List;

public class OffreAdapter extends RecyclerView.Adapter<OffreAdapter.MyViewHolder> {
    private List<Offre> mDataset;

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
    public OffreAdapter(List<Offre> offres) {
        mDataset = offres;
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
        TextView titreOffre = holder.linearLayout.findViewById(R.id.titreOffre);
        TextView publi = holder.linearLayout.findViewById(R.id.publi);
        TextView lieu = holder.linearLayout.findViewById(R.id.lieu);
        TextView experience = holder.linearLayout.findViewById(R.id.experience);
        TextView filiere = holder.linearLayout.findViewById(R.id.filiere);

        titreOffre.setText(mDataset.get(position).getTitre());
        publi.setText(mDataset.get(position).getPublication());
        lieu.setText(mDataset.get(position).getLieu());
        experience.setText(mDataset.get(position).getExperience());
        filiere.setText(mDataset.get(position).getFiliere());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}