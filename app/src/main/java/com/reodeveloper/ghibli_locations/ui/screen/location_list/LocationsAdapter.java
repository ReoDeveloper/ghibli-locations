package com.reodeveloper.ghibli_locations.ui.screen.location_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.reodeveloper.ghibli_locations.R;
import com.reodeveloper.ghibli_locations.domain.model.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.ViewHolder> implements Filterable {

    private final List<Location> items;
    private List<Location> itemsFiltered;
    private final LocationListItemClickListener listener;

    LocationsAdapter(List<Location> items, LocationListItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Location item = items.get(position);
        holder.bind(item, listener);
        holder.name.setText(item.getName());
        holder.climate.setText(item.getClimate());
        holder.terrain.setText(item.getGeography());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String searchText = (String) charSequence;
                if(searchText.isEmpty()){
                    itemsFiltered = items;
                }else{
                    for(Location item : items){
                        if(item.getName().toLowerCase().contains(searchText.toLowerCase())){
                            itemsFiltered.add(item);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = itemsFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                List<Location> result = new ArrayList<>();
                if(filterResults.values instanceof List){
                    for(Object item : (List<?>)filterResults.values){
                        if(item instanceof Location){
                            result.add((Location) item);
                        }
                    }
                }
                itemsFiltered = result;
                notifyDataSetChanged();
            }
        };
    }

    interface LocationListItemClickListener {
        void onItemClick(Location item);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, climate, terrain;
        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);
            climate = itemView.findViewById(R.id.txt_climate);
            terrain = itemView.findViewById(R.id.txt_terrain);
        }

        void bind(final Location item, final LocationListItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
