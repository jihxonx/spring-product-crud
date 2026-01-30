# Product CRUD Practice

Spring Boot와 JPA를 사용하여  
**상품(Product)** 과 **주문(Order)** 도메인의 CRUD 기능을 구현한 연습 프로젝트입니다.  

Spring의 기본 구조 (Controller / Service / Repository) 와  
의존성 주입(DI), JPA의 엔티티 매핑 및 연관관계 설계를 익히는 것을 목표로 합니다.

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

> ✅ 주문 생성 시 이미 등록된 상품의 `productId`를 사용해야 합니다.  
> 예시 요청(JSON):
> ```json
> {
>   "productId": 1,
>   "quantity": 2,
>   "buyerName": "admin"
> }
> ```

### 📦 Order API  
Order 도메인에 대한 주문 생성 및 조회 API입니다.

| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | `/api/orders` | 주문 생성 |
| GET | `/api/orders` | 주문 전체 조회 |
| GET | `/api/orders/{id}` | 주문 단건 조회 |

>✅ 상품 이름 변경 후 주문 반영 확인  
> `PUT /api/products/{id}` → `GET /api/orders/{id}`  
> - 상품 이름 수정 후 주문을 다시 조회하면, 변경된 상품명이 반영되어 출력됩니다.

## 🧩 ERD (Entity Relationship Diagram)

상품(Product)과 주문(Order) 간의 관계를 나타내는 다이어그램입니다.  
한 상품은 여러 주문을 가질 수 있습니다. (1:N 관계)
<img width="1495" height="2373" alt="Product Order Link Model-2026-01-29-034316" src="https://github.com/user-attachments/assets/ac401dd6-8a6c-4253-aef7-49ac5ec2d295" />





## 🧾 API 테스트 (Postman 결과)

✅ 상품 등록

POST /api/products
<img width="1146" height="518" alt="상품 등록" src="https://github.com/user-attachments/assets/d490883c-95ff-4291-8c34-7a325db3bc34" />

✅ 상품 조회

GET /api/products/{id}
<img width="1156" height="550" alt="상품 단건 조회" src="https://github.com/user-attachments/assets/8e21bbdb-66fd-412d-b283-8a7a028cf1de" />

✅ 상품 수정

PUT /api/products/{id}
<img width="1151" height="503" alt="상품수정" src="https://github.com/user-attachments/assets/39b8d672-1b53-40fa-8193-59fcf32ec08a" />
<img width="1158" height="550" alt="상품수정1" src="https://github.com/user-attachments/assets/dd15bcf3-6a01-4482-bef0-997c9dad886a" />

✅ 상품 삭제

DELETE /api/products/{id}
<img width="1156" height="491" alt="상품삭제" src="https://github.com/user-attachments/assets/0841a5ba-7c14-4cb5-991e-0170a2a68380" />
<img width="370" height="73" alt="상품삭제1" src="https://github.com/user-attachments/assets/065e0084-0afc-46b2-ba86-55f50e22787c" />

✅ 주문 생성

POST /api/orders
<img width="1154" height="625" alt="주문생성" src="https://github.com/user-attachments/assets/3a6a304c-ac8c-4f2c-90d9-61b17f0d6359" />

✅ 주문 전체 조회

GET /api/orders
<img width="1155" height="658" alt="주문전체조회" src="https://github.com/user-attachments/assets/b3502efa-b4ad-4da2-ac5f-640715a6902a" />

✅ 주문 단건 조회

GET /api/orders/{id}
<img width="1156" height="632" alt="주문단건조회" src="https://github.com/user-attachments/assets/ba3a18c5-d3e1-4c4c-ad72-e60b2be3e1fe" />

✅ 상품 이름 변경 후 주문 반영 확인

PUT /api/products/{id} → GET /api/orders/{id}
<img width="1150" height="439" alt="상품이름변경후주문반영" src="https://github.com/user-attachments/assets/4ad2d3b2-6bf1-44c6-84d3-d0476ee6e96a" />
<img width="1145" height="668" alt="스크린샷 2026-01-28 232229" src="https://github.com/user-attachments/assets/4057134f-cc71-4241-8e4a-51ac44272d58" />


---

## 🔜 다음 구현 예정 기능

### 🧾 주문 목록 조회 (Pagination + N+1 문제 해결)
한 요청에 여러 주문을 **페이징 방식으로 조회**할 수 있도록 개선할 예정입니다.

- 주문 목록 조회 API 구현 
- 응답 데이터에 **상품 이름** 포함
- 조회 시 **N+1 문제**가 발생하지 않도록 최적화 예정

 **구현 완료 후 확인할 내용**
- 로그를 통해 쿼리 실행 예시 확인 및  
  N+1 문제를 피한 방법에 대한 간단한 설명 작성

---

### 📦 상품 재고 차감 (Stock 감소 로직)
상품 도메인에 **재고(stock)** 필드를 추가하고,  
**주문 생성 시 재고가 자동으로 차감**되도록 구현할 예정입니다

- 상품에 `stock` 필드 추가  
- 주문 수량에 따라 `stock` 감소 처리  
- 재고가 0 이하일 경우 주문 불가 처리  

또한, **재고 차감이 원자적으로** 이루어지도록  
트랜잭션 처리를 고려하여 구현할 예정

 **구현 완료 후 확인할 내용** 
- **원자성 보장 방법** 에 대한 간단한 설명









