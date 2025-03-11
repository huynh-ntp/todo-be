package com.huynhntp.todobe.service;

import com.huynhntp.todobe.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    TransactionDTO createTransaction(TransactionDTO transactionDTO);
    TransactionDTO updateTransaction(String id, TransactionDTO transactionDTO);
    TransactionDTO getTransactionById(String id);
    List<TransactionDTO> getAllTransactions();
    void deleteTransaction(String id);
    List<TransactionDTO> getTransactionsByAccountId(String accountId);
}