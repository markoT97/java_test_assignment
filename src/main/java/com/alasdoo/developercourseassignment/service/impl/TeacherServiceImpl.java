package com.alasdoo.developercourseassignment.service.impl;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.entity.Teacher;
import com.alasdoo.developercourseassignment.mapper.TeacherMapper;
import com.alasdoo.developercourseassignment.repository.TeacherRepository;
import com.alasdoo.developercourseassignment.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    public TeacherDTO findOne(Integer id) {
        return null;
    }

    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(teacher -> teacherMapper.transformToDTO(teacher)).collect(Collectors.toList());
    }

    public TeacherDTO save(TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.transformToEntity(teacherDTO);
        return teacherMapper.transformToDTO(teacherRepository.save(teacher));
    }

    public void remove(Integer id) throws IllegalArgumentException {
    }

    public TeacherDTO update(Integer id, TeacherDTO teacherDTO) {
        return null;
    }

    public TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname) {
        return null;
    }

    public TeacherDTO findByTeacherEmail(String email) {
        return null;
    }
}
