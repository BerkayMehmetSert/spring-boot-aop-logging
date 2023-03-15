package com.bms.springbootaoplogging.model

import com.bms.springbootaoplogging.core.model.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Customer @JvmOverloads constructor(
    @Id
    val id: Int,
    val firstName: String,
    val lastName: String
) : BaseEntity {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Customer

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        return result
    }

    override fun toString(): String {
        return "Customer(id=$id, firstName='$firstName', lastName='$lastName')"
    }
}
