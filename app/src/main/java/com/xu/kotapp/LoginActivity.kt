package com.xu.kotapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.xu.kotapp.databinding.ActivityLoginBinding
import splitties.activities.start
import splitties.toast.toast

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initView()

    }

    private fun initView() {
        binding.rbSecret.isChecked = true
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_code -> changeText(R.id.rb_code)
                R.id.rb_secret -> changeText(R.id.rb_secret)
            }
        }

        binding.btnForgetPwd.setOnClickListener {
            if (binding.rbSecret.isChecked) {
                // 挑战忘记密码页面
                start<ForgetPwdActivity> { putExtra("tel", binding.etTel.text.toString()) }
            } else {
                // 获取验证码

            }
        }
    }

    private fun changeText(rbCode: Int) {
        when (rbCode) {
            R.id.rb_code -> {
                binding.tvSecret.text = "验证码:"
                binding.btnForgetPwd.text = "获取验证码"
                binding.etPwd.hint = "请输入验证码"
                binding.ckRemember.isGone = true
            }
            R.id.rb_secret -> {
                binding.tvSecret.text = "密码:"
                binding.btnForgetPwd.text = "忘记密码"
                binding.etPwd.hint = "请输入密码"
                binding.ckRemember.isGone = false
            }
        }
    }
}