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
package com.iamsajan.teacherservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.iamsajan.teacherservice.dto.TeacherCreateDto;
import com.iamsajan.teacherservice.dto.TeacherResponseDto;
import com.iamsajan.teacherservice.dto.TeacherResponseListDto;
import com.iamsajan.teacherservice.service.TeacherService;

/**
 * 
 * @author Sajan K.C.
 * @version V1.0.0
 * @since V1.0.0, May 4, 2022
 */

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

  @Autowired
  private TeacherService teacherService;

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public TeacherResponseDto addTeachers(@RequestBody TeacherCreateDto teacher) {
    return teacherService.addNewTeacher(teacher);
  }

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public TeacherResponseListDto getTeachers() {
    return teacherService.getTeachers();
  }

}
