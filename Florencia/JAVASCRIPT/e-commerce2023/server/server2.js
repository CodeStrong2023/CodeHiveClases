import express from "express"; //Para poder trabajar mas simplre con node
import cors from "cors"; //Cors es para evitar algun error en funcion de las medidas de seguridad de los navegadores

//SDK de mercado pago
import {MercadoPagoConfig, Preference} from "mercadopago";

//Agregar credenciales
const client = new MercadoPagoConfig({
    accessToken: "TEST-4812261499534302-100123-c486813cb4863331eb5dff0902451273-21012868", //Access token
})


const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());

app.get("/", (req,res)=>{
    res.send("Soy el server: ");
});

app.post("/create_preference", async(req,res) =>{
    try{
        const body = {
            items: [
                {
                    title: req.body.title,
                    quantity: Number(req.body.quantity),
                    unit_price: Number(req.body.price),
                    currency_id: "ARS",
                },
            ],
            back_urls:{
                success:"http://localhost:3000",
                failure:"http://localhost:3000",
                pending:"http://localhost:3000",
            },

            auto_return: 'approved',
        };

        const preference = new Preference(client);
        const result = await preference.create({ body });
        res.json({
            id: result.id,
        });

    }catch(error){
        console.log(error);
        res.status(500).json({
            error: "Error al crear la preferencia :("
        });
    }
});

app.listen(port, ()=>{
  console.log(`El servidor esta corriendo en el puerto ${port}`);
})











