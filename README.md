User Controller
Register User
POST http://localhost:8083/api/users/register
Description: Registers a new user.

Login User
POST http://localhost:8083/api/users/login
Description: Logs in a user using email and password.

Patient Controller
Add Patient
POST http://localhost:8083/api/patients/add
Description: Adds a new patient.

Get Patient Details
GET http://localhost:8083/api/patients/{patientId}
Description: Retrieves details of a specific patient by patient ID.

Get Patients by User
GET http://localhost:8083/api/patients/user/{userId}
Description: Retrieves all patients associated with a specific user ID.

Heart Rate Controller
Record Heart Rate
POST http://localhost:8083/api/heart-rates/record
Description: Records a new heart rate for a patient.

Get Heart Rates by Patient
GET http://localhost:8083/api/heart-rates/patient/{patientId}
Description: Retrieves all heart rate records for a specific patient by patient ID.






