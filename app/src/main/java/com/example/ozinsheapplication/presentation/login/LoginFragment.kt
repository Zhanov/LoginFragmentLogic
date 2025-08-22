package com.example.ozinsheapplication.presentation.login

import android.os.Bundle
import android.os.Message
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ozinsheapplication.R
import com.example.ozinsheapplication.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loginResponce.observe(viewLifecycleOwner) {
            binding.validationPassword.visibility = View.GONE
            Toast.makeText(requireContext(),"$it",Toast.LENGTH_SHORT).show()
            it.accessToken
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
        viewModel.errorResponce.observe(viewLifecycleOwner) {
            showError(it)
        }


        binding.btnShowPassword.setOnClickListener {
            togglePasswordVisibility()
        }
        binding.bntLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()


            val emailIsValid = emailValidation(email)
            val passwordIsValid = validationPassword(password)

            if (emailIsValid && passwordIsValid) {
                viewModel.loginUser(email, password)
            } else {
                validationEmail(emailIsValid)
            }
        }
    }


    fun togglePasswordVisibility() {
        val passwordEditText = binding.editTextPassword
        passwordEditText.transformationMethod = if (passwordEditText.transformationMethod == HideReturnsTransformationMethod.getInstance()) {
            PasswordTransformationMethod.getInstance()
        } else {
            HideReturnsTransformationMethod.getInstance()
        }
    }

    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    fun emailValidation(email: String): Boolean {
        return email.trim().matches(emailPattern.toRegex())
    }
    fun validationEmail(isValid: Boolean) {
        if (isValid) {
            binding.tvErrorTextEmail.text = ""
            binding.tvErrorTextEmail.visibility = View.GONE
            binding.editTextEmail.setBackgroundResource(R.drawable.background_edittext_focus_action_12dp)
        } else {
            binding.tvErrorTextEmail.text = "Қате формат"
            binding.tvErrorTextEmail.visibility = View.VISIBLE
            binding.editTextEmail.setBackgroundResource(R.drawable.background_edittext_12dp_error)

        }
    }
    fun validationPassword(password: String):Boolean {
        if (password.length < 8) {
            binding.validationPassword.text = "құпия сөзіңіздің ұзындығы 8 таңбадан аз"
            binding.validationPassword.setBackgroundResource(R.drawable.background_edittext_12dp_error)
            binding.validationPassword.visibility = View.VISIBLE
            return false
        } else {
            binding.validationPassword.visibility = View.GONE
            binding.editTextPassword.setBackgroundResource(R.drawable.background_edittext_focus_action_12dp)
            return true
        }
    }
    fun showError(message: String) {
        binding.validationPassword.text = message
    }
}
