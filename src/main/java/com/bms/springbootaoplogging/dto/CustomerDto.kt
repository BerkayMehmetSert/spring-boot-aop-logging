package com.bms.springbootaoplogging.dto

import com.bms.springbootaoplogging.core.dto.Dto

data class CustomerDto(
    val id: Int,
    val firstName: String,
    val lastName: String
) : Dto
