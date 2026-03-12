# Talent Booking System

A Spring Boot REST API application for managing talent bookings and events with location-based user management.

## ⚠️ IMPORTANT: Testing Instructions

**Before testing with Postman:**
1. Read `POSTMAN_TESTING_GUIDE.md` for detailed instructions
2. Locations use **UUID** - you must copy actual UUIDs from responses
3. Other entities (Users, Events, etc.) use **Long/Integer** IDs
4. Always create locations in hierarchical order (Province → District → Sector → Cell → Village)
5. Replace all `REPLACE_WITH_*_UUID` placeholders with actual UUIDs from your responses

## Recent Fixes

✅ **Fixed pagination** - Bookings and TalentProfiles now handle pagination parameters correctly
✅ **Updated Postman Collection** - Added comprehensive instructions in description
✅ **Created Testing Guide** - Step-by-step guide for proper API testing

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

## Test API Examples

### Create User
```bash
POST http://localhost:8080/api/users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "phone": "+250788123456"
}
```

### Get All Users
```bash
GET http://localhost:8080/api/users?page=0&size=10
```

### Create Event
```bash
POST http://localhost:8080/api/events
Content-Type: application/json

{
  "name": "Music Concert",
  "description": "Live music event",
  "date": "2024-12-31",
  "location": "Kigali Arena"
}
```

### Create Booking
```bash
POST http://localhost:8080/api/bookings
Content-Type: application/json

{
  "eventId": 1,
  "talentProfileId": 1,
  "status": "PENDING"
}
```

## Database Configuration
```properties
Database: PostgreSQL
Host: localhost:5432
Database Name: talent_booking_db
Username: postgres
Password: .......
```

