package com.incode.gopoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.incode.gopoint.model.User;
import com.incode.gopoint.repository.UserRepository;

@SpringBootApplication
public class GopointApplication implements CommandLineRunner {

	 @Autowired
	    private UserRepository userRepository;

	    public static void main(String[] args) {
	        SpringApplication.run(GopointApplication.class, args);
	    }

	    @Override
	    public void run(String... args) throws Exception {
	        // Criar um novo usuário
	        User user = new User();
	        user.setNome("Test User");
	        user.setEmail("test@example.com");
	        user.setSenha("password");

	        // Salvar o usuário no banco de dados
	        User savedUser = userRepository.save(user);

	        // Verificar se o usuário foi salvo corretamente
	        if (savedUser != null && savedUser.getIduser() > 0) {
	            System.out.println("Usuário salvo com sucesso:");
	            System.out.println("ID: " + savedUser.getIduser());
	            System.out.println("Nome: " + savedUser.getNome());
	            System.out.println("Email: " + savedUser.getEmail());
	        } else {
	            System.out.println("Falha ao salvar o usuário.");
	        }
	    }

}
