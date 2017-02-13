package info.firozansari.ui.main;

import java.util.List;

import info.firozansari.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showPokemon(List<String> pokemon);

    void showProgress(boolean show);

    void showError(Throwable error);

}