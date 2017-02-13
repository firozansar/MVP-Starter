package info.firozansari.injection.component;

import dagger.Subcomponent;
import info.firozansari.injection.PerFragment;
import info.firozansari.injection.module.FragmentModule;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

}