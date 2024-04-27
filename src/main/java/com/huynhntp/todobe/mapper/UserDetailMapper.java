package com.huynhntp.todobe.mapper;

import com.huynhntp.todobe.dto.UserDetailDTO;
import com.huynhntp.todobe.entity.UserDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDetailMapper {
    UserDetail toEntity(UserDetailDTO userDetailDTO);

    UserDetailDTO toDto(UserDetail userDetail);
}
