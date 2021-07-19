package com.bishop.requestingapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bishop.requestingapp.api.RequestProvider
import com.bishop.requestingapp.models.Item
import com.bishop.requestingapp.models.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val itemsLiveData = MutableLiveData<List<Item>>()
    val studentsLiveData = MutableLiveData<List<Student>>()

//    val studentsLiveData = liveData<List<Student>> {
//        itemsLiveData.postValue(ServiceProvider.placeHolderApi.getItems())
//    }

    fun getItems() {
        CoroutineScope(Dispatchers.IO).launch {
            itemsLiveData.postValue(RequestProvider.apiRequests.getItems())
        }
    }

    fun addStudent(newStudent: Student) {
        CoroutineScope(Dispatchers.IO).launch {
            studentsLiveData.postValue(RequestProvider.apiRequests.addStudents(newStudent))
        }
    }
}