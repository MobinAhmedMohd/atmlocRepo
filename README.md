Steps to run the Project:

1.	Please clone the atmloc project.
2.	Import atmloc project into STS/Eclipse as existing Maven Project.
3.	I have used Mysql database for this project. Please check the added sql file 'AtmDBScript.zip' for atms database. Please execute the script into mysql database. Check the schema atms is created in your local.
4.	Once everything is ready, please run the file AtmlocApplication.java file 

Run the following APIs From postman:
1.	http://localhost:8080/atmdetails (To get all Cities Data)
2.	http://localhost:8080/atmdetails?city=Bodegraven (To get the list of Atms based on filter applied on city)
