package com.oop.laba2.lto

interface SelectionCallback {
    fun pressDelete(index:Int)
    fun pressEditName(index:Int)
    fun pressShare(index:Int)
}