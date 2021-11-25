package com.droiddev.cleanarchitecture.di

import android.content.Context
import com.droiddev.cleanarchitecture.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

}