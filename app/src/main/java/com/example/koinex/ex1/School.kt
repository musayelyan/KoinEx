package com.example.koinex.ex1

class School constructor(val teacher: Teacher) {
    fun schoolWork() {
        teacher.teach()
    }
}