// Archivo para generar las consultas SQL y la conexion a la base de datos
// import { Pool } from "pg"; //Esta forma no funciono
import pg from "pg";

export const pool = new pg.Pool({
    port: 5432,
    host:"localhost",
    user:"postgres",
    password: "34016357",
    database: "PERN"
});

pool.on("connect", () => {
    console.log("Connected to the DB");
});

// export default pool;