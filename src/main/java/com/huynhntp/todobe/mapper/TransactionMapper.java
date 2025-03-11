package com.huynhntp.todobe.mapper;

import com.huynhntp.todobe.dto.TransactionDTO;
import com.huynhntp.todobe.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(source = "category.id", target = "categoryId")
    TransactionDTO toDTO(Transaction transaction);

    @Mapping(target = "category.id", source = "categoryId")
    Transaction toEntity(TransactionDTO transactionDTO);
}