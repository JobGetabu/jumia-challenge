package android.ptc.com.ptcflixing.screens.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import android.ptc.com.ptcflixing.data.remote.Resource
import android.ptc.com.ptcflixing.data.repository.Repository
import android.ptc.com.ptcflixing.model.configurations.Configurations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class ConfigurationsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private var _configurationsLiveData = MutableLiveData<Resource<Configurations>>()

    val configurationsLiveData: LiveData<Resource<Configurations>>
        get() = _configurationsLiveData

     fun addConfigurations() = viewModelScope.launch {
         try {
         _configurationsLiveData.postValue(Resource.loading(null))

         repository.getConfigurations().let {
             if (it.isSuccessful) {
                 _configurationsLiveData.postValue(Resource.success(it.body()))
             } else {
                 _configurationsLiveData.postValue(Resource.error(it.errorBody().toString(), null))
             }
         }
         } catch (ce: CancellationException) {
             throw ce // Needed for coroutine scope cancellation
         } catch (e: Exception) {
             _configurationsLiveData.postValue(Resource.error(e.localizedMessage?.toString()!!, null))

         }

    }

    private var _insertLiveData = MutableLiveData<Long>()

    val insertLiveData: LiveData<Long>
        get() = _insertLiveData

    fun cacheConfigurations(response: Configurations) = viewModelScope.launch {
        repository.cacheConfigurations(response = response).let {
            _insertLiveData.value = it
        }
    }

    private var _readConfigurationsLiveData = MutableLiveData<Configurations>()

    val readConfigurationsLiveData: LiveData<Configurations>
        get() = _readConfigurationsLiveData

    fun readConfigurations() =
        viewModelScope.launch {
            repository.readConfigurations.collect{
                _readConfigurationsLiveData.value = it
            }
        }

}