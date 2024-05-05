package com.project.demobank.repository.api

import com.project.demobank.model.Bank
import com.project.demobank.repository.BankData
import com.project.demobank.repository.api.dto.BankDataDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("apiData")
class ApiBankData(@Autowired private val restTemplate: RestTemplate): BankData {
    override fun getBanks(): Collection<Bank> {
        var response = restTemplate.getForEntity<BankDataDTO>("https://www.mockapi.com/banks");
        return response.body?.results ?: throw IOException("api call did not return results");
    }

    override fun getBank(accountNumber: String): Bank {
        TODO("Not yet implemented")
    }

    override fun updateBank(accountNumber: String, bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun deleteBank(accountNumber: String): Collection<Bank> {
        TODO("Not yet implemented")
    }

    override fun createBank(bank: Bank): Collection<Bank> {
        TODO("Not yet implemented")
    }
}