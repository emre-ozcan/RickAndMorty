package com.emreozcan.emreozcan.common.utils

interface Mapper<F, T> {
    fun map(from: F): T
}
