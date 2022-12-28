package com.gram.presentation.view.register

import android.view.View
import androidx.fragment.app.Fragment
import com.gram.presentation.R
import com.gram.presentation.base.BaseActivity
import com.gram.presentation.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(
    com.gram.presentation.R.layout.activity_register,
) {

    override fun initView() {
        with(binding) {

            changeFragment()
            // initiating beginning value
            includedRegisterHeader.run {
                tvHeaderPrimary.text = getString(R.string.register_register)
                tvHeaderSecondary.text = getString(R.string.register_who_are_you_what)
            }
            btnRegisterAction.visibility = View.GONE
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            com.gram.presentation.R.id.container_register_label, fragment,
        ).commitAllowingStateLoss()
    }
}
