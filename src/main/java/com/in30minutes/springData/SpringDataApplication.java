package com.in30minutes.springData;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in30minutes.springData.dataRepository.PersonSpringDataRepository;
import com.in30minutes.springData.entity.Person;


@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	@Autowired
	PersonSpringDataRepository repository;
	Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("persons object By Id from Database is --> {}",repository.findById(10001));

		
		logger.info("All persons object from Database is --> {}",repository.findAll());
		
		//save will acts similarily like  merge so if id will be matched it will over-ride the obj otherwise insert new obj
		logger.info("Saving new persons object to Database is --> {}",repository.save(new Person("Himanshu","India",new Date())));
		
		//Updating:Ecxample
		logger.info("Updating existing person object to Database is --> {}",repository.save(new Person(10002,"Mosh","USA",new Date())));
		
		
		System.out.println("Deleting a obj let it be 10003");
		repository.deleteById(10003);
	}

}
