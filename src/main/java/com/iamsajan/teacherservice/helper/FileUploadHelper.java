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
package com.iamsajan.teacherservice.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * 
 * @author Sajan K.C.
 * @version V1.0.0
 * @since V1.0.0, May 7, 2022
 */

@Component
public class FileUploadHelper {

  public final String UPLOAD_DIR =
      new ClassPathResource("/static/images").getFile().getAbsolutePath();

  public FileUploadHelper() throws IOException {}

  public String uploadFile(MultipartFile multipartFile) {
    String renamedFile = new Date().getTime() + "-" + multipartFile.getOriginalFilename();
    try {
      Files.copy(multipartFile.getInputStream(),
          Paths.get(UPLOAD_DIR + File.separator + renamedFile),
          StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      e.printStackTrace();
    }
    String returnValue = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
        .path(renamedFile).toUriString();
    return returnValue;
  }
}
