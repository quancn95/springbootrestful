package com.fre18.quannt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.fre18.qnt.daoimpl.StudentDaoImpl;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
@ComponentScan( basePackages={"com.fre18"})
public class SpringbootclientApplication implements CommandLineRunner {
	@Autowired
	StudentDaoImpl studentDaoImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootclientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(studentDaoImpl.findAll());
		
	}
}
