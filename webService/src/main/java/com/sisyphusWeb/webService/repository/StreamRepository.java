package com.sisyphusWeb.webService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisyphusWeb.webService.model.table.StreamItem;

public interface StreamRepository extends JpaRepository<StreamItem, Integer>{

}
