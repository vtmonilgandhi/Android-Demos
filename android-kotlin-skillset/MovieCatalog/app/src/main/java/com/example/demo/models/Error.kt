package com.example.demo.models

enum class Error(private val code: Int, private val description: String) {
    NULL_FIELD(0, "can't be null."),
    BLANK_FIELD(1, "can't be blank."),
    NO_INTERNET(2, "Check Your Internet Connection"),
    NO_DATA(3,"No Data Fetched"),
    NULL_RESPONSE(0, "Response is null.");

    override fun toString(): String {
        return "$description"
    }
}