package com.project.demobank.service

import com.project.demobank.repository.BankData
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    private val bankData: BankData = mockk(relaxed = true)
    private val bankService = BankService(bankData)

    @Test
    fun `should be able to retrieve banks`() {

        bankService.getBanks()
        // then
        verify(exactly = 1) { bankData.getBanks() }

    }
}