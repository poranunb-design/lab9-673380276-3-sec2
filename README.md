# 🏦Lab 9: Spring Boot Transaction

## 👩‍💻ข้อมูลผู้จัดทำ

* **ชื่อ:** Poranun Budsadeewong
* **รหัสนักศึกษา:** [673380276-3]

---

## 1. ชื่อโปรเจกต์

**Spring Boot Transaction - ระบบฝากเงิน**

โปรเจกต์นี้เป็นการพัฒนาระบบฝากเงินด้วย Spring Boot เพื่อศึกษาและทดลองการทำงานของ Transaction โดยใช้ `@Transactional` ในการควบคุมการเปลี่ยนแปลงข้อมูลในฐานข้อมูล และศึกษาผลลัพธ์เมื่อเกิดข้อผิดพลาดระหว่างการทำงาน

---

## 🎯2. วัตถุประสงค์

1. ศึกษาการสร้าง REST API ด้วย Spring Boot
2. ศึกษาการทำงานของ `@Transactional`
3. ทดลองการฝากเงินและบันทึกประวัติการฝากเงิน
4. ศึกษาการทำงานของ COMMIT และ ROLLBACK
5. เปรียบเทียบผลลัพธ์ระหว่างการใช้และไม่ใช้ `@Transactional`
6. ศึกษาความสัมพันธ์ระหว่าง Account และ DepositTransaction

---

## 3. เทคโนโลยีที่ใช้

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Visual Studio Code
* Postman
* pgAdmin 4

---

## 📂4. โครงสร้างโปรเจกต์

```text
Lab9
├── src
│   └── main
│       ├── java
│       │   └── lab9
│       │       ├── controller
│       │       ├── model
│       │       ├── repository
│       │       ├── service
│       │       └── Lab9Application.java
│       └── resources
│           └── application.properties
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

## 5. ฟังก์ชันการทำงาน

### 5.1 Create Account

ใช้สำหรับสร้างบัญชีธนาคารใหม่ โดยรับข้อมูลหมายเลขบัญชี ชื่อเจ้าของบัญชี และยอดเงินเริ่มต้น

### 5.2 Deposit Money

ใช้สำหรับฝากเงินเข้าบัญชี โดยระบบจะเพิ่มยอดเงินใน Account และบันทึกประวัติการฝากเงินใน DepositTransaction

### 5.3 Get Account

ใช้สำหรับตรวจสอบข้อมูลบัญชีและยอดเงินคงเหลือ โดยค้นหาจาก Account ID

---

## 🌐6. REST API

| Method | Endpoint                        | รายละเอียด   |
| ------ | ------------------------------- | ------------ |
| POST   | `/accounts`                     | สร้างบัญชี   |
| POST   | `/accounts/{accountId}/deposit` | ฝากเงิน      |
| GET    | `/accounts/{id}`                | ตรวจสอบบัญชี |

