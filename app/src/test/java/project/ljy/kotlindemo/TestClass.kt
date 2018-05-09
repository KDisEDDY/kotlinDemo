package project.ljy.kotlindemo

import android.util.Log

/**
 * ClassName: TestClass
 * function:
 * Created by EDDY
 * CreateTime:2018/5/9
 */
class TestClass() {

    private var age : Int = 0
    lateinit private var name : String

    constructor(name : String) : this() {
        this.name = name
        System.out.println("name is $name,Main Constructor is called.")
    }

    constructor(name : String , age : Int):this(name){
        this.age = age
        this.name = name
        System.out.println("name is $name,age is $age, child Constructor is called.")
    }

}
