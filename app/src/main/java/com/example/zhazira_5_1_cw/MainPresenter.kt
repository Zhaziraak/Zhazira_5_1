package com.example.zhazira_5_1_cw

import android.graphics.Color

class MainPresenter {

    val model = CounterModel()
    private var contract: CounterContract? = null

    fun attachContract(contract: CounterContract){
        this.contract = contract
        contract.showResult(model.count)
    }

    fun onIncrement(){
        model.increment()
        contract?.showResult(model.count)
        checkConditions(model.count)

    }

    fun onDecrement(){
        model.decrement()
        contract?.showResult(model.count)
        checkConditions(model.count)
    }

    fun detachContract(){
        this.contract = null
    }

    fun checkConditions(value: Int) {
        when (value) {
            10 -> contract?.showToast("Поздравляем!")
            15 -> contract?.changeTextColor(Color.GREEN)
            else -> contract?.changeTextColor(Color.BLACK)
        }

    }

}