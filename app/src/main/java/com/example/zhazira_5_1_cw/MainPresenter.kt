package com.example.zhazira_5_1_cw

import android.graphics.Color

class MainPresenter {

    val model = CounterModel()
    private var contract: CounterContract? = null
    private var view: CounterContract? = null

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
            10 -> view?.showToast("Поздравляем!")
            15 -> view?.changeTextColor(Color.GREEN)
            else -> view?.changeTextColor(Color.BLACK)
        }

    }

}