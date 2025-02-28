package com.nhp.university.facilitymanagement.repository;

import com.nhp.university.facilitymanagement.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    // Lấy tất cả logs theo thứ tự mới nhất trước
    List<Log> findAllByOrderByTimestampDesc();
}
