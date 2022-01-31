package com.estudosAngular.API.Lives.repository;

import com.estudosAngular.API.Lives.entity.Lives;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LiveRepository extends JpaRepository<Lives, Long> {
    @Query(value = "select * from tb_live where data = curdate()", nativeQuery = true)
    Page<Lives> findLivesToday(Pageable pageable);

    @Query(value = "select * from tb_live where data > curdate() order by data desc", nativeQuery = true)
    Page<Lives> findLivesNext( Pageable pageable);


    @Query(value = "select * from tb_live  where data < curdate() order by data desc", nativeQuery = true)
    Page<Lives> findLivesPrevious( Pageable pageable);
}
