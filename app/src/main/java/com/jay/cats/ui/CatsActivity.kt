package com.jay.cats.ui

import com.base.library.ui.BaseActivity
import com.jay.cats.R
import com.jay.cats.databinding.ActivityCatsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatsActivity : BaseActivity<ActivityCatsBinding, CatsViewModel>(
    R.layout.activity_cats
)