package info.firozansari.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import info.firozansari.data.DataManager;
import info.firozansari.data.remote.MvpStarterService;
import info.firozansari.injection.ApplicationContext;
import info.firozansari.injection.module.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();

    DataManager dataManager();

    MvpStarterService mvpBoilerplateService();
}
