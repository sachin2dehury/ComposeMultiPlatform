import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import data.AnimeService
import data.AnimeService.Companion.BASE_URL
import data.repository.DetailRepository
import data.repository.DetailRepositoryImpl
import data.repository.PaginatedRepository
import data.repository.PaginatedRepositoryImpl
import domain.usecase.DetailUseCase
import domain.usecase.DetailUseCaseImpl
import okhttp3.OkHttpClient
import presentation.detail.DetailViewModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object AppModule {

    val okHttpClient = OkHttpClient.Builder().build()

    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val moshiConverterFactory = MoshiConverterFactory.create(moshi)

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(moshiConverterFactory)
        .build()

    val service = retrofit.create(AnimeService::class.java)

    val detailRepository: DetailRepository = DetailRepositoryImpl(service)

    val paginatedRepository: PaginatedRepository = PaginatedRepositoryImpl(service)

    val detailUseCase: DetailUseCase = DetailUseCaseImpl(detailRepository)
    val viewModel = DetailViewModel(AppModule.detailUseCase)

}