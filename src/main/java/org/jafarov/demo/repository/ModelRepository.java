package org.jafarov.demo.repository;

import org.jafarov.demo.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModelRepository extends JpaRepository<Model, Long> {
}
