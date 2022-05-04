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
package com.iamsajan.teacherservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Sajan K.C.
 * @version V1.0.0
 * @since V1.0.0, May 4, 2022
 */

@Data
@Entity
@NoArgsConstructor
public class Teacher {
  @Id
  @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
  private Long id;
  private String name;
  private String image;

}
