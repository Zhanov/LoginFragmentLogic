package com.example.ozinsheapplication.presentation.adapterOnboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.transition.Visibility
import androidx.viewpager2.widget.ViewPager2
import com.example.ozinsheapplication.data.OnboardingInfoList
import com.example.ozinsheapplication.databinding.FragmentOnboardingBinding
import com.example.ozinsheapplication.R


class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnboardingAdapter()
        adapter.submitList(OnboardingInfoList.onboardingModelList)
        binding.viewPager2WelcomeFragment.adapter = adapter


        val viewPagerCallBack = object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == OnboardingInfoList.onboardingModelList.size - 1) {
                    binding.btnSkipOnboarding.visibility = View.INVISIBLE
                    binding.bntNextPageOnboarding.visibility = View.VISIBLE
                }
                else {
                    binding.btnSkipOnboarding.visibility = View.VISIBLE
                    binding.bntNextPageOnboarding.visibility = View.INVISIBLE
                }
            }

        }

        binding.dotsIndicator.setViewPager2(binding.viewPager2WelcomeFragment)
        binding.viewPager2WelcomeFragment.registerOnPageChangeCallback(viewPagerCallBack)


        binding.btnSkipOnboarding.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_loginFragment)

        }
        binding.bntNextPageOnboarding.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_loginFragment)
        }
    }
}