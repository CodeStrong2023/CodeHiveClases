// import { Router } from "express";
import Router from "express-promise-router";
import {listarTareas, listarTarea, crearTarea, actualizarTarea, eliminarTarea} from "../controllers/tareas.controller.js";
import { isAuth } from "../middlewares/auth.middleware.js";
import {validateSchema} from "../middlewares/validate.middleware.js";
import {createTareasSchema} from "../schemas/tareas.schemas.js";

// import {listarTareas} from "../controllers/tareas.controller.js";
// import {listarTarea} from "../controllers/tareas.controller.js";
// import {crearTarea} from "../controllers/tareas.controller.js";
// import {actualizarTarea} from "../controllers/tareas.controller.js";
// import {eliminarTarea} from "../controllers/tareas.controller.js";

const router = Router();

router.get('/tareas', isAuth, listarTareas);

router.get('/tareas/:id', isAuth, listarTarea);

router.post('/tareas', validateSchema(createTareasSchema), isAuth, crearTarea);

router.put('/tareas/:id', isAuth, actualizarTarea);

router.delete('/tareas/:id', isAuth, eliminarTarea);


export default router;
