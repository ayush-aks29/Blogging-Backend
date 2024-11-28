# Blogging Backend

Welcome to the Blogging Backend project! This project provides the backend functionalities for a blogging platform, including user authentication, post management, and more.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction

This repository contains the backend code for a blogging platform. It provides RESTful APIs for user authentication, post creation, editing, and deletion, as well as comment management.

## Features

- User registration and authentication
- JWT-based authentication
- Create, read, update, and delete blog posts
- Comment on blog posts
- User roles and permissions

## Installation

To get a local copy up and running, follow these simple steps:

1. **Clone the repository:**
    ```bash
    git clone https://github.com/ayush-aks29/blogging-backend.git
    ```

2. **Navigate to the project directory:**
    ```bash
    cd blogging-backend
    ```

3. **Install dependencies:**
    ```bash
    mvn install
    ```

4. **Set up environment variables:**
    - Create or edit the `src/main/resources/application.yml` file.

## Usage

### Running the Server
To start the server, use the following command:
```bash
 mvn spring-boot:run
```


### API Endpoints

Here are some of the key API endpoints:

- **User Registration:** `POST /api/auth/register`
- **User Login:** `POST /api/auth/login`
- **Create a Post:** `POST /api/posts`
- **Get All Posts:** `GET /api/posts`
- **Update a Post:** `PUT /api/posts/:id`
- **Delete a Post:** `DELETE /api/posts/:id`

## Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

- Ayush Kumar Srivastava
- ayushksrivastava29@outlook.com

Project Link: [https://github.com/ayush-aks29/blogging-backend](https://github.com/ayush-aks29/blogging-backend)
