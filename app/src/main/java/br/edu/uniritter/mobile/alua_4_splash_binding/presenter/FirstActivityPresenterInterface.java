package br.edu.uniritter.mobile.alua_4_splash_binding.presenter;

import android.content.Context;

import java.util.List;

import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classAlbums;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classComments;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classPhotos;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classPosts;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classTodos;
import br.edu.uniritter.mobile.alua_4_splash_binding.classGroup.classUsers;

public interface FirstActivityPresenterInterface {
    interface FirstActivityPresenterView {
        public void bindAlbums(List<classAlbums> albums);
        public void bindComments(List<classComments> comments);
        public void bindPhotos(List<classPhotos> photos);
        public void bindPosts(List<classPosts> posts);
        public void bindTodos(List<classTodos> todos);
        public void bindUsers(List<classUsers> users);
        public void mostraToast(String msg);
        public Context getContexto();
    }

    interface FirstActivityPresenterPresenter {
        public void start();
        public void encerrar();
    }
}
