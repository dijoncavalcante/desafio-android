package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.ApiService
import com.picpay.desafio.android.data.datasource.ContactDataSourceImpl
import com.picpay.desafio.android.data.repository.ContactRepositoryImpl
import com.picpay.desafio.android.data.service.PicPayService
import com.picpay.desafio.android.domain.datasource.ContactDataSource
import com.picpay.desafio.android.domain.repository.ContactRepository
import com.picpay.desafio.android.domain.useCase.ContactUseCase
import com.picpay.desafio.android.domain.useCase.ContactUseCaseImpl
import com.picpay.desafio.android.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}
val useCaseModule = module {
    factory<ContactUseCase> {
        ContactUseCaseImpl(get())
    }
}

val repositoryModule = module {
    factory<ContactRepository> {
        ContactRepositoryImpl(get())
    }
}

val dataSourceModule = module {
    factory<ContactDataSource> {
        ContactDataSourceImpl(get())
    }
}

val serviceModule = module {
    single { ApiService().initRetrofit() }
    single<PicPayService> { get<Retrofit>().create(PicPayService::class.java) }
}

val daoModule = module {
    single { /*TaskDataBase.getInstance(androidContext()).taskDao*/ }
}