package com.API.examregister;

import com.API.examregister.Controllers.ExamController;
import com.API.examregister.Entites.Exam;
import com.API.examregister.Services.ExamService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExamController.class)
class ExamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExamService examService;

    @Test
    void createExam() throws Exception {
        Exam exam = new Exam();
        exam.setExamId(1L);

        when(examService.createExam(anyLong())).thenReturn(exam);

        mockMvc.perform(post("/api/exams/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void registerExam() throws Exception {
        Exam exam = new Exam();
        exam.setExamId(1L);

        when(examService.RegisterStudent(anyLong(), anyLong())).thenReturn(exam);

        mockMvc.perform(post("/api/exams/1/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }
}
