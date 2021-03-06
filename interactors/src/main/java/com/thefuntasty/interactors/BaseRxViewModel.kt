package com.thefuntasty.interactors

import androidx.lifecycle.LiveData
import com.thefuntasty.interactors.disposables.DisposablesOwner
import com.thefuntasty.mvvm.BaseViewModel
import com.thefuntasty.mvvm.ViewState
import io.reactivex.disposables.CompositeDisposable

/**
 * Base ViewModel class prepared for providing data to UI through [LiveData] and
 * obtaining data from Stores (Repositories) by executing RxJava based interactors
 * eg. [BaseObservabler].
 */
abstract class BaseRxViewModel<S : ViewState> : BaseViewModel<S>(), DisposablesOwner {

    /**
     * CompositeDisposable of all recently executed interactors which is cleared when
     * ViewModel is no longer used and will be destroyed.
     */
    override val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
