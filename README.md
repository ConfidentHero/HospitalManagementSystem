# Hospital Management System

A Java Swing desktop application for managing basic hospital records with a MySQL database. This repository is a NetBeans Ant project.

> **Status:** Educational/demo project. It has no visible login, role-based access control, or audit trail. Do not use it with real patient or payment data without a substantial security and privacy review.

## Current functionality

The application provides separate forms for adding, updating, and deleting records in these areas:

- **Patients** — name, age, gender, phone, and address
- **Doctors** — name, specialization, phone, email, and address
- **Appointments** — patient ID, doctor ID, date, time, reason, and status
- **Medical records** — patient ID, doctor ID, diagnosis, treatment, notes, and record date
- **Prescriptions** — medical-record ID, medicine, dosage, duration, and instructions
- **Bills** — patient ID, optional appointment ID, bill date, amount, description, and status

This source tree does **not** currently include record browsing/search, report generation, or patient admission/discharge workflows. Appointment deletion also deletes bills linked to that appointment; review this behavior before using any non-disposable data.

## Technology and requirements

- Java **25** JDK (the NetBeans project sets `javac.source` and `javac.target` to `25`)
- MySQL Server
- Apache Ant (used by the NetBeans project build)
- NetBeans IDE is recommended
- MySQL Connector/J is included at `lib/mysql-connector-j-26.7.0.jar`

## Database setup

The application connects to:

```text
jdbc:mysql://localhost:3306/hospital_management
```

The connection settings are currently defined in `src/hospitalmanagementsystem/DBConnection.java`. The database name and username are hardcoded there; the username is currently `root`. The password is read from the `DB_PASSWORD` environment variable.

Set the password in the environment used to launch the application:

**Linux/macOS (shell):**

```bash
export DB_PASSWORD='your-local-mysql-password'
```

**Windows PowerShell:**

```powershell
$env:DB_PASSWORD = "your-local-mysql-password"
```

Do not commit passwords to source control. For anything beyond a local disposable database, change the hardcoded connection username to a dedicated, least-privilege database account and move all connection settings into external configuration.

### Important: schema is not included

This repository does not contain a database schema, migrations, or seed script. The application expects a database named `hospital_management` with tables and columns compatible with its SQL statements. The code references these tables and fields:

| Table | Fields referenced by the application |
|---|---|
| `patients` | `name`, `age`, `gender`, `phone`, `address` |
| `doctors` | `name`, `specialization`, `phone`, `email`, `address` |
| `appointments` | `appointment_id`, `patient_id`, `doctor_id`, `appointment_date`, `appointment_time`, `reason`, `status` |
| `medical_records` | `record_id`, `patient_id`, `doctor_id`, `diagnosis`, `treatment`, `notes`, `record_date` |
| `prescriptions` | `prescription_id`, `record_id`, `medicine_name`, `dosage`, `duration`, `instructions` |
| `bills` | `bill_id`, `patient_id`, `appointment_id`, `bill_date`, `amount`, `description`, `status` |

The ID columns are used as record identifiers by the forms; `bills.appointment_id` can be null. You must create and configure a compatible schema before the application can perform CRUD operations. The repository does not currently provide enough setup files to initialize the database automatically.

## Open and run in NetBeans

1. Install a Java 25 JDK, MySQL Server, and NetBeans with Java support.
2. Create a local MySQL database and tables compatible with the fields listed above.
3. Set `DB_PASSWORD` in the environment from which NetBeans will be launched.
4. In NetBeans, choose **File → Open Project** and select the repository directory.
5. Confirm the project uses a Java 25 platform and that the bundled Connector/J library is on the project classpath.
6. Run the project. The configured entry point is `hospitalmanagementsystem.MainMenu`.

The file `HospitalManagementSystem.java` is a database-connection check; it is **not** the configured GUI entry point. The project configuration selects `MainMenu`.

## Build with Ant

From the project root, with Ant and JDK 25 available:

```bash
ant clean jar
```

NetBeans-generated build files and project properties are under `nbproject/`. The application needs both a reachable MySQL database and the configured JDBC driver at runtime. The repository does not include a test suite or schema setup task.

## Project layout

```text
src/hospitalmanagementsystem/
├── AppointmentForm.java       # Appointment UI and CRUD actions
├── BillingForm.java           # Billing UI and CRUD actions
├── DBConnection.java          # MySQL JDBC connection configuration
├── DoctorForm.java            # Doctor UI and CRUD actions
├── HospitalManagementSystem.java # Database connection check
├── MainMenu.java              # Configured GUI entry point and navigation
├── MedicalRecordForm.java     # Medical-record UI and CRUD actions
├── PatientForm.java           # Patient UI and CRUD actions
└── PrescriptionForm.java      # Prescription UI and CRUD actions

lib/
└── mysql-connector-j-26.7.0.jar
```

## Known limitations

- No authentication, authorization, or audit logging is implemented.
- Patient and doctor update/delete actions identify records by name, which may match multiple people; use only test data until these operations are changed to use stable IDs.
- Appointment deletion also deletes associated bill rows.
- The application connects directly from the desktop client to MySQL and currently uses a hardcoded `root` username.
- Validation, money handling, and JDBC resource management need improvement before wider use.
- No schema file, automated tests, search/list screens, or report-generation code is included.

## Contributors

The original README lists the following contributors:

- Zahar Bin Zubair
- Muhammed Zahan
- Muhammed Ameem
- Mubashir Ismail
- Basil Bin Musthafa
- Akhil Chandran A V
