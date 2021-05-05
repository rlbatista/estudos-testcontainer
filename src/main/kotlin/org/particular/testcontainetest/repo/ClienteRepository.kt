package org.particular.testcontainetest.repo

import org.particular.testcontainetest.model.Cliente
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository : CrudRepository<Cliente, Long> {
}