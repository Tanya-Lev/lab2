package com.oop.laba2.lto.enteties

val namesOfSelections:ArrayList<String>
    get() {
        return arrayListOf<String>(
            "для Танюшки",
            "папе",
            "для Андрея",
            "мечты",
            "Инвестиции",
            "для Артёма"
        )
    }

data class Selection(
    var name:String?=null,
    var houses :MutableList<House>
){
    init {
        if(name == null)
            this.name = namesOfSelections.random()
    }
}
