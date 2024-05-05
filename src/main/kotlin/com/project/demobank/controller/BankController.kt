package com.project.demobank.controller

import com.project.demobank.model.Bank
import com.project.demobank.service.BankService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class BankController(private val bankService: BankService) {

    @RequestMapping(method = [RequestMethod.GET],value= ["/banks"])
    fun getBanks(): Collection<Bank> {
        println(bankService.getBanks())
        return bankService.getBanks();
    }

    @RequestMapping(method = [RequestMethod.GET],value= ["/banks/{accountNumber}"])
    fun getBank(@PathVariable accountNumber: String): Bank {
        return bankService.getBank(accountNumber);
    }

    @RequestMapping("POST","/banks")
    fun createBank(@RequestBody bank: Bank): Collection<Bank> {
        return bankService.createBank(bank);
    }

    @RequestMapping(method = [RequestMethod.PUT],value  = ["/banks/{accountNumber}"])
    fun updateBank(@PathVariable accountNumber: String ,@RequestBody bank: Bank): Bank {
        return bankService.updateBank(accountNumber,bank);
    }

    @RequestMapping(method = [RequestMethod.DELETE],value  = ["/banks/{accountNumber}"])
    fun deleteBank(@PathVariable accountNumber: String): Collection<Bank> {
        return bankService.deleteBank(accountNumber);
    }



}