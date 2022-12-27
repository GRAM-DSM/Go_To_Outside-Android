package com.gram.presentation.view.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gram.presentation.R
import com.gram.presentation.base.BaseActivity
import com.gram.presentation.databinding.ActivityMainStudentBinding
import com.gram.presentation.databinding.FragmentMainStudentPassBinding
import com.gram.presentation.databinding.FragmentMainStudentPassDefaultBinding
import com.gram.presentation.util.setLoggedOut
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentMainActivity : BaseActivity<ActivityMainStudentBinding>(
    R.layout.activity_main_student,
) {

    private lateinit var passFragment: PassFragment

    private lateinit var defaultFragment: DefaultFragment

    override fun initView() {
        //todo temporary code


        binding.containerMainStudentPass.setOnClickListener {

        }
        passFragment = PassFragment()
    }

    override fun onResume() {
        super.onResume()

    }


    private fun updatePass() {

        // todo observe viewmodel

        supportFragmentManager.beginTransaction().replace(
            binding.containerMainStudentPass.id,
            passFragment,
        ).commitAllowingStateLoss()
    }
}

class PassFragment : Fragment() {

    private lateinit var binding: FragmentMainStudentPassBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainStudentPassBinding.inflate(
            inflater,
            container,
            false,
        )

        return binding.root
    }
}

class DefaultFragment : Fragment() {

    private lateinit var binding: FragmentMainStudentPassDefaultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainStudentPassDefaultBinding.inflate(
            inflater,
            container,
            false,
        )

        return binding.root
    }
}