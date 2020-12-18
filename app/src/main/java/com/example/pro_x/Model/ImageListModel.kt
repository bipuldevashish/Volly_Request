package com.example.pro_x.Model

class ImageListModel (

            var id: Int,

            var mediumUrl: String,

            var largeUrl: String,

    ) {

        override fun toString(): String {
            return "ImageListModel(id='$id', mediumUrl='$mediumUrl', largeUrl='$largeUrl')"
        }

    }