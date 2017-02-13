package info.firozansari.data;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import info.firozansari.data.model.Pokemon;
import info.firozansari.data.remote.MvpStarterService;
import io.reactivex.Single;

@Singleton
public class DataManager {

    private final MvpStarterService mMvpStarterService;

    @Inject
    DataManager(MvpStarterService mvpStarterService) {
        mMvpStarterService = mvpStarterService;
    }

    public Single<List<String>> getPokemonList(int limit) {
      return mMvpStarterService.getPokemonList(limit)
              .toObservable()
              .flatMapIterable(namedResources -> namedResources.results)
              .map(namedResource -> namedResource.name)
              .toList();
    }

    public Single<Pokemon> getPokemon(String name) {
        return mMvpStarterService.getPokemon(name);
    }

}
