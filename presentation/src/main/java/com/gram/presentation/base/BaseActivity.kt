package com.gram.presentation.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding>(
    @LayoutRes private val layoutId: Int,
) : ComponentActivity() {

    protected val binding: B by lazy {
        DataBindingUtil.setContentView(
            this,
            layoutId,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        initView()
    }

    abstract fun initView()
}