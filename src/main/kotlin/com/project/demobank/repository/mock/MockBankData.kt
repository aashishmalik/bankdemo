package com.project.demobank.repository.mock

import com.project.demobank.model.Bank
import com.project.demobank.repository.BankData
import org.springframework.stereotype.Repository

@Repository
class MockBankData: BankData {

        var banks = mutableListOf(
            Bank("1234", 3.0, 1),
            Bank("1010", 0.0, 100),
            Bank("5678", 0.4, 10)
        );

        override fun getBanks(): Collection<Bank> = banks

        override fun getBank(accountNumber: String): Bank {
                return banks.firstOrNull() { it.accountNumber == accountNumber }
                        ?: throw NoSuchElementException("Could not find bank with account number $accountNumber")
        }

        override fun updateBank(accountNumber: String, bank: Bank): Bank {
                val currentBank = banks.firstOrNull() { it.accountNumber == accountNumber }
                        ?: throw NoSuchElementException("Could not find bank with account number $accountNumber")
                banks.remove(currentBank)
                banks.add(bank)
                return bank
        }

        override fun deleteBank(accountNumber: String): Collection<Bank> {
                banks.removeIf { it.accountNumber == accountNumber }
                return banks
        }

        override fun createBank(bank: Bank): Collection<Bank> {
                banks.add(bank)
                return banks
        }
}