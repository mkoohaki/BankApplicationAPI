CREATE TABLE client (
    id UUID NOT NULL PRIMARY KEY,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    phoneNumber VARCHAR(100),
    emailAddress VARCHAR(100),
    accountNumbers VARCHAR(100) NOT NULL
);