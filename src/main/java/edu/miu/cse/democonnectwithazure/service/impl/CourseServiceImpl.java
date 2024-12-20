package edu.miu.cse.democonnectwithazure.service.impl;

import edu.miu.cse.democonnectwithazure.dto.request.CourseRequestDTO;
import edu.miu.cse.democonnectwithazure.dto.response.CourseResponseDTO;
import edu.miu.cse.democonnectwithazure.model.Course;
import edu.miu.cse.democonnectwithazure.repository.CourseRepository;
import edu.miu.cse.democonnectwithazure.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;


    @Override
    public Optional<CourseResponseDTO> createCourse(CourseRequestDTO courseRequestDTO) {
        Course course = new Course(
                courseRequestDTO.courseName(),
                courseRequestDTO.courseName(),
                courseRequestDTO.courseDescription()
        );
        Course savedCourse = courseRepository.save(course);
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO(
                savedCourse.getCourseName(),
                savedCourse.getCourseCode()
        );
        return Optional.of(courseResponseDTO);
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResponseDTO> courseResponseDTOs = new ArrayList<>();
        for (Course course : courses) {
            CourseResponseDTO courseResponseDTO = new CourseResponseDTO(course.getCourseName(), course.getCourseCode());
            courseResponseDTOs.add(courseResponseDTO);
        }
        return courseResponseDTOs;
    }
}
