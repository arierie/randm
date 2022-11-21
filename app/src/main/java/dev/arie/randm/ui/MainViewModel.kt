package dev.arie.randm.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.arie.randm.model.Characters
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetCharacterUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(Characters(listOf()))
    val uiState: StateFlow<Characters> = _uiState.asStateFlow()

    fun loadCharacters() {
        useCase.getCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _uiState.value = it
            }, {
                Log.e(TAG, "loadCharacters: error-${it.message}")
            })
    }
}
