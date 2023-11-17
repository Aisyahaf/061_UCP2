package com.example.projectucp2.ui.layout

import androidx.lifecycle.ViewModel
import com.example.projectucp2.data.DataForm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {
    private  val _stateUI = MutableStateFlow(DataForm())
    val stateUI: StateFlow<DataForm> = _stateUI.asStateFlow()

    fun setDataMhs(list: MutableList<String>){
        _stateUI.update{
            stateUISaatIni ->stateUISaatIni.copy(
                nama = list[0],
                nim = list[1],
                konsentrasi = list[2],
                judul = list[3],
            )
        }
    }

    fun resetDataMhs(){
        _stateUI.value = DataForm()
    }

    fun setDosbim(DosbimPilihan: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(dosbim = DosbimPilihan)
        }
    }

    fun resetForm(){
        _stateUI.value = DataForm()
    }

}