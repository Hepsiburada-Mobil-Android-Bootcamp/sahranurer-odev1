package com.sahraer.bootcampodevler.livedataexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel :ViewModel() {
    var number = 0
    //livedata , programı bir şeyin değiştiğini gerçekten bildirmek için kullanılır
    //otomotik olarak gerçekleştirecektir.
    val currentNumber:MutableLiveData<Int> by lazy {MutableLiveData<Int>()}
    //her atıfta bulunduğumuzda değiştirilebilir bir canlı veri nesnesi oluşturucak ve numarayı tutmak
    //ve güncellemek için kullanılıyor

    val currentBoolean:MutableLiveData<Boolean> by lazy {MutableLiveData<Boolean>()}

}