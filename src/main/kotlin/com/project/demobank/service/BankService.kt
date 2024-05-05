package com.project.demobank.service

import com.project.demobank.model.Bank
import com.project.demobank.repository.BankData
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class BankService(@Qualifier("apiData") private val bankData: BankData) {
    fun getBanks(): Collection<Bank> {
        return bankData.getBanks()
    }

    fun getBank(accountNumber: String): Bank {
        return bankData.getBank(accountNumber)
    }

    fun updateBank(accountNumber: String, bank: Bank): Bank {
        return bankData.updateBank(accountNumber, bank)
    }

    fun deleteBank(accountNumber: String): Collection<Bank> {
        return bankData.deleteBank(accountNumber)
    }

    fun createBank(bank: Bank): Collection<Bank>  {
        return bankData.createBank(bank)
    }

}