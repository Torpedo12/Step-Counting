package com.example.practical_12

public class Model {
    lateinit var id:String
    lateinit var First_name:String
    lateinit var Last_name:String
    lateinit var phone_no:String
    lateinit var address:String


    constructor(id: String,First_name:String,Last_name:String, phone_no:String, address:String) {
        this.id = id
        this.First_name = First_name
        this.Last_name = Last_name
        this.phone_no = phone_no
        this.address = address
    }

    constructor()
}
