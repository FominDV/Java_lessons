import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "name", source = "userName")
    DTO entityToDto(Entity entity);

}
