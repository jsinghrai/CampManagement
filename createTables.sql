CREATE TABLE Pharmacy (
    Ph_Key         VARCHAR (64) NOT NULL,
    P_patientKey   VARCHAR (64) NOT NULL,
    Pr_providerKey VARCHAR (64) NOT NULL,
    Ph_PresType    VARCHAR (64) NOT NULL,
    Ph_PresName    VARCHAR (64) NOT NULL,
    Ph_PickDate    VARCHAR (64) NOT NULL,
    Ph_PickTime    VARCHAR (64) NOT NULL,
    Ph_Dose        VARCHAR (64) NOT NULL
);

CREATE TABLE Prescribe (
    Pr_providerKey VARCHAR (64) NOT NULL,
    P_patientKey   VARCHAR (64) NOT NULL,
    Ph_Key         VARCHAR (64) NOT NULL
);

CREATE TABLE Prescription (
    Ph_Key       VARCHAR (64) NOT NULL,
    P_patientKey VARCHAR (64) NOT NULL
);

CREATE TABLE Provider (
    Pr_providerKey   VARCHAR (64)  NOT NULL
                                   PRIMARY KEY
                                   UNIQUE,
    Pr_name          VARCHAR (255) NOT NULL,
    Pr_credentialKey INT           NOT NULL,
    Pr_JobType       VARCHAR (255) NOT NULL,
    Pr_PhoneNumber   INT           NOT NULL,
    Pr_Email         VARCHAR (255) NOT NULL,
    Pr_Location      VARCHAR (255) NOT NULL,
    Pr_Speciality    VARCHAR (255) NOT NULL
);

CREATE TABLE Report (
    R_reportID   VARCHAR (64)  NOT NULL
                               PRIMARY KEY
                               UNIQUE,
    R_Results    VARCHAR (255),
    R_Prognosis  VARCHAR (255),
    R_Uploaded   VARCHAR (255),
    P_patientKey VARCHAR (64)  NOT NULL
);

CREATE TABLE Share (
    Pr_providerKey VARCHAR (64) NOT NULL,
    P_patientKey   VARCHAR (64) NOT NULL
);

CREATE TABLE Patient (
    P_patientKey    VARCHAR (64)  NOT NULL
                                  PRIMARY KEY
                                  UNIQUE,
    P_name          VARCHAR (255) NOT NULL,
    P_credentialKey INT           NOT NULL,
    P_Address       VARCHAR (255) NOT NULL,
    P_PhoneNumber   VARCHAR (255) NOT NULL,
    P_Email         VARCHAR (255) NOT NULL,
    P_DOB           VARCHAR (255) NOT NULL,
    P_Gender        VARCHAR (255) NOT NULL
);

CREATE TABLE Notification (
    Pr_providerKey VARCHAR (64) NOT NULL,
    P_patientKey   VARCHAR (64) NOT NULL
);

CREATE TABLE Manages (
    P_patientKey   VARCHAR (64) NOT NULL,
    Pr_providerKey VARCHAR (64) NOT NULL
);

CREATE TABLE Meet (
    P_patientKey VARCHAR (64) NOT NULL,
    A_apptKey    VARCHAR (64) NOT NULL
);

CREATE TABLE History (
    P_patientKey VARCHAR (64) NOT NULL,
    R_reportID   VARCHAR (64) NOT NULL
);

CREATE TABLE Credentials (
    c_credentialKey INT           NOT NULL
                                  PRIMARY KEY,
    c_passHash      VARCHAR (512) NOT NULL,
    c_salt          VARCHAR (16)  NOT NULL,
    c_type          CHAR (1)
);

CREATE TABLE Appointment (
    A_apptKey      VARCHAR (64) NOT NULL,
    P_patientKey   VARCHAR (64) NOT NULL,
    Pr_providerKey VARCHAR (64) NOT NULL,
    A_Time         VARCHAR (64) NOT NULL,
    A_Date         VARCHAR (64) NOT NULL,
    A_Location     VARCHAR (64) NOT NULL
);
