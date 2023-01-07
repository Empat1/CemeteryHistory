package com.example.cemeteryhistory



public const val MESSAGE = 1
public const val IMAGE = 2


data class Message(var text:String, var person:String ) {
    var type:Int = 0

    constructor(text:String , _type: Int) : this(text, "") {
        type = _type
    }

}