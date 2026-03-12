# Talent Booking System

A Spring Boot REST API application for managing talent bookings and events with location-based user management.

## Tested API 

### Pagination
```bash
PUT http://localhost:8080/api/users?page=0&size=2
```
<img width="1748" height="869" alt="image" src="https://github.com/user-attachments/assets/7d3a701a-07ba-47d3-932b-31199bb1101a" />

### Database side 
<img width="1066" height="417" alt="image" src="https://github.com/user-attachments/assets/56b99fb8-c492-4254-95b8-79237a4b268c" />


### Sort
```bash
GET http://localhost:8080/api/users?sortBy=fullName
```
<img width="1387" height="876" alt="image" src="https://github.com/user-attachments/assets/7a2fcf70-53b6-4853-89e0-60a032bcd41c" />

### Database side
<img width="1091" height="500" alt="image" src="https://github.com/user-attachments/assets/d14a98c7-03e1-4f09-a66c-c2465ce04532" />

### existBy
```bash
PUT http://localhost:8080/api/users/check-email?email=uwase@gmail.com
```
<img width="1369" height="535" alt="image" src="https://github.com/user-attachments/assets/3fbea05a-42f2-43c0-ab46-fdff1ccc4f07" />

### Database side
<img width="1083" height="401" alt="image" src="https://github.com/user-attachments/assets/df8397b4-f7c7-4f36-a7b8-59b82723688e" />

### FIND Users by Province CODE
```bash
PUT http://localhost:8080/api/users/by-province?code=KGL
```
<img width="1377" height="866" alt="image" src="https://github.com/user-attachments/assets/960a77bb-94da-405b-ac2c-39db49e9f85b" />

### Database side
<img width="935" height="441" alt="image" src="https://github.com/user-attachments/assets/e50fdf97-392c-4fee-952f-ba3688bd184e" />


## API Endpoints

### Users
```
POST   /api/users
GET    /api/users?page=0&size=10&sortBy=name
GET    /api/users/{id}
PUT    /api/users/{id}
DELETE /api/users/{id}
GET    /api/users/check-email?email=user@example.com
GET    /api/users/by-province?code=01&name=Kigali
GET    /api/users/by-district/{districtId}
GET    /api/users/by-sector/{sectorId}
GET    /api/users/by-cell/{cellId}
GET    /api/users/by-village/{villageId}
```

### Talent Profiles
```
POST   /api/talent-profiles
GET    /api/talent-profiles
GET    /api/talent-profiles/{id}
PUT    /api/talent-profiles/{id}
DELETE /api/talent-profiles/{id}
```

### Events
```
POST   /api/events
GET    /api/events?page=0&size=10
GET    /api/events/{id}
PUT    /api/events/{id}
DELETE /api/events/{id}
```

### Bookings
```
POST   /api/bookings
GET    /api/bookings
GET    /api/bookings/{id}
PUT    /api/bookings/{id}
DELETE /api/bookings/{id}
```

### Location Management
```
POST   /api/provinces
GET    /api/provinces
GET    /api/provinces/{id}
PUT    /api/provinces/{id}
DELETE /api/provinces/{id}

POST   /api/districts
GET    /api/districts
GET    /api/districts/{id}
PUT    /api/districts/{id}
DELETE /api/districts/{id}

POST   /api/sectors
GET    /api/sectors
GET    /api/sectors/{id}
PUT    /api/sectors/{id}
DELETE /api/sectors/{id}

POST   /api/cells
GET    /api/cells
GET    /api/cells/{id}
PUT    /api/cells/{id}
DELETE /api/cells/{id}

POST   /api/villages
GET    /api/villages
GET    /api/villages/{id}
PUT    /api/villages/{id}
DELETE /api/villages/{id}
```


## Database Configuration
```properties
Database: PostgreSQL
Host: localhost:5432
Database Name: talent_booking_db
Username: postgres
Password: .......
```

