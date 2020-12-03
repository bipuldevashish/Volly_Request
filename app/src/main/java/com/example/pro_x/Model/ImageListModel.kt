package com.example.pro_x.Model

class ImageListModel {

    lateinit var id : String
    lateinit var mediumUrl : String
    lateinit var largeUrl : String

    constructor(id: String, mediumUrl: String, largeUrl: String) {
        this.id = id
        this.mediumUrl = mediumUrl
        this.largeUrl = largeUrl
    }


}