package com.example.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.binder.test.InputDestination
import org.springframework.cloud.stream.binder.test.OutputDestination
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration
import org.springframework.context.annotation.Import
import org.springframework.messaging.support.GenericMessage
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@Import(TestChannelBinderConfiguration::class)
@TestPropertySource(
		properties = ["spring.cloud.function.definition = function"]
)
class DemoApplicationTests {
	@Autowired
	private lateinit var input: InputDestination

	@Autowired
	private lateinit var output: OutputDestination

	@Test
	fun contextLoads() {
	}

	@Test
	fun testEmptyConfiguration() {
		input.send(GenericMessage("hello"))
		assertThat(output.receive().getPayload()).isEqualTo("HELLO".toByteArray())
	}

}
