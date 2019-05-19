# homeCredit-MYusuf

first open cmd 

-cd <to folder></br>
-git clone https://github.com/alvafrokerz/homeCredit-MYusuf.git</br>
-open the folder </br>
-import db_home_credit.sql to your mySql</br>
  
-open your intelij</br>
-open as project</br>
-open project->src->main->resources->application.properties</br>
-edit as for your environment</br>

  spring.jpa.properties.hibernate.format_sql=true</br>
  spring.jpa.show-sql=true</br>
  spring.datasource.url=jdbc:mysql://localhost:3306/db_home_credit</br>
  spring.datasource.username=root</br>
  spring.datasource.password=<your mysql password></br>
  server.port = 8081</br>
  
-cd to clone folder or use terminal in intelij project</br>
-type mvn clean package</br>
-type mvn spring-boot:run</br>

-after run the project </br>
-look there are folder dokumentasi you can look the api doc in "Doc API Home Credit.docx"</br>
-or if you use postman you can use my export postman with name "expor_dokumentasi_postman" i use postman v 2.1</br>
