package com.sisyphusWeb.webService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisyphusWeb.webService.model.table.Queue;

public interface QueueRepository extends JpaRepository<Queue, String>{

}
