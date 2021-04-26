package br.edu.uniritter.mobile.alua_4_splash_binding.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classAlbums;
import br.edu.uniritter.mobile.alua_4_splash_binding.databinding.LayoutAlbumBinding;

public class classAlbumsAdapter extends RecyclerView.Adapter<classAlbumsAdapter.ViewHolder> {
    private List<classAlbums> list;

    public classAlbumsAdapter(List<classAlbums> list) { this.list = list; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LayoutAlbumBinding bindind;
        public ViewHolder(@NonNull LayoutAlbumBinding bindind){
            super(bindind.getRoot());
            this.bindind = bindind;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutAlbumBinding lub;
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        lub = LayoutAlbumBinding.inflate(inflator, parent, false);
        return new ViewHolder(lub);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { holder.bindind.setAlbum(list.get(position)); }

    @Override
    public int getItemCount() { return this.list.size(); }
}
