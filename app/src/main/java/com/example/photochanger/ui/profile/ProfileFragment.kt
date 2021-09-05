package com.example.photochanger.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.photochanger.databinding.FragmentProfileBinding
import com.example.photochanger.ui.common.BaseFragment
import com.example.photochanger.ui.profile.adapter.PhotoAdapter
import com.livermor.delegateadapter.delegate.CompositeDelegateAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    companion object {
        private const val COUNT_TABLE = 3
    }

    private val viewModel by viewModel<ProfileViewModel>()

    private val adapter by lazy {
        CompositeDelegateAdapter(
            PhotoAdapter()
        )
    }
    private val layoutManager by lazy {
        GridLayoutManager(this.requireContext(), COUNT_TABLE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        listenModels()
    }

    private fun initViews(){
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    private fun listenModels(){
        viewModel.photoUrls.observe(viewLifecycleOwner, adapter::swapData)
    }
}