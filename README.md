## API implementation in Spring Boot

This is a Spring Boot application, which provides two API endpoints for counting click logs for a specific campaign.

The tech stack used is:

- Java
- Spring Boot
- SQL Server
- Maven
## API Reference

#### Count clicks for campaign

```http
  GET /api/clicklogs/:campaign/count
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `campaign` | `Long` | **Required**. Campaign id to count clicks for. |

#### Count campaign clicks that fall between a given start date and a given end date.

```http
  GET /api/clicklogs/:campaign/:startDate/:endDate/count
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `campaign`      | `Long` | **Required**. Campaign id to count clicks for. |
| `startDate`     | `String` | **Required**. The timestamp of click should be greater than or equal to startDate. |
| `endDate`       | `String` | **Required**. The timestamp of click should be less than or equal to endDate. |

startDate & endDate should be of following format: 
„yyyy-mm-ddhh:mm:ss“.


## Usage/Examples

```javascript
// Request 
http://localhost:8080/api/clicklogs/4510461/count

// Response
{
  "count": 13,
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/clicklogs/4510461/count"
    }
  }
}

```



```javascript
// Request 
http://localhost:8080/api/clicklogs/4510461/2021-11-0703:10:00/2021-11-0703:30:00/count

// Response
{
  "count": 4,
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/clicklogs/4510461/2021-11-0703%3A10%3A00/2021-11-0703%3A30%3A00/count"
    }
  }
}

```

