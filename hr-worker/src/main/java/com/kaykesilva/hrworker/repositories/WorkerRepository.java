package com.kaykesilva.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaykesilva.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
