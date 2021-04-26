package br.edu.uniritter.mobile.alua_4_splash_binding.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classPhotos;
import br.edu.uniritter.mobile.alua_4_splash_binding.databinding.LayoutPhotoBinding;

public class classPhotosAdapter extends RecyclerView.Adapter<classPhotosAdapter.ViewHolder> {
    private List<classPhotos> list;

    public classPhotosAdapter(List<classPhotos> list) { this.list = list; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LayoutPhotoBinding bindind;
        public ViewHolder(@NonNull LayoutPhotoBinding bindind){
            super(bindind.getRoot());
            this.bindind = bindind;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutPhotoBinding lub;
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        lub = LayoutPhotoBinding.inflate(inflator, parent, false);
        return new ViewHolder(lub);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { holder.bindind.setPhoto(list.get(position)); }

    @Override
    public int getItemCount() { return this.list.size(); }
}
