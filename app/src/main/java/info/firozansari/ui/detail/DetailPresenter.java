package info.firozansari.ui.detail;

import javax.inject.Inject;

import info.firozansari.data.DataManager;
import info.firozansari.data.model.Pokemon;
import info.firozansari.data.model.Statistic;
import info.firozansari.injection.ConfigPersistent;
import info.firozansari.ui.base.BasePresenter;
import info.firozansari.util.rx.scheduler.SchedulerUtils;

@ConfigPersistent
public class DetailPresenter extends BasePresenter<DetailMvpView> {

    private final DataManager mDataManager;

    @Inject
    DetailPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(DetailMvpView mvpView) {
        super.attachView(mvpView);
    }

    void getPokemon(String name) {
        checkViewAttached();
        getMvpView().showProgress(true);
        mDataManager.getPokemon(name)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(pokemon -> {
                    // It should be always checked if MvpView (Fragment or Activity) is attached.
                    // Calling showProgress() on a not-attached fragment will throw a NPE
                    // It is possible to ask isAdded() in the fragment, but it's better to ask in the presenter
                    getMvpView().showProgress(false);
                    getMvpView().showPokemon(pokemon);
                    for (Statistic statistic : pokemon.stats) {
                        getMvpView().showStat(statistic);
                    }
                }, throwable -> {
                    getMvpView().showProgress(false);
                    getMvpView().showError(throwable);
                });
    }
}
