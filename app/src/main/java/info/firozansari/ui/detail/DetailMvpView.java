package info.firozansari.ui.detail;

import info.firozansari.data.model.Pokemon;
import info.firozansari.data.model.Statistic;
import info.firozansari.ui.base.MvpView;

public interface DetailMvpView extends MvpView {

    void showPokemon(Pokemon pokemon);

    void showStat(Statistic statistic);

    void showProgress(boolean show);

    void showError(Throwable error);

}