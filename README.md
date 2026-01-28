# Product CRUD Practice

Spring Boot와 JPA를 사용하여  
**상품(Product) 도메인의 CRUD 기능을 구현한 연습 프로젝트**입니다.

Spring의 기본 구조(Controller / Service / Repository)와  
의존성 주입(DI), JPA 사용 흐름을 익히는 것을 목표로 합니다.

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA 
- H2 Database
- Gradle
- Postman (API 테스트)

---

## 📁 Project Structure
```text
com.example.orderapp
 ├─ product
 │   ├─ controller   # ProductController
 │   ├─ service      # ProductService
 │   ├─ repository   # ProductRepository
 │   └─ entity       # Product
 │
 └─ order
     ├─ controller   # OrderController
     ├─ service      # OrderService
     ├─ repository   # OrderRepository
     ├─ dto          # OrderRequestDto
     └─ entity       # Order


```
## API Endpoints

### 🧱 Product API

Product 도메인에 대한 기본 CRUD API입니다.

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | 상품 전체 목록 조회 |
| GET | `/api/products/{id}` | 상품 단건 조회 |
| POST | `/api/products` | 상품 등록 |
| PUT | `/api/products/{id}` | 상품 수정 |
| DELETE | `/api/products/{id}` | 상품 삭제 |


### 📦 Order API  
Order 도메인에 대한 주문 생성 및 조회 API입니다.

| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | `/api/orders` | 주문 생성 |
| GET | `/api/orders` | 주문 전체 조회 |
| GET | `/api/orders/{id}` | 주문 단건 조회 |



> ✅ 주문 생성 시 이미 등록된 상품의 `productId`를 사용해야 합니다.  
> 예시 요청(JSON):
> ```json
> {
>   "productId": 1,
>   "quantity": 2,
>   "buyerName": "admin"
> }
> ```
