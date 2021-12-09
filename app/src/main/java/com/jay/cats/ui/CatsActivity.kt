package com.jay.cats.ui

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.base.library.ui.BaseActivity
import com.jay.cats.R
import com.jay.cats.databinding.ActivityCatsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CatsActivity : BaseActivity<ActivityCatsBinding, CatsViewModel>(
    R.layout.activity_cats
) {
    private val adapter: CatsAdapter by lazy { CatsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        setupObserve()
    }

    private fun setupUi() {
        binding.rvCatList.adapter = adapter
    }

    private fun setupObserve() {
        lifecycleScope.launch {
            viewModel.fetchCats().distinctUntilChanged().collectLatest {
                adapter.submitData(it)
            }
        }
    }

}