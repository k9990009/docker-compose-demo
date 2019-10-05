package com.example.dockerdemo.repository;

import com.example.dockerdemo.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *
 * </p>
 *
 * @author k9
 * @since 2019-09-30
 */
public interface TestRepository extends JpaRepository<Test,Long> {
}
