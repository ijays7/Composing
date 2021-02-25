package com.ijays.composeit.state.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ijays.composeit.data.Person
import com.ijays.composeit.data.getSuperheroesList
import kotlinx.coroutines.delay

/**
 * Created by ijays on 2021/1/25.
 */
class SuperheroesViewModel : ViewModel() {
    val superheroes: LiveData<List<Person>> = liveData {
        val superheroesList = loadSuperheroes()
        emit(superheroesList)
    }

    suspend fun loadSuperheroes(): List<Person> {
        // delay 2 seconds to emulate network request
        delay(2000)
        return getSuperheroesList()
    }

}