package br.edu.uniritter.mobile.alua_4_splash_binding.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classTodos;
import br.edu.uniritter.mobile.alua_4_splash_binding.databinding.LayoutTodoBinding;

public class classTodosAdapter extends RecyclerView.Adapter<classTodosAdapter.ViewHolder> {
    private List<classTodos> list;

    public classTodosAdapter(List<classTodos> list) { this.list = list; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LayoutTodoBinding bindind;
        public ViewHolder(@NonNull LayoutTodoBinding bindind){
            super(bindind.getRoot());
            this.bindind = bindind;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutTodoBinding lub;
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        lub = LayoutTodoBinding.inflate(inflator, parent, false);
        return new ViewHolder(lub);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { holder.bindind.setTodo(list.get(position)); }

    @Override
    public int getItemCount() { return this.list.size(); }
}
