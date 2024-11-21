package edu.miu.cse.democonnectwithazure.dto.request;

public record CourseRequestDTO(
        String courseName,
        String courseCode,
        String courseDescription
) {
}
