package com.nvnrdhn.starwars.people.search

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.nvnrdhn.starwars.di.PeopleDependencies

class PeopleSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        PeopleDependencies.init()

        setContent {
            PeopleSearchLayout()
        }
    }
}