**Model/Architecture:**
+---------------------+
|        User         |
+---------------------+
| - userId: String    |
| - name: String      |
| - email: String     |
+---------------------+
| + scheduleTour(...) |
+---------------------+
            |
            |
          1 | schedules
            |
            |
            V
+---------------------+
|       Tour          |
+---------------------+
| - tourId: UUID      |
| - timeSlot: String  |
| - propertyId: String|
| - userId: String    |
+---------------------+
            |
            |
            |
            | scheduled for
          * |
            |
            V
+---------------------+
|     Property        |
+---------------------+
| - propertyId: String|
| - address: String   |
| - description: String|
+---------------------+
            ^
            |
          * |
            |
            |
            |
+---------------------+
|    TourRepository   |
+---------------------+
| + saveTour(...)     |
| + findTour(...)     |
+---------------------+
            |
            |
          * |
            |
            |
            V
+---------------------+
|  PropertyRepository |
+---------------------+
| + saveProperty(...) |
| + findProperty(...) |
+---------------------+
            |
            |
          * |
            |
            |
            V
+---------------------+
|     UserRepository  |
+---------------------+
| + saveUser(...)     |
| + findUser(...)     |
+---------------------+


**project sturcture**
src
└── main
    ├── java
    │   └── com
    │       └── example
    │           └── propertymanagement
    │               ├── PropertyManagementApplication.java
    │               ├── controller
    │               │   ├── PropertyController.java
    │               │   ├── TourController.java
    │               │   └── UserController.java
    │               ├── entity
    │               │   ├── Property.java
    │               │   ├── Tour.java
    │               │   └── User.java
    │               ├── repository
    │               │   ├── PropertyRepository.java
    │               │   ├── TourRepository.java
    │               │   └── UserRepository.java
    │               └── service
    │                   ├── PropertyService.java
    │                   ├── TourService.java
    │                   └── UserService.java
    └── resources
        └── application.properties

