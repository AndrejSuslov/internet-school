package by.andron.mapper;

import by.andron.model.Course;
import by.andron.dto.CourseCreationDto;
import by.andron.dto.CourseDto;
import by.andron.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "SPRING", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {

    @Mapping(target = "teacher", source = "teacherId", qualifiedByName = "mapTeacherIdToTeacher")
    Course toEntity(CourseCreationDto dto);

    @Mapping(target = "teacherId", source = "teacher", qualifiedByName = "mapTeacherToTeacherId")
    CourseDto toDto(Course course);

    @Named("mapTeacherIdToTeacher")
    default User mapTeacherIdToTeacher(Long userId) {
        User user = new User();
        user.setId(userId);
        return user;
    }

    @Named("mapTeacherToTeacherId")
    default Long mapTeacherToTeacherId(User user) {
        return user.getId();
    }

}
