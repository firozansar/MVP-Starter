package info.firozansari.injection.component;

import dagger.Subcomponent;
import info.firozansari.injection.PerActivity;
import info.firozansari.injection.module.ActivityModule;
import info.firozansari.ui.base.BaseActivity;
import info.firozansari.ui.detail.DetailActivity;
import info.firozansari.ui.main.MainActivity;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(BaseActivity baseActivity);

    void inject(MainActivity mainActivity);

    void inject(DetailActivity detailActivity);
}
