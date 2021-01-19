package com.example.koinex.ex1

class Student constructor(val friend: Friend, val schoolCourse: SchoolCourse) {

    fun beSmart() {
        schoolCourse.study()
        friend.hangOut()
    }
}