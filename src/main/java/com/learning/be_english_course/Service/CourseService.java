package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.course.dtoCreateCourse;
import com.learning.be_english_course.DTO.request.course.dtoUpdateCourse;
import com.learning.be_english_course.DTO.respone.course.dtoCourseUser;
import com.learning.be_english_course.DTO.respone.course.dtoFilter;
import com.learning.be_english_course.DTO.respone.course.dtoTotalCourseLevel;
import com.learning.be_english_course.Entity.Course;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EntityMapping entityMapping;

    // tong so khoa hoc
    public Integer count() {
        Integer count = 0 ;
        List<Course> courses = courseRepository.findAll();
        for (Course course : courses) {
            count++;
        }
        return count;
    }
    // ds theo khoa hoc
    public List<dtoTotalCourseLevel> totalCourseLevel() {
        List <dtoTotalCourseLevel> totalCourseLevel = courseRepository.courselevel();
        return totalCourseLevel;
    }
    //ds khoa hoc
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
    //lay theo id
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(()->new RuntimeException("Không tìm thấy khóa học với id = " + id));
    }
    //lay theo idUser
    public List<dtoCourseUser> findUserId(long userId) {
        return courseRepository.findCourseByUser(userId);
    }
    //tao moi
    public Course createCourse(dtoCreateCourse request, String imageUrl) {
        if (courseRepository.existsByCourseName(request.getCourseName())) {
            throw new RuntimeException("Tên khóa học đã tồn tại!");}
        Course course = entityMapping.DTOtoCreateCourse(request);
        course.setImgUrl(imageUrl);
        course.setCreatedAt(LocalDateTime.now());
        return courseRepository.save(course);
    }
    //cap nhat
    private boolean hasNewImage(String imageUrl){
        return imageUrl != null && !imageUrl.trim().isEmpty();
    }
    public Course updateCourse(long id,dtoUpdateCourse request , String imageUrl) {
        Course course = courseRepository.findById(id).orElseThrow(()->new RuntimeException("Không tìm thấy khóa học với id = " + id));
        if (courseRepository.existsByCourseNameAndCourseIdNot(request.getCourseName(),id)) {
            throw new RuntimeException("Tên khóa học đã tồn tại!");}
        entityMapping.DTOtoUpdateCourse(course,request);
        if (hasNewImage(imageUrl)) {
            course.setImgUrl(imageUrl);
        }
        return courseRepository.save(course);
    }
    // xoa
    public void deleteCourse(long id) {
        if(!courseRepository.existsById(id)){
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        courseRepository.deleteById(id);
    }
    // tim kiem
    public List<Course> searchQuick(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return List.of();}
        return courseRepository.findTop10ByCourseNameContainingIgnoreCase(keyword.trim());
    }

    //lay ngau nhien 8 khoa hoc
    public List<Course> getRandom8Courses() {
        return courseRepository.findRandom8Courses();
    }

    //tao bo loc khoa hoc
    public List<dtoFilter> filterCourses(
            String courseName,
            String level,
            String keyword,
            Long price
    ) {
        return courseRepository
                .findAll(CourseFilter.filter(courseName, level, keyword, price))
                .stream()
                .map(course -> new dtoFilter(
                        course.getImgUrl(),
                        course.getCourseName(),
                        course.getLevel(),
                        course.getPrice()
                ))
                .toList();
    }

}
