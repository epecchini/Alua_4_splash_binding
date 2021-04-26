package br.edu.uniritter.mobile.alua_4_splash_binding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

import br.edu.uniritter.mobile.alua_4_splash_binding.adapter.classAlbumsAdapter;
import br.edu.uniritter.mobile.alua_4_splash_binding.adapter.classCommentsAdapter;
import br.edu.uniritter.mobile.alua_4_splash_binding.adapter.classPhotosAdapter;
import br.edu.uniritter.mobile.alua_4_splash_binding.adapter.classPostsAdapter;
import br.edu.uniritter.mobile.alua_4_splash_binding.adapter.classTodosAdapter;
import br.edu.uniritter.mobile.alua_4_splash_binding.adapter.classUsersAdapter;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classAlbums;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classComments;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classPhotos;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classPosts;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classTodos;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classUsers;
import br.edu.uniritter.mobile.alua_4_splash_binding.presenter.FirstActivityPresenterClass;
import br.edu.uniritter.mobile.alua_4_splash_binding.presenter.FirstActivityPresenterInterface;

public class FirstActivityPresenter extends AppCompatActivity
        implements FirstActivityPresenterInterface.FirstActivityPresenterView {

    private FirstActivityPresenterInterface.FirstActivityPresenterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_presenter);

        TextView tv = (TextView) findViewById(R.id.textView4);
        Intent it = getIntent();
        String txt = it.getStringExtra("nomeInformado");
        tv.setText(txt);
    }

    public void abrirMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void abrirLoginActivity(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onClick(View view) {
        Button btn = (Button) view;
        this.presenter =  new FirstActivityPresenterClass(this, btn.getTag() + "");
    }

    @Override
    public void bindAlbums(List<classAlbums> albums) {
        RecyclerView rv = findViewById(R.id.rvInfoGeral);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //
        rv.setLayoutManager(llm);
        classAlbumsAdapter clsAlbums = new classAlbumsAdapter(albums);
        rv.setAdapter(clsAlbums);
    }

    @Override
    public void bindComments(List<classComments> comments) {
        RecyclerView rv = findViewById(R.id.rvInfoGeral);
        LinearLayoutManager llmh = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //
        rv.setLayoutManager(llmh);
        classCommentsAdapter clsComments = new classCommentsAdapter(comments);
        rv.setAdapter(clsComments);
    }

    @Override
    public void bindPhotos(List<classPhotos> photos) {
        RecyclerView rv = findViewById(R.id.rvInfoGeral);
        GridLayoutManager glm = new GridLayoutManager(this,3);
        //
        rv.setLayoutManager(glm);
        classPhotosAdapter clsPhotos = new classPhotosAdapter(photos);
        rv.setAdapter(clsPhotos);
    }

    @Override
    public void bindPosts(List<classPosts> posts) {
        RecyclerView rv = findViewById(R.id.rvInfoGeral);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        //
        rv.setLayoutManager(sglm);
        classPostsAdapter clsPosts = new classPostsAdapter(posts);
        rv.setAdapter(clsPosts);
    }

    @Override
    public void bindTodos(List<classTodos> todos) {
        RecyclerView rv = findViewById(R.id.rvInfoGeral);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //
        rv.setLayoutManager(llm);
        classTodosAdapter clsTodos = new classTodosAdapter(todos);
        rv.setAdapter(clsTodos);
    }

    @Override
    public void bindUsers(List<classUsers> users) {
        RecyclerView rv = findViewById(R.id.rvInfoGeral);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //
        rv.setLayoutManager(llm);
        classUsersAdapter clsUsers = new classUsersAdapter(users);
        rv.setAdapter(clsUsers);
    }

    @Override
    public void mostraToast(String msg) { Toast.makeText(this.getApplicationContext(), msg, Toast.LENGTH_LONG).show(); }

    @Override
    public Context getContexto() { return this.getApplicationContext(); }
}