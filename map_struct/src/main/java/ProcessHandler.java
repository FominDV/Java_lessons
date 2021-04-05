import java.time.LocalDate;

public class ProcessHandler {

    public static void main(String[] args) {
        Entity entity = new Entity("05.04.2021 22.24", "Gosha", new EntityCat("Tom", 7), new CarEn("bmw", 1212));
        DTO dto = UserMapper.INSTANCE.entityToDto(entity);
        System.out.println(dto);
        dto.getCat().setName("Jorge");
        Entity entity2 = UserMapper.INSTANCE.dtoToEntity(dto);
        System.out.println(entity2);
    }
}
