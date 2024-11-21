package edu.miu.cse.democonnectwithazure.repository;

import edu.miu.cse.democonnectwithazure.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
