# Kameleoon Trial Task

#### The API should allow:

* creation of a user account (deletion and other CRUD operations not requested). User properties are name, email, password and date of creation;
* addition, viewing (including a method to get a random quote), modification, and deletion of quotes (real deletion from the database, not just via an archive flag). Quote properties include content, date of creation / update, link to user who posted it, link to votes;
* voting on quotes (either upvote or downvote);
* view of the top and worse 10 quotes, the details of each quote, and ideally a graph of the evolution of the votes over time.

Project requirements:

* Source code published on https://github.com/ParshinSergey/kameloon
* Docker image published on https://hub.docker.com/repository/docker/parshinsergey/kameleoon/general
* Run project with command: docker run -p 8080:8080 parshinsergey/kameleoon:1.0.4
* Swagger link opens from http://localhost:8080/swagger-ui.html


