
package com.project;

import configuration.DriverContext;
import pageRepository.linkedinPage;
import org.testng.annotations.*;




public class Sampletest {
    @Test
    public void main() {


        try {


            DriverContext.setDriver("Chrome", "https://www.linkedin.com/");
            linkedinPage.steps()
            .login("username","password");
          
           
            DriverContext.closeDriver();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
