package freeapp.life.multimodules.entity

import freeapp.life.multimodules.entity.type.SignType
import jakarta.persistence.*

@Entity
@Table(name = "user")
class User(
    id: Long = 0,
    username: String,
    email: String?,
    password: String,
    rawData: String,
    signType: SignType,
    role: Role = Role.USER,
) : BaseEntity(id) {

    @Column(nullable = false)
    val username = username

    @Column(nullable = true, length = 100)
    val email = email

    @Column(nullable = false, length = 100)
    val password = password

    @Column(length = 5000)
    val rawData = rawData

    @Enumerated(EnumType.STRING)
    private val role = role

    @Enumerated(EnumType.STRING)
    private val signType = signType

    enum class Role {
        USER, ADMIN
    }


}