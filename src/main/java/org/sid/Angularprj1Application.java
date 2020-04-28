package org.sid;

import org.sid.dao.MarqueRepository;
import org.sid.entities.Marque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Angularprj1Application implements CommandLineRunner  {

	@Autowired
	private MarqueRepository marqueRepository ;
	public static void main(String[] args) {
		SpringApplication.run(Angularprj1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		marqueRepository.save(new Marque("aa11","../../assets/imgs/APPLE.jpg"));
		marqueRepository.save(new Marque("aa22","../../assets/imgs/WIKO.jpg"));
		marqueRepository.save(new Marque("aa33","../../assets/imgs/ALCATEL.jpg"));
		marqueRepository.save(new Marque("aa33","../../assets/imgs/SAMSUNG.jpg"));
		marqueRepository.findAll().forEach(c->{
			System.out.println(c.getName());
		});
		
	}

}
