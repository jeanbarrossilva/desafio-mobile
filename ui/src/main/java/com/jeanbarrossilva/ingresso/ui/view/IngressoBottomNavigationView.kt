package com.jeanbarrossilva.ingresso.ui.view

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jeanbarrossilva.ingresso.extensions.context.colorOf
import com.jeanbarrossilva.ingresso.ui.R
import com.jeanbarrossilva.ingresso.ui.extensions.context.defaultRippleColor

class IngressoBottomNavigationView: BottomNavigationView {
    /** Short-hand for getting the theme secondary color through [colorOf]. **/
    private val secondaryColor
        get() = context.colorOf(R.attr.colorSecondary)

    /** Short-hand for getting the theme surface color through [colorOf]. **/
    private val surfaceColor
        get() = context.colorOf(R.attr.colorSurface)

    constructor(context: Context): super(context)

    constructor(context: Context, attrs: AttributeSet?): super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    init {
        itemIconTintList = ColorStateList.valueOf(secondaryColor)
        itemTextColor = ColorStateList.valueOf(secondaryColor)
        itemRippleColor = context.defaultRippleColor.let(ColorStateList::valueOf)
        setBackgroundColor(surfaceColor)
    }
}