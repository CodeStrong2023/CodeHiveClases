// Codigo de express o codigo del servidor
import express from "express";
import morgan from "morgan";
import tareasRoutes from "./router/tareas.routes.js"
import authRoutes from "./router/auth.routes.js"
import cookieParser from 'cookie-parser';
import cors from "cors";


const app = express();

//Middlewares
app.use(morgan("dev")); //Mensajes mas limpios y cortos
app.use(cors({
    origin: "http://localhost:5173",
    credentials: true
}));
app.use(cookieParser());
app.use(express.json());//Convertir todas las petisiones en formato json
app.use(express.urlencoded({extended: false})); //para codificar y le decimos que la extencion de formularion la ponemos en false porque son cortos, si son grandes iria en true


app.get("/", (req, res) => res.json({message: "Bienvenido a mi proyecto"})); //Para devolver una respuesta
app.use('/api', tareasRoutes);
app.use('/api', authRoutes);

// app.get("/test", (req, res) => {
//     throw new Error('Error Custom');
//     res.send('test');
// });

//Manejo de errores
app.use((err, req, res, next) => {
    res.status(500).json({
        status: "error",
        message: err.message 
    })
})


//Exportamos la app para usarla como modulo
export default app;