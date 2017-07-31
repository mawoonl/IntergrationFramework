package nl.mawoo.jerome.engine;

import com.google.inject.AbstractModule;

public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(PluginLoaderInterface.class).to(PluginLoaderService.class);
    }
}
