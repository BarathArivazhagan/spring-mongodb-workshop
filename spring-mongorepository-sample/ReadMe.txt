

SIMPLE SPRING MONGODB SAMPLE USING MONGODBREPOSITORY 


Run as --> Spring Boot App 


App uses MongoDBAutoConfiguration feature connecting to localhost:27017 , 
override the properties in application.properties to connect to differnet mongodb connection 

PORT : 8081 (configured in application.properties  )

End points :  

ADD USER: 

http://localhost:8081/addUser -- > POST 
PayLoad: 

{
  "userId": 100,
  "userName": "Barath"

}

READ USER [GET]:

http://localhost:8081/getUser?id=<<USER ID >>

http://locahost:8082/gtUser?name="<<USER NAME >>"

UPDATE USER :

http://localhost:8081/updateUser -- > POST 
PayLoad: 

{
  "userId": 100,
  "userName": "SACHIN"

}


FIND ALL USERS :

http://localhost:8081/findAll
