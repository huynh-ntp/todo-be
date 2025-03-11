package com.huynhntp.todobe.service.impl;

import com.huynhntp.todobe.dto.TransactionDTO;
import com.huynhntp.todobe.entity.Transaction;
import com.huynhntp.todobe.mapper.TransactionMapper;
import com.huynhntp.todobe.repository.TransactionRepository;
import com.huynhntp.todobe.service.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = transactionMapper.toEntity(transactionDTO);
        transaction = transactionRepository.save(transaction);
        return transactionMapper.toDTO(transaction);
    }

    @Override
    public TransactionDTO updateTransaction(String id, TransactionDTO transactionDTO) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with id: " + id));

        Transaction updatedTransaction = transactionMapper.toEntity(transactionDTO);
        updatedTransaction.setId(existingTransaction.getId());
        updatedTransaction = transactionRepository.save(updatedTransaction);

        return transactionMapper.toDTO(updatedTransaction);
    }

    @Override
    public TransactionDTO getTransactionById(String id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with id: " + id));
        return transactionMapper.toDTO(transaction);
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(transactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTransaction(String id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with id: " + id));
        transaction.setIsDeleted(true);
        transactionRepository.save(transaction);
    }

    @Override
    public List<TransactionDTO> getTransactionsByAccountId(String accountId) {
        return transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getAccountId().equals(accountId))
                .map(transactionMapper::toDTO)
                .collect(Collectors.toList());
    }
}