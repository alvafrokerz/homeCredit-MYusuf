# homeCredit-MYusuf

first open cmd 

-cd <to folder>
-git clone https://github.com/alvafrokerz/homeCredit-MYusuf.git
-open the folder 
-import db_home_credit.sql to your mySql
  
-open your intelij
-open as project
-open project->src->main->resources->application.properties
-edit as for your environment

  spring.jpa.properties.hibernate.format_sql=true
  spring.jpa.show-sql=true
  spring.datasource.url=jdbc:mysql://localhost:3306/db_home_credit
  spring.datasource.username=root
  spring.datasource.password=
  server.port = 8081
  
-cd to clone folder or use terminal in intelij project
-type mvn clean package
-type mvn spring-boot:run

-after run the project 
-look there are folder dokumentasi you can look the api doc in "Doc API Home Credit.docx"
-or if you use postman you can use my export postman with name "expor_dokumentasi_postman" i use postman v 2.1
