package br.edu.uniritter.mobile.alua_4_splash_binding.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classUsers;
import br.edu.uniritter.mobile.alua_4_splash_binding.databinding.LayoutUserBinding;

public class classUsersAdapter extends RecyclerView.Adapter<classUsersAdapter.ViewHolder> {
    private List<classUsers> list;

    public classUsersAdapter(List<classUsers> list) { this.list = list; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LayoutUserBinding bindind;
        public ViewHolder(@NonNull LayoutUserBinding bindind){
            super(bindind.getRoot());
            this.bindind = bindind;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutUserBinding lub;
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        lub = LayoutUserBinding.inflate(inflator, parent, false);
        return new ViewHolder(lub);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { holder.bindind.setUser(list.get(position)); }

    @Override
    public int getItemCount() { return this.list.size(); }
}
