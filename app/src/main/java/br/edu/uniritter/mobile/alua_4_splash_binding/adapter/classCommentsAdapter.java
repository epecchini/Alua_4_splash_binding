package br.edu.uniritter.mobile.alua_4_splash_binding.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classComments;
import br.edu.uniritter.mobile.alua_4_splash_binding.databinding.LayoutCommentBinding;

public class classCommentsAdapter extends RecyclerView.Adapter<classCommentsAdapter.ViewHolder> {
    private List<classComments> list;

    public classCommentsAdapter(List<classComments> list) { this.list = list; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LayoutCommentBinding bindind;
        public ViewHolder(@NonNull LayoutCommentBinding bindind){
            super(bindind.getRoot());
            this.bindind = bindind;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutCommentBinding lub;
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        lub = LayoutCommentBinding.inflate(inflator, parent, false);
        return new ViewHolder(lub);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { holder.bindind.setComment(list.get(position)); }

    @Override
    public int getItemCount() { return this.list.size(); }
}
