package com.jay.cats.ui

import android.os.Bundle
import com.base.library.ui.BaseActivity
import com.jay.cats.R
import com.jay.cats.databinding.ActivityCatsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatsActivity : BaseActivity<ActivityCatsBinding, CatsViewModel>(
    R.layout.activity_cats
) {

    private val adapter: CatsAdapter by lazy {
        CatsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        setupObserve()
    }

    private fun setupUi() {
        binding.rvCatList.adapter = adapter
    }

    private fun setupObserve() {
        viewModel.cats.observe(this) {
            adapter.updateItems(it)
        }
    }

}