package edu.miu.cse.democonnectwithazure.controller;

import edu.miu.cse.democonnectwithazure.dto.request.CourseRequestDTO;
import edu.miu.cse.democonnectwithazure.dto.response.CourseResponseDTO;
import edu.miu.cse.democonnectwithazure.model.Course;
import edu.miu.cse.democonnectwithazure.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public String crateCourse(@ModelAttribute CourseRequestDTO courseRequestDTO) {
        courseService.createCourse(courseRequestDTO);
        return "redirect:/api/v1/courses"; //redirect to path /api/v1/courses (request method will be GET)
    }

    @GetMapping
    public String getCourses(Model model) {
//        model.addAttribute("courses", courseService.getAllCourses());
        List<CourseResponseDTO> courseResponseDTOs = courseService.getAllCourses();
        model.addAttribute("courseResponseDTOs", courseResponseDTOs);
        return "result_page";
    }
}
