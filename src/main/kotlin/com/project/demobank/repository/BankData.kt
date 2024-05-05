package com.project.demobank.repository

import com.project.demobank.model.Bank

interface BankData {

    fun getBanks(): Collection<Bank>

    fun getBank(accountNumber: String): Bank

    fun updateBank(accountNumber: String, bank: Bank): Bank

    fun deleteBank(accountNumber: String): Collection<Bank>

    fun createBank(bank: Bank): Collection<Bank>

}