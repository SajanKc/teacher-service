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
package com.iamsajan.teacherservice.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * <<Description Here>>
 * 
 * @author sajan
 * @version
 * @since , May 4, 2022
 */
@Data
public class TeacherCreateDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;
  private String profilePicture;
}
