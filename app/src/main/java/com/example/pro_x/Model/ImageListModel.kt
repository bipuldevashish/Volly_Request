package com.example.pro_x.Model

class ImageListModel {

    var id : Int = 0
    lateinit var mediumUrl : String
    lateinit var largeUrl : String

    constructor(id: Int, mediumUrl: String, largeUrl: String) {
        this.id = id
        this.mediumUrl = mediumUrl
        this.largeUrl = largeUrl
    }

}