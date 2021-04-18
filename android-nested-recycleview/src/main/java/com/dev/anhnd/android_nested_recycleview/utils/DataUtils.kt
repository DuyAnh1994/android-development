package com.dev.anhnd.android_nested_recycleview.utils

import com.dev.anhnd.android_nested_recycleview.R
import com.dev.anhnd.android_nested_recycleview.model.Continents
import com.dev.anhnd.android_nested_recycleview.model.Nation

object DataUtils {

    val continents = mutableListOf(
        Continents(name = "Asia", nations = mutableListOf(
            Nation(flag = R.drawable.ic_nation_bahrain, "Bahrain"),
            Nation(flag = R.drawable.ic_nation_japan, name = "Japan"),
            Nation(flag = R.drawable.ic_nation_india, name = "India"),
            Nation(flag = R.drawable.ic_nation_malaysia, name = "Malaysia"),
            Nation(flag = R.drawable.ic_nation_myanmar, name = "Myanmar"),
            Nation(flag = R.drawable.ic_nation_north_korea, name = "North Korea"),
            Nation(flag = R.drawable.ic_nation_philippines, name = "Philippines"),
            Nation(flag = R.drawable.ic_nation_saudi_arabia, name = "Saudio Arabia"),
            Nation(flag = R.drawable.ic_nation_singapore, name = "Singapore"),
            Nation(flag = R.drawable.ic_nation_south_korea, name = "South Korea"),
            Nation(flag = R.drawable.ic_nation_vietnam, name = "Viet Nam")
        )),
        Continents(name = "Africa", nations = mutableListOf(
            Nation(flag = R.drawable.ic_nation_south_africa, "South Africa"),
        )),
        Continents("Europa", mutableListOf(
            Nation(flag = R.drawable.ic_nation_czech_republic, name = "Czech Republic"),
            Nation(flag = R.drawable.ic_nation_france, name = "France"),
            Nation(flag = R.drawable.ic_nation_germany, name = "Germany"),
            Nation(flag = R.drawable.ic_nation_greece, name = "Greece"),
            Nation(flag = R.drawable.ic_nation_italy, name = "Italy"),
            Nation(flag = R.drawable.ic_nation_portugal, name = "Portugal"),
            Nation(flag = R.drawable.ic_nation_romania, name = "Romania"),
            Nation(flag = R.drawable.ic_nation_spain, name = "Spain"),
            Nation(flag = R.drawable.ic_nation_switzerland, name = "Switzerland"),
            Nation(flag = R.drawable.ic_nation_ukraine, name = "Ukraine")
        )),
        Continents("North America", mutableListOf(
            Nation(flag = R.drawable.ic_nation_canada, name = "Canada"),
            Nation(name = "USA")
        )),
        Continents("South America", mutableListOf(
            Nation(flag = R.drawable.ic_nation_argentina, name = "Argentina"),
            Nation(flag = R.drawable.ic_nation_colombia, name = "Colombia"),
            Nation(flag = R.drawable.ic_nation_panama, name = "Panama")
        ))
    )
}