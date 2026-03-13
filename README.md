# Talent Booking System

A Spring Boot REST API application for managing talent bookings and events with location-based user management.

## Tested API 

### Pagination and Sort
```bash
PUT [http://localhost:8080/api/users?page=0&size=2](http://localhost:8080/api/users?page=0&size=10&sortBy=fullName)
```
<img width="906" height="875" alt="image" src="https://github.com/user-attachments/assets/a976c24a-8216-45a3-8c48-1573b73bc030" />


### existBy
```bash
PUT http://localhost:8080/api/users/check-email?email=uwase@gmail.com
```
<img width="1369" height="535" alt="image" src="https://github.com/user-attachments/assets/3fbea05a-42f2-43c0-ab46-fdff1ccc4f07" />

### FIND Users by Province CODE
```bash
PUT http://localhost:8080/api/users/by-province?code=KGL
```
<img width="909" height="866" alt="image" src="https://github.com/user-attachments/assets/e39bbea5-986a-4512-acc4-1f068415a5ea" />

### FIND Users by Province NAME
```bash
PUT[ http://localhost:8080/api/users/by-province?cnam=Kigali city](http://localhost:8080/api/users/by-province?name=Kigali City)
```
<img width="887" height="870" alt="image" src="https://github.com/user-attachments/assets/50dc1413-e7f9-49d5-84a1-7ae9d4b64cdb" />

### FIND Users by Province NAME
```bash
PUT[ http://localhost:8080/api/users/by-province?cnam=Kigali city](http://localhost:8080/api/users/by-province?name=Kigali City)](http://localhost:8080/api/locations/by-parent/ff5e4861-e78d-4fd9-b255-d6046ad4448b)
```
<img width="886" height="900" alt="image" src="https://github.com/user-attachments/assets/1bc89f19-23a6-41d6-8d40-d01770a82917" />

### FIND Users by Location (Any Level)
```bash
PUT[ http://localhost:8080/api/users/by-province?cnam=Kigali city](http://localhost:8080/api/users/by-province?name=Kigali City)](http://localhost:8080/api/locations/by-parent/ff5e4861-e78d-4fd9-b255-d6046ad4448b)](http://localhost:8080/api/users/by-location/0c96f1fb-1c1c-443a-bee5-f6b771b703ba)
```
<img width="950" height="908" alt="image" src="https://github.com/user-attachments/assets/b92cc1dd-0946-44ce-85fa-89f88d0e9ebd" />

### FIND  All Events (Paginated)
```bash
[PUT[ http://localhost:8080/api/users/by-province?cnam=Kigali city](http://localhost:8080/api/users/by-province?name=Kigali City)](http://localhost:8080/api/locations/by-parent/ff5e4861-e78d-4fd9-b255-d6046ad4448b)](http://localhost:8080/api/events?page=0&size=10)
```
<img width="910" height="901" alt="image" src="https://github.com/user-attachments/assets/2e025fb5-512d-447a-a0b1-69e86e2430f7" />

### FIND Talent Profile by ID
```bash
PUt http://localhost:8080/api/talent-profiles/1
```
<img width="917" height="903" alt="image" src="https://github.com/user-attachments/assets/fd1040a1-c696-44e4-9370-17641798f2cb" />

### FIND  All Bookings
```bash
PUt[ http://localhost:8080/api/talent-profiles/1](http://localhost:8080/api/bookings)
```

<img width="915" height="889" alt="image" src="https://github.com/user-attachments/assets/f589a8c2-4b2f-4ab9-a09a-93b630b100e6" />

## Database 

### location table 
<img width="1481" height="926" alt="image" src="https://github.com/user-attachments/assets/817d1a5e-cedf-4cfb-a675-09fe4f5072f5" />

### user table 
<img width="1486" height="556" alt="image" src="https://github.com/user-attachments/assets/1319f574-4e90-488e-88c3-cb784962f561" />







