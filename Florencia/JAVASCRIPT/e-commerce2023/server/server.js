const express = require("express");
const app = express();
const cors = require("cors");
const mercadopago = require("mercadopago");
const path = require("path");

// Requerir MercadoPagoConfig y Preference
const { MercadoPagoConfig, Preference } = require('mercadopago');

// REPLACE WITH YOUR ACCESS TOKEN AVAILABLE IN: https://developers.mercadopago.com/panel
// mercadopago.configure({
// 	access_token: "<ACCESS_TOKEN>",
// });
// Configura tus credenciales de acceso
const mp = new MercadoPagoConfig({
	access_token: "<ACCESS_TOKEN>", // Reemplaza con tu access token
	});


app.use(express.urlencoded({ extended: false }));
app.use(express.json());

// app.use(express.static("../../client/html-js")); //Esta parte la sacamos porque daba algunos errores la cambiamos por la de abajo --> Backend de supervivencia<--
app.use(express.static(path.join(__dirname, "../client"))); //Lo dirijo a la carpeta client
app.use(cors());

app.get("/", function () {
    path.resolve(__dirname, "..", "client/media", "index.html"); //Sacar media
});

app.post("/create_preference", (req, res) => {

	let preference = {
		items: [
			{
				title: req.body.description,
				unit_price: Number(req.body.price),
				quantity: Number(req.body.quantity),
			}
		],
		back_urls: {
			"success": "http://localhost:8080",
			"failure": "http://localhost:8080",
			// "pending": "",
		},
		auto_return: "approved",
	};

	mercadopago.preferences
		.create(preference)
		.then(function (response) {
			res.json({
				id: response.body.id
			});
		}).catch(function (error) {
			console.log(error);
		});
});

app.get('/feedback', function (req, res) {
	res.json({
		Payment: req.query.payment_id,
		Status: req.query.status,
		MerchantOrder: req.query.merchant_order_id
	});
});

app.listen(8080, () => {
	console.log("The server is now running on Port 8080");
});