package com.blog.blogging;

import com.blog.blogging.config.AppConstants;
import com.blog.blogging.entity.Role;
import com.blog.blogging.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BloggingBackendApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(BloggingBackendApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception{
		try{
			Role role = new Role();
			role.setId(AppConstants.USER_ADMIN);
			role.setName("USER_ADMIN");

			Role role1 = new Role();
			role.setId(AppConstants.USER_NORMAL);
			role.setName("USER_NORMAL");

			List<Role> roles = List.of(role,role1);
			this.roleRepository.saveAll(roles);
		}
		catch(Exception ex){
			ex.getMessage();
		}

	}

}
