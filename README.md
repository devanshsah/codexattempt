# NoBroker-style Rental Clone (Local Machine)

This is a full local prototype with:
- **Spring Boot backend** (role-aware endpoints for owner, tenant, moderator, admin/super admin)
- **React frontend** (tenant/owner/moderator/admin views)
- **PL/SQL script** for tenant-owner automated matching notifications
- **Dockerized** backend + frontend via docker-compose
- **Sell flow skipped** (rent-only)

## Quick Start (without Docker)

### Backend
```bash
cd backend
mvn spring-boot:run
```
Backend runs at `http://localhost:8080`

### Frontend
```bash
cd frontend
npm install
npm run dev
```
Frontend runs at `http://localhost:5173`

## Quick Start (Docker)
```bash
docker compose up --build
```

## Main API Endpoints
- `POST /api/properties` -> owner posts property (goes to pending moderation)
- `GET /api/properties/tenant` -> tenant sees approved active rentals
- `GET /api/properties/owner/{email}` -> owner's properties
- `GET /api/properties/moderator/pending` -> moderator queue
- `PUT /api/properties/moderator/{id}/approve` -> approve post
- `PUT /api/properties/moderator/{id}/reject` -> reject post
- `PUT /api/properties/admin/{id}/disable` -> admin/super-admin disable listing

## PL/SQL
Run `database/plsql_matching_notifications.sql` in Oracle-compatible DB to create the matching tables and notification procedure.
