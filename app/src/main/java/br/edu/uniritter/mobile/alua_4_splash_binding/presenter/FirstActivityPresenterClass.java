package br.edu.uniritter.mobile.alua_4_splash_binding.presenter;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classAlbums;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classComments;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classPhotos;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classPosts;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classTodos;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classUsers;
import br.edu.uniritter.mobile.alua_4_splash_binding.var_address;
import br.edu.uniritter.mobile.alua_4_splash_binding.var_company;
import br.edu.uniritter.mobile.alua_4_splash_binding.var_geo;

public class FirstActivityPresenterClass implements Response.Listener<JSONArray>,
        Response.ErrorListener, FirstActivityPresenterInterface.FirstActivityPresenterPresenter {

    private List<classAlbums> albums =  new ArrayList<>();
    private List<classComments> comments =  new ArrayList<>();
    private List<classPhotos> photos =  new ArrayList<>();
    private List<classPosts> posts =  new ArrayList<>();
    private List<classTodos> todos =  new ArrayList<>();
    private List<classUsers> users =  new ArrayList<>();
    private String btnTag;
    private FirstActivityPresenterInterface.FirstActivityPresenterView view;

    public FirstActivityPresenterClass(FirstActivityPresenterInterface.FirstActivityPresenterView view, String btnTag){
        this.btnTag = btnTag;
        this.view = view;
        start();
    }

    @Override
    public void start() {
        RequestQueue queue = Volley.newRequestQueue(view.getContexto());
        String url = "https://jsonplaceholder.typicode.com/" + btnTag;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, this, this);
        queue.add(jsonArrayRequest);
    }

    @Override
    public void encerrar() { }

    @Override
    public void onErrorResponse(VolleyError error) { view.mostraToast("deu erro: " + error.getMessage()); }

    @Override
    public void onResponse(JSONArray response) {
        try {
            switch (btnTag) {
                case "albums":
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject json = response.getJSONObject(i);
                        classAlbums obj = new classAlbums(
                                json.getInt("userId"),
                                json.getInt("id"),
                                json.getString("title"));
                        albums.add(obj);
                    }
                    view.bindAlbums(albums);
                    break;
                case "comments":
                 /*   for (int i = 0; i < response.length(); i++) {
                        JSONObject json = response.getJSONObject(i);
                        classComments obj = new classComments(
                                json.getInt("postId"),
                                json.getInt("id"),
                                json.getString("name"),
                                json.getString("email"),
                                json.getString("body"));
                        comments.add(obj);
                    }
                    view.bindComments(comments);*/
                    break;
                case "photos":
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject json = response.getJSONObject(i);
                        classPhotos obj = new classPhotos(
                                json.getInt("albumId"),
                                json.getInt("id"),
                                json.getString("title"),
                                json.getString("url"),
                                json.getString("thumbnailUrl"));
                        photos.add(obj);
                    }
                    view.bindPhotos(photos);
                    break;
                case "posts":
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject json = response.getJSONObject(i);
                        classPosts obj = new classPosts(
                                json.getInt("userId"),
                                json.getInt("id"),
                                json.getString("title"),
                                json.getString("body"));
                        posts.add(obj);
                    }
                    view.bindPosts(posts);
                    break;
                case "todos":
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject json = response.getJSONObject(i);
                        classTodos obj = new classTodos(
                                json.getInt("userId"),
                                json.getInt("id"),
                                json.getString("title"),
                                json.getBoolean("completed"));
                        todos.add(obj);
                    }
                    view.bindTodos(todos);
                    break;
                case "users":
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject json = response.getJSONObject(i);
                        //
                        JSONObject add = json.getJSONObject("address");
                        JSONObject geo = add.getJSONObject("geo");
                        JSONObject cmp = json.getJSONObject("company");
                        //
                        classUsers obj = new classUsers(
                                json.getInt("id"),
                                json.getString("name"),
                                json.getString("username"),
                                json.getString("email"),
                                new var_address( add.getString("street"),
                                        add.getString("suite"),
                                        add.getString("city"),
                                        add.getString("zipcode"),
                                        new var_geo(
                                                geo.getDouble("lat"),
                                                geo.getDouble("lng"))
                                ),
                                json.getString("phone"),
                                json.getString("website"),
                                new var_company(
                                        cmp.getString("name"),
                                        cmp.getString("catchPhrase"),
                                        cmp.getString("bs")));
                        users.add(obj);
                    }
                    view.bindUsers(users);
                    break;
            }
        } catch (JSONException e) {
            Log.e("erro", e.getMessage());
            e.printStackTrace();
        }
    }
}
