API básica para gestionar tareas, donde se puedan listar todas las tareas, agregar
 nuevas tareas y marcar una tarea como completada utilizando el método PUT

  1. GET-Listar todas las tareas:- URL: http://localhost:8080/tasks.- Solicitud de tipo GET.
 2. POST- Crear varias nuevas tareas:- URL: http://localhost:8080/tasks.- Solicitud de tipo POST con un array de objetos JSON.
 3. PUT-Marcar unatarea comocompletada:- URL: http://localhost:8080/tasks/{id}/complete.- Solicitud de tipo PUT para marcar la tarea con el id como completada.

 4.  1. @RestController: Esta anotación indica que esta clase es un controlador de Spring, el cual
 manejará las solicitudes HTTP entrantes y generará respuestas.
 2. @RequestMapping("/tasks"): Define que todas las rutas de esta clase estarán precedidas
 por "/tasks".
 3. private List<Task> tasks: Es una lista en memoria que almacenará las tareas. Este es un
 almacenamiento temporal que desaparecerá al detener la aplicación.
 4. @GetMapping: Mapea las solicitudes GET a /tasks. El método getAllTasks() devuelve la
 lista de todas las tareas en formato JSON con el estado 200 (OK).
 5. @PostMapping: Mapea las solicitudes POST a /tasks. El método createTask() recibe un
 objeto Task en el cuerpo de la solicitud, lo añade a la lista de tareas y responde con el estado
 201(CREATED).
 6. @PutMapping("/{id}/complete"): Mapea las solicitudes PUT a /tasks/{id}/complete. El
 método completeTask() busca una tarea en la lista por su ID y la marca como completada. Si
 la encuentra, responde con la tarea actualizada y el estado 200 (OK); si no, responde con el
 estado 404 (NOTFOUND).
 7. El modelo Task: Contiene los atributos id, description y completed. También incluye los
 getters y setters para manipular estos valores
