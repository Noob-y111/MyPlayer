package com.example.graduationdesign.base

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.imitationqqmusic.model.tools.ScreenUtils

abstract class BaseFragment: Fragment() {

    protected var toolbar: Toolbar? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        toolbar = getToolbarView()
        setTitle(getTitle())
        transparentActionBar()
    }

    private fun transparentActionBar() {
        toolbar?.fitsSystemWindows = true
        requireActivity().apply {
            (this as AppCompatActivity).setSupportActionBar(toolbar)
        }

        val window = requireActivity().window
        window?.decorView?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window?.statusBarColor = Color.TRANSPARENT
    }

    private fun setTitle(title: String){
        toolbar?.title = title
    }

    protected fun searchBoxWidth(view: View){
        val width = ScreenUtils.getWidth(requireActivity()) / 5 * 2
        view.layoutParams.width = width
    }

    abstract fun getTitle(): String
    abstract fun getToolbarView(): Toolbar

}