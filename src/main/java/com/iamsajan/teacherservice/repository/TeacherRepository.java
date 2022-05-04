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
package com.iamsajan.teacherservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iamsajan.teacherservice.entity.Teacher;

/**
 * @author Sajan K.C.
 * @version V1.0.0
 * @since V1.0.0, May 4, 2022
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
