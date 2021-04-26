package br.edu.uniritter.mobile.alua_4_splash_binding.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classPosts;
import br.edu.uniritter.mobile.alua_4_splash_binding.databinding.LayoutPostBinding;

public class classPostsAdapter extends RecyclerView.Adapter<classPostsAdapter.ViewHolder> {
    private List<classPosts> list;

    public classPostsAdapter(List<classPosts> list) { this.list = list; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LayoutPostBinding bindind;
        public ViewHolder(@NonNull LayoutPostBinding bindind){
            super(bindind.getRoot());
            this.bindind = bindind;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutPostBinding lub;
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        lub = LayoutPostBinding.inflate(inflator, parent, false);
        return new ViewHolder(lub);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { holder.bindind.setPost(list.get(position)); }

    @Override
    public int getItemCount() { return this.list.size(); }
}
