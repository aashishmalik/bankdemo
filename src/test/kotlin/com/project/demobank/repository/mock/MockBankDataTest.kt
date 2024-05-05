package com.project.demobank.repository.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockBankDataTest {

    @Test
    fun `should provide a collection`() {

        // when
        val banks = MockBankData().getBanks()

        // then
        assertThat(banks).isNotEmpty
    }

}