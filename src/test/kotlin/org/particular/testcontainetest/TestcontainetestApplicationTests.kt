package org.particular.testcontainetest

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.particular.testcontainetest.model.Cliente
import org.particular.testcontainetest.repo.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.time.LocalDate
import java.time.Month

@SpringBootTest
@Testcontainers
class TestcontainetestApplicationTests(
	@Autowired
	val repo: ClienteRepository)
{
	companion object {
		@Container
		val container = PostgreSQLContainer<Nothing>("postgres:12").apply {
			withDatabaseName("testdb")
			withUsername("user")
			withPassword("s3Cr&t")
		}

		@JvmStatic
		@DynamicPropertySource
		fun properties(registry: DynamicPropertyRegistry) {
			registry.add("spring.datasource.url", container::getJdbcUrl)
			registry.add("spring.datasource.password", container::getPassword)
			registry.add("spring.datasource.username", container::getUsername)
			registry.add("spring.jpa.hibernate.ddl-auto") { "create" }
		}
	}

	@Test
	fun shouldReturAllClients() {
		repo.save(Cliente("Fulano", LocalDate.of(1980, Month.APRIL, 10)))
		repo.save(Cliente("Ciclano", LocalDate.of(1982, Month.DECEMBER, 22)))

		val clientes = repo.findAll().toList()
		assertEquals(2, clientes.count())
		assertEquals("Fulano", clientes[0].nome)
		assertEquals("Ciclano", clientes[1].nome)
	}

}
