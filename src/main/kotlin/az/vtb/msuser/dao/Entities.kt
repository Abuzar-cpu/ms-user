package az.vtb.msuser.dao

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Table(name = "users")
@Entity
data class UserEntity (
    @Id
    val username: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val cashAccount: String,

    @field: CreationTimestamp
    val createdAt: LocalDateTime,

    @field: UpdateTimestamp
    val updatedAt: LocalDateTime
)
