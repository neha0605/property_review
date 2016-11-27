CREATE TABLE review (
id INTEGER NOT NULL,
name varchar(20) DEFAULT NULL,
propertyName varchar(10) DEFAULT NULL,
createdon datetime DEFAULT NULL,
updatedon datetime DEFAULT NULL,
clientId int NOT NULL,
phoneNumber varchar(255) DEFAULT NULL,
userReview text DEFAULT NULL,
PRIMARY KEY (id)
)
