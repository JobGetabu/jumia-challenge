package android.ptc.com.ptcflixing.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import android.ptc.com.ptcflixing.data.remote.Resource
import android.ptc.com.ptcflixing.data.repository.Repository
import android.ptc.com.ptcflixing.model.product.ProductResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

       private var _productLiveData =MutableLiveData<Resource<ProductResponse>>()

      val productLiveData: LiveData<Resource<ProductResponse>>
      get() = _productLiveData

        fun getProduct(sku: Int) {

            viewModelScope.launch {
                try {
                _productLiveData.postValue(Resource.loading(null))
                repository.getProductDetails(sku).let {
                    if (it.isSuccessful) {
                        _productLiveData.postValue(Resource.success(it.body()))
                    } else {
                        _productLiveData.postValue(Resource.error(it.errorBody().toString(), null))
                    }

                }
                } catch (ce: CancellationException) {
                    throw ce // Needed for coroutine scope cancellation
                } catch (e: Exception) {
                    _productLiveData.postValue(Resource.error(e.localizedMessage?.toString()!!, null))

                }

            }
        }

}

