package info.firozansari;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

import info.firozansari.injection.component.ApplicationComponent;
import info.firozansari.injection.component.DaggerApplicationComponent;
import info.firozansari.injection.module.ApplicationModule;
import timber.log.Timber;

public class MvpStarterApplication extends Application {

    ApplicationComponent mApplicationComponent;

    public static MvpStarterApplication get(Context context) {
        return (MvpStarterApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Stetho.initializeWithDefaults(this);
            LeakCanary.install(this);
        }
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
