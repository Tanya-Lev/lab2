package com.oop.laba2.lto.enteties

enum class cities{
    Москва,
    Донецк,
    Луганск,
    Макеевка
}
enum class prices(val priceCount:String){
    MALO("от 1 000 000р"),
    NORM("от 10 000 000р"),
    MNOGO("от 100 000 000р")
}
enum class names{
    Орехово,
    Луговое,
    Солнечное,
    Зеленый,

}

enum class statuses{
    Сдан,
    Свободен,
}


enum class complexes{
    Солнечное ,
    Серое ,
    Квадратный,
    Прайд,
    Лев,
}

val addresses:ArrayList<String>
    get() {
        return arrayListOf<String>(
            "ул. Люблинская 124, Москва",
            "ул. Седова 81б, Макеевка",
            "ул. Вавилова 9, Макеевка",
        )
    }

val infoArr:ArrayList<String>
    get() {
        return arrayListOf<String>(
            "7 квартир,  от 244 555 руб за м²",
            "2 квартиры,  от 244 777 руб за м²",
            "1 квартира,  254 000 руб за м²",
        )
    }


data class House(
    var city:String? = "Город",
    var price:String? = "от  1 123 123 руб.",
    var name:String? = "Домчик",
    var status:String?="Сдан",
    var complex:String?="Серое",
    var address:String?="ул 123",
    var info:String?="dh",
    var number:String?="numb"

){

    init {
        this.name = names.values()[(names.values().indices).random()].name
        this.city = cities.values()[(cities.values().indices).random()].name
        this.price = prices.values()[(prices.values().indices).random()].priceCount
        this.status = statuses.values()[(statuses.values().indices).random()].name
        this.complex = "ЖК \""+complexes.values()[(complexes.values().indices).random()].name+"\""
        this.address = addresses.random()
        this.info = infoArr.random()
        this.number = "ФЗ-"+(233..250).random().toString()
    }
}

