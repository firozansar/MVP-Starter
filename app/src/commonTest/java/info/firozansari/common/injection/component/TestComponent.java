package info.firozansari.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import info.firozansari.common.injection.module.ApplicationTestModule;
import info.firozansari.injection.component.ApplicationComponent;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}