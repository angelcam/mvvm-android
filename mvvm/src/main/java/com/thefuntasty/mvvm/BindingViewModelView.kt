package com.thefuntasty.mvvm

import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

interface BindingViewModelView<VM : BaseViewModel<*>, B : ViewDataBinding> : ViewModelView<VM>, BaseView {

    var binding: B

    fun inflateBindingLayout(layoutInflater: LayoutInflater): B?

    fun setupBindingView(layoutInflater: LayoutInflater, set: (B) -> Unit): View? {
        return inflateBindingLayout(layoutInflater)?.let {
            binding = it
            set(binding)
            binding.root
        }
    }
}
