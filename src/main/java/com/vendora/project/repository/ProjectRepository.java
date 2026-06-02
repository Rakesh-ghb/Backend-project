package com.vendora.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vendora.project.entity.Project;

public interface ProjectRepository
        extends JpaRepository<Project, Integer> {
}
