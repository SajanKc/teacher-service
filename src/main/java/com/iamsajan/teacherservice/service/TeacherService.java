/*************************************************************************
 * 
 * AADIM INNOVATION CONFIDENTIAL __________________
 *
 * All Rights Reserved.
 * 
 * NOTICE: All information contained here in is, and remains the property of Aadim Innovation and
 * its suppliers, if any. The intellectual and technical concepts contained here in are proprietary
 * to Aadim Innovation. Dissemination of this information or reproduction of this material is
 * strictly forbidden unless prior written permission is obtained from Aadim Innovation.
 * 
 */
package com.iamsajan.teacherservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iamsajan.teacherservice.dto.TeacherCreateDto;
import com.iamsajan.teacherservice.dto.TeacherResponseDto;
import com.iamsajan.teacherservice.dto.TeacherResponseListDto;
import com.iamsajan.teacherservice.entity.Teacher;
import com.iamsajan.teacherservice.repository.TeacherRepository;

/**
 * 
 * @author Sajan K.C.
 * @version V1.0.0
 * @since V1.0.0, May 4, 2022
 */

@Service
public class TeacherService {

  @Autowired
  private TeacherRepository teacherRepository;

  /**
   *
   * @param teacher
   * @return
   * @author Sajan K.C.
   * @since V1.0.0, Modified In: @version, By @author
   */
  private TeacherResponseDto getTeacherResponseDto(Teacher teacher) {
    TeacherResponseDto response = new TeacherResponseDto();

    response.setId(teacher.getId());
    response.setName(teacher.getName());
    response.setProfilePicture(teacher.getProfilePicture());

    return response;
  }

  /**
   * Add new Teacher
   * 
   * @param teacher
   * @author Sajan K.C.
   * @return
   * @since V1.0.0, Modified In: @version, By @author
   */
  public TeacherResponseDto addNewTeacher(TeacherCreateDto teacherCreateDto) {
    Teacher teacher = new Teacher();
    teacher.setName(teacherCreateDto.getName());
    teacher.setProfilePicture(teacherCreateDto.getProfilePicture());

    Teacher savedTeacher = teacherRepository.save(teacher);

    return getTeacherResponseDto(savedTeacher);
  }

  /**
   *
   * @return list all teachers
   * @author Sajan K.C.
   * @since V1.0.0, Modified In: @version, By @author
   */
  public TeacherResponseListDto getTeachers() {
    List<TeacherResponseDto> teacherResponseList = new ArrayList<>();

    List<Teacher> teachers = teacherRepository.findAll();

    for (Teacher teacher : teachers) {
      teacherResponseList.add(getTeacherResponseDto(teacher));
    }

    TeacherResponseListDto response = new TeacherResponseListDto();
    response.setTeachers(teacherResponseList);
    response.setTotal(teacherResponseList.size());

    return response;
  }

  /**
   *
   * @param id
   * @author Sajan K.C.
   * @throws Exception
   * @since V1.0.0, Modified In: @version, By @author
   */
  public void deleteTeacherById(Long id) throws Exception {
    Optional<Teacher> teacher = teacherRepository.findById(id);
    if (teacher.isPresent())
      teacherRepository.deleteById(id);
    else
      throw new Exception("teacher with id " + id + " not found");
  }

}
