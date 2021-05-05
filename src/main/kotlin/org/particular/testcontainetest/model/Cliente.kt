package org.particular.testcontainetest.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tb_cliente")
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val nascimento: LocalDate
) {
    constructor(nome: String, nascimento: LocalDate): this(null, nome, nascimento)
}
