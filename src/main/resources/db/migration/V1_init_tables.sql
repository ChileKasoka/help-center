-- db/migration/V1__init_tables.sql

CREATE TABLE companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address VARCHAR(255),
    logo_url VARCHAR(255),
    is_active BOOLEAN DEFAULT TRUE,
    subscription_id INTEGER,
    subscription_start_date DATE,
    subscription_end_date DATE
);

CREATE TABLE subscription_plans (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    price DECIMAL(10,2),
    duration VARCHAR(20),
    max_cleaners INT,
    max_clients INT
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    phone VARCHAR(20),
    role VARCHAR(20),
    company_id INTEGER REFERENCES companies(id),
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE cleaners (
    id SERIAL PRIMARY KEY,
    f_name VARCHAR(100),
    l_name VARCHAR(100),
    phone VARCHAR(20),
    national_id VARCHAR(50),
    gender VARCHAR(10),
    address VARCHAR(255),
    company_id INTEGER REFERENCES companies(id),
    is_available BOOLEAN DEFAULT TRUE
);

CREATE TABLE clients (
    id SERIAL PRIMARY KEY,
    f_name VARCHAR(100),
    l_name VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100),
    address VARCHAR(255),
    company_id INTEGER REFERENCES companies(id)
);

CREATE TABLE services (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    price DECIMAL(10,2),
    company_id INTEGER REFERENCES companies(id)
);

CREATE TABLE bookings (
    id SERIAL PRIMARY KEY,
    booking_date TIMESTAMP,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    status VARCHAR(20),
    client_id INTEGER REFERENCES clients(id),
    cleaner_id INTEGER REFERENCES cleaners(id),
    service_id INTEGER REFERENCES services(id),
    company_id INTEGER REFERENCES companies(id)
);

CREATE TABLE payments (
    id SERIAL PRIMARY KEY,
    amount DECIMAL(10,2),
    payment_date TIMESTAMP,
    reference VARCHAR(100),
    payment_method VARCHAR(50),
    confirmed BOOLEAN DEFAULT FALSE,
    payment_type VARCHAR(50),
    company_id INTEGER REFERENCES companies(id),
    booking_id INTEGER REFERENCES bookings(id)
);

CREATE TABLE cleaner_schedules (
    id SERIAL PRIMARY KEY,
    cleaner_id INTEGER REFERENCES cleaners(id),
    date DATE,
    start_time TIME,
    end_time TIME,
    is_booked BOOLEAN DEFAULT FALSE
);

CREATE TABLE payrolls (
    id SERIAL PRIMARY KEY,
    start_period DATE,
    end_period DATE,
    total_earnings DECIMAL(10,2),
    cleaner_id INTEGER REFERENCES cleaners(id),
    company_id INTEGER REFERENCES companies(id)
);
