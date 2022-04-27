package com.gustavo.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
