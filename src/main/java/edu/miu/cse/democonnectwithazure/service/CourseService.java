package edu.miu.cse.democonnectwithazure.service;

import edu.miu.cse.democonnectwithazure.dto.request.CourseRequestDTO;
import edu.miu.cse.democonnectwithazure.dto.response.CourseResponseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<CourseResponseDTO> createCourse(CourseRequestDTO courseRequestDTO);
    List<CourseResponseDTO> getAllCourses();
}
