# LedgerSync

`LedgerSync` is a real-time, collaborative transaction auditing dashboard designed for financial institutions and risk management teams. It provides an event-driven workspace where multiple analysts can review, categorize, flag, and approve pending corporate transactions simultaneously without data conflicts or page reloads.

---

## 📋 Problem Statement & Purpose

### The Problem
In enterprise fintech operations, high-volume transaction monitoring and exception handling (like fraud flagging or dispute resolution) often suffer from **operational latency** and **data concurrency issues**. 

* **Data Silos & Stale Views:** Traditional banking dashboards rely on HTTP polling or manual refreshes. If Analyst A flags a high-risk transaction, Analyst B might still see it as "Pending" and attempt to approve it, causing data overwrites, double-processing, or critical race conditions.
* **Overengineered Architectures:** Modern solutions to this problem often involve complex, heavy Single Page Application (SPA) frameworks (like React or Angular) paired with massive state-management libraries. This significantly increases development overhead, build times, and bundle sizes for what is fundamentally a data-driven internal tool.

### The Solution
`LedgerSync` addresses these challenges by combining a **robust, thread-safe Java backend** with a **hyper-lightweight, event-driven frontend architecture**. 

By leveraging WebSockets and HTML-over-the-wire, state changes (such as approving or flagging a transaction) made by one analyst are immediately broadcast and updated on all other active analysts' screens in real time. This ensures absolute synchronization across the auditing floor, enforces compliance via automated audit logging, and maintains data integrity under simultaneous traffic.

---

## 🛠️ Frameworks & Technologies

The project utilizes a modern, minimalist tech stack chosen for its rapid delivery capabilities, high performance, and low architectural overhead:

* **Backend:**
    * **Java 21:** Utilizes modern language features such as **Records** for immutable data modeling and **Pattern Matching** for clean business logic execution.
    * **Spring Boot 3.x:** Handles core application framework capabilities, dependency injection, and embedded server architecture.
    * **Spring Data JPA / Hibernate:** Manages object-relational mapping and abstracts data access patterns.
    * **Spring WebSocket & STOMP:** Powers full-duplex, low-latency communication to broadcast server-side state changes directly to connected clients.
* **Database:**
    * **SQLite:** Chosen as an embedded, lightweight relational database to enable zero-configuration local development while strictly supporting ACID transactions.
* **Frontend:**
    * **Thymeleaf:** Server-side Java template engine used to render highly dynamic, reusable HTML fragments.
    * **HTMX:** Extends HTML capabilities by allowing direct AJAX requests and WebSocket connections via simple HTML attributes (`hx-post`, `ws-connect`), eliminating the need for a separate JavaScript build pipeline or heavy frontend framework.

---

## 🚀 Development Phases & Iterative Roadmap

To ensure stable, testable delivery, the project is structured across three progressive phases:

### Phase 1: Core Financial Ledger (CRUD & Server-Driven UI)
* **Objective:** Establish the foundational data layer and basic user interface.
* **Feature Goals:**
    * Implement the core relational schema (`Transaction` and `AuditLog` models) mapped to SQLite.
    * Build a Spring `CommandLineRunner` to seed the database with mock credit card transaction data upon startup.
    * Develop a clean, data-dense Thymeleaf ledger view.
    * Integrate basic HTMX triggers so clicking "Approve" or "Flag" issues an inline HTTP POST, updating the database and returning an updated, single HTML table row (`<tr>`) dynamically.

### Phase 2: The Multi-Client Engine (Real-Time Synchronization)
* **Objective:** Introduce event-driven updates across separate browser sessions.

### Phase 3: Compliance, Auditing & Access Control
* **Objective:** Harden the application to meet strict financial security guidelines.