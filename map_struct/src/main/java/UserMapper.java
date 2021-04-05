import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "name", source = "userName")
    @Mapping(source = "carEn.car", target = "car")
    @Mapping(source = "carEn.carNumber", target = "carNumber")
    @Mapping(source = "catEn", target = "cat")
    DTO entityToDto(Entity entity);

    @InheritInverseConfiguration
    Entity dtoToEntity(DTO dto);


}
