package com.project.demobank.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.put


@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest {

        @Autowired
        lateinit var mockMvc: MockMvc // MockMvc is a Spring class that allows  us to test Spring MVC controllers without starting an actual HTTP server

        @Test
        fun `should return all banks`() {

                mockMvc.get("/api/banks")
                        .andDo { print() }
                        .andExpect {
                                status { isOk() }
                                jsonPath("$[0].accountNumber") { value("1234") }
                        }

        }

        @Test
        fun `should return the bank with the given account number`() {

                mockMvc.get("/api/banks/1234")
                        .andDo { print() }
                        .andExpect {
                                status { isOk() }
                                jsonPath("$.accountNumber") { value("1234") }
                        }

        }

        @Test
        fun `should update the bank with the given account number`() {

                mockMvc.put("/api/banks/1234") {
                        contentType = MediaType.APPLICATION_JSON
                        content = """
                                {
                                        "accountNumber": "123455",
                                        "trust": 3.0,
                                        "defaultInterestRate": 1
                                }
                        """.trimIndent()
                }
                .andDo { print() }
                .andExpect {
                        status { isOk() }
                        jsonPath("$.accountNumber") { value("123455") }
                }

        }

        @Test
        fun `should delete the bank with the given account number`() {

                mockMvc.delete("/api/banks/123455")
                        .andDo { print() }
                        .andExpect {
                                status { isOk() }
                                jsonPath("$[0].accountNumber") { value("1234") }
                        }

        }
}