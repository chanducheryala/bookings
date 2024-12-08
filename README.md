### Development In-progress

[microservice-flow](https://app.eraser.io/workspace/paH88tq70X1Yss9jXEpb)


### Feedbacks are appreciated


## User Creational
Implement the **Factory Abstract Design Pattern** for creating a user with different roles.

### Authentication Endpoints
- **POST** `/auth/register` Create a user with the respective role.

- **POST** `/auth/login` Validate user credentials and return token if valid

## Admin Endpoints

- **GET** `/admins/location-managers`Get all location managers of admins.

- **DELETE** `/admins/location-managers/{id}` Delete the location manager with the specified `id`.

- **GET** `/admins/locations/{id}` Get the details of a specific location by `id`.



## Location Manager Endpoints

- **PUT**  `/location-managers/{id}`  Update the location manager with specified id



## Location Endpoints

- **POST**  `/locations` Create a location
- **GET**   `/locations/{id}` Get all location Details with the specified id
- **PUT**   `/locations/${id}` Update the location with specified id
- **DELETE** `/locations/${id}` Delete the location with specified id
- **GET**   `/locations/events/${id}` Get all Events with specified location id


## Event Endpoints

- **POST**  `/events` Create a Event
- **GET**   `/events/${id}` Get Event with specified id
- **PUT**   `/events/{id}` Update the Event with specified id
- **DELETE** `/events/${id}` Delete the Event with specified id


## Event Booking Plans with Capacity

1. **VIP Premium Plan**
2. **Premium Plan**
3. **Basic Plan**




## Schema's
1. **User**
2. **Admin**
3. **Location Manager**
4. **Location**
4. **Event**
5. **Event Details**
6. **Event Plans**
