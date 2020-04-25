package com.in30minutes.springData.dataRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in30minutes.springData.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person,Integer> {

}
