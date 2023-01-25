package com.enigmacamp.mynews.presentation.newssource

import androidx.lifecycle.*
import com.enigmacamp.mynews.common.ViewState
import com.enigmacamp.mynews.data.model.Source
import com.enigmacamp.mynews.data.repository.newsSource.NewsSourceRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsSourceViewModel @AssistedInject constructor(
    @Assisted val category: String, private val repository: NewsSourceRepository
) : ViewModel() {
    private var _result = MutableLiveData<ViewState<List<Source>>>()
    val result: LiveData<ViewState<List<Source>>>
        get() = _result

    init {
        getAllNewsSource()
    }

    private fun getAllNewsSource() {
        viewModelScope.launch {
            _result.postValue(ViewState.Loading)
            val result = repository.getNewsSourceByCategory(category)
            result.fold(onSuccess = {
                _result.postValue(ViewState.Success(it))
            }, onFailure = {
                _result.postValue(ViewState.Error(it.message.toString()))
            })
        }
    }

    fun findNewsSource(title: String) {
        viewModelScope.launch {
            _result.postValue(ViewState.Loading)
            val result = repository.findNewsSourceByCategoryAndTitle(category, title)
            result.fold(onSuccess = {
                _result.postValue(ViewState.Success(it))
            }, onFailure = {
                _result.postValue(ViewState.Error(it.message.toString()))
            })
        }
    }

    companion object Factory {
        fun factory(viewModel: NewsSourceViewModel) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return viewModel as T
            }
        }
    }
}