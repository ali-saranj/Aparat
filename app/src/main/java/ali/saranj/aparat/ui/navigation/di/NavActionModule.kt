package ali.saranj.aparat.ui.navigation.di

import ali.saranj.aparat.ui.navigation.NavAction
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NavActionModule {


    @Singleton
    @Provides
    fun provideNavAction(): NavAction = NavAction()

}