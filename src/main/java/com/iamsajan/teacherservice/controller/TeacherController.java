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

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.iamsajan.teacherservice.dto.TeacherCreateDto;
import com.iamsajan.teacherservice.dto.TeacherResponseDto;
import com.iamsajan.teacherservice.dto.TeacherResponseListDto;
import com.iamsajan.teacherservice.dto.TeacherUpdateDto;
import com.iamsajan.teacherservice.helper.FileUploadHelper;
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

  @Autowired
  private FileUploadHelper fileUploadHelper;

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

  @PutMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public TeacherResponseDto updateTeachers(@PathVariable Long id,
      @RequestBody TeacherUpdateDto teacherUpdateDto) {
    return teacherService.updateTeacher(id, teacherUpdateDto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deleteTeachersById(@PathVariable Long id) throws Exception {
    teacherService.deleteTeacherById(id);
  }

  @DeleteMapping
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deleteTeachers(@RequestBody List<Long> teacherIds) {
    teacherService.deleteTeachers(teacherIds);
  }

  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    try {
      if (file.isEmpty()) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Request must contain file");
      }
      if (!file.getContentType().equals("image/jpg") && !file.getContentType().equals("image/jpeg")
          && !file.getContentType().equals("image/png")) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Only jpeg, jpg, png allowed");
      }
      // file upload
      return ResponseEntity.ok(fileUploadHelper.uploadFile(file));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Could not store file " + file + ". Please try again!");
  }

}
