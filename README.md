
# TO-Do


  [microservice-flow](https://app.eraser.io/workspace/paH88tq70X1Yss9jXEpb)




## User Creational
Implement the **Factory Abstract Design Pattern** for creating a user with different roles.

### Authentication Endpoints
- **POST** `/auth/register`  
  Create a user with the respective role.

- **POST** `/auth/login`  
  Validate user credentials.

## Admin Endpoints

- **GET** `/admins/location-managers`  
  Get all location managers of admins.

- **PUT** `/admins/location-managers/{id}`  
  Update the location manager with the specified `id`.

- **DELETE** `/admins/location-managers/{id}`  
  Delete the location manager with the specified `id`.

- **GET** `/admins/locations/{id}`  
  Get the details of a specific location by `id`.



## Location Manager Endpoints

- **PUT**  `/location-managers/{id}`  Update the location manager with specified id
- **POST**  `/location-managers/{id}` 


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
