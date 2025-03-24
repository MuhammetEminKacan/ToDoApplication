package com.mek.todoapplication.di

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(localDataSource: LocalDataSource){
    val localdatasource = localDataSource
}