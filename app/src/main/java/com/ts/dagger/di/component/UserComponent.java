package com.ts.dagger.di.component;

import com.ts.dagger.LoginActivity;
import com.ts.dagger.MainActivity;
import com.ts.dagger.di.PerActivity;
import com.ts.dagger.di.module.UserModule;

import dagger.Component;

@PerActivity
@Component(modules = {UserModule.class},dependencies = AppComponent.class)
public interface UserComponent {

    void inject(LoginActivity activity);

}
