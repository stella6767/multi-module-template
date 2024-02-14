package freeapp.life.multimodules.entity

import jakarta.persistence.*

@Entity
@Table(name = "todo")
class Todo(
    content:String,
    status:Boolean = false,
    user: User,
) : BaseEntity() {


    @Column
    var content = content

    @Column
    var status: Boolean = status


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user = user


}