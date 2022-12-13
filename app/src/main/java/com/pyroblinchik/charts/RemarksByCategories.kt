package com.pyroblinchik.charts

class RemarksByCategories {
    constructor()
    constructor(id: Int, categoryName: String?, remarksCount: Int?){
        this.id = id
        this.categoryName = categoryName
        this.remarksCount = remarksCount
    }

    var id: Int = 0
    var categoryName : String? = null
    var remarksCount : Int? = null
}