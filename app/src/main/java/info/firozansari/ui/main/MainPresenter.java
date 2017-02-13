package info.firozansari.ui.main;

import java.util.List;

import javax.inject.Inject;

import info.firozansari.data.DataManager;
import info.firozansari.injection.ConfigPersistent;
import info.firozansari.ui.base.BasePresenter;
import info.firozansari.util.rx.scheduler.SchedulerUtils;

@ConfigPersistent
public class MainPresenter extends BasePresenter<MainMvpView> {

    private final DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    public void getPokemon(int limit) {
        checkViewAttached();
        getMvpView().showProgress(true);
        mDataManager.getPokemonList(limit)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(pokemons -> {
                  getMvpView().showProgress(false);
                  getMvpView().showPokemon(pokemons);
                }, throwable -> {
                  getMvpView().showProgress(false);
                  getMvpView().showError(throwable);
                });
    }

}
