package ua.demo.mapper;

import org.mapstruct.Context;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import ua.demo.dto.UserDto;
import ua.demo.entity.User;
import ua.demo.mapper.context.MappingContext;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDto userDto, @Context MappingContext context);

    UserDto fromUser(User user);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    List<UserDto> fromUserList(List<User> users);
}
