package com.barista;

import com.barista.service.ExecuteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
@Profile("!test")
public class DemoApplication implements CommandLineRunner {


	
	
	@Autowired
	private ExecuteService executeService;
	@Autowired
	private LoadData loadData;
	
  
    public static void main(String[] args) throws Exception {

     
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

   }
  
    @Override
    public void run(String... args) throws Exception {
   	 	
    	boolean loadDataResult = loadData.loadData();
    	if (!loadDataResult) {
    		System.out.println("Loading of data on startup failed, please contact System Admin, call 867-5309");
    		System.exit(0);
    	}
    	   
    	
    	executeService.processMain();
     	

        
    }
}