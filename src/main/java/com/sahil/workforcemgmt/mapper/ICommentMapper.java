package com.sahil.workforcemgmt.mapper;

import com.sahil.workforcemgmt.dto.CommentDto;
import com.sahil.workforcemgmt.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ICommentMapper {
    ICommentMapper INSTANCE = Mappers.getMapper(ICommentMapper.class);

    CommentDto modelToDto(Comment model);

    Comment dtoToModel(CommentDto dto);

    List<CommentDto> modelListToDtoList(List<Comment> models);
}
