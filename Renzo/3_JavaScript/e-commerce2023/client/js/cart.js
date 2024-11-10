const modalOverlay = document.getElementById("modal-overlay");
const modalContainer = document.getElementById("modal-container");
const cartBtn = document.getElementById("cart-btn");
const cartCounter = document.getElementById("cart-counter");

const displayCart = () => {
    //Setteo de inicio
    modalContainer.innerHTML = "";
    modalContainer.style.display = "block";
    modalOverlay.style.display = "block";

    //Modal header
    const modalHeader = document.createElement('div'); //Podemos crear lo que queramos
    
    const modalClose = document.createElement('div');
    modalClose.innerText = "❌"
    modalClose.className = "modal-close";
    modalContainer.append(modalHeader);

    // Boton cerrar
    modalClose.addEventListener("click", ()=>{
        modalContainer.style.display = "none";
        modalOverlay.style.display = "none";
    })

    modalHeader.append(modalClose);

    const modalTitle = document.createElement('div');
    modalTitle.innerText = "Carrito";
    modalTitle.className = "modal-title";
    modalHeader.append(modalTitle);


    // MODAL BODY
    if(cart.length > 0){
    cart.forEach((product) => {
        const modalBody = document.createElement('div');
        modalBody.className = "modal-body";
        modalBody.innerHTML = `
        <div class="product">
            <img class="product" src="${product.img}"/>
            <div class="product-info">
                <h4>${product.productName}</h4>
        </div>
        <div class="quantity">
            <span class="quantity-btn-decrese">-</span>
            <span class="quantity-input">${product.quantity}</span>
            <span class="quantity-btn-increse">+</span>
        </div>
            <div class="price">${product.price * product.quantity}</div>
            <div class="delete-product">❌</div>
        </div>
        `;

        modalContainer.append(modalBody);

        const decrese = modalBody.querySelector(".quantity-btn-decrese") //Me permite capturar elementos por su clase de css
        decrese.addEventListener("click", ()=>{
            if(product.quantity !== 1){
                product.quantity--;
                displayCart();
            }

            displayCartCounter();
            
        })

        const increse = modalBody.querySelector(".quantity-btn-increse") //Me permite capturar elementos por su clase de css
        increse.addEventListener("click", ()=>{
            product.quantity++;
            displayCart();
            displayCartCounter();
        })

        //delete
        const deleteProduct = modalBody.querySelector(".delete-product");
        deleteProduct.addEventListener("click", ()=> {
            deleteCartProduct(product.id)
        })

    })

    // MODAL FOOTER
    const total = cart.reduce((acc, el) => acc + (el.price*el.quantity), 0) // El metodo reduce trabaja con 2 parametros el primero es el acumulador y el segundo represetna cada uno de los elementos del carrito y el 3er valor es desde donde queremos que arranque =>0

    const modalFooter = document.createElement('div');
    modalFooter.className = "modal-footer";
    modalFooter.innerHTML = `
    <div class="total-price">Total: ${total}</div>
    <button class="btn-primary" id="checkout-btn"> Go to Checkout</button>
    <div id="wallet_cointainer"></div>
    `;

    modalContainer.append(modalFooter);

    //Mercado pago
    const mp = new MercadoPago("TEST-dc5ec477-2fab-4d23-b4cd-1bb8b259ace1",{ //Public key
        locale: "es-AR",  //The mos common are: 'pt-BR, 'es-AR' and 'en-US'
    });

    //Creamos una funcion para que se muestre lo que hay en el carrito(**Agregado) -> podria ir "Su compra en Ecommerce"
    //Funcion que genera un titulo con la info del carrito
    const generateCartDescription = () =>{
        return cart.map(product => `${product.productName} (X${product.quantity})`).join(', ')
    };

    document.getElementById("checkout-btn").addEventListener("click", async() =>{
        try{
            const orderData = {
                title: generateCartDescription(),
                quantity: 1,
                price: total,
            };

            const response = await fetch("http://localhost:3000/create_preference", {
                method: "POST",
                headers:{
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(orderData),
            });

            const preference = await response.json();
            createCheckoutButton(preference.id);
        }catch(error){
            alert("Error 😥");
        }
    });

    const createCheckoutButton = (preferenceId) =>{
        const bricksBuilder = mp.bricks();

        const renderComponent = async() =>{
            if (window.checkoutButton) window.checkoutButton.unmount(); //Para que no se creen 2 instancias de boton de mercadopago

            await bricksBuilder.create("wallet", "wallet_cointainer", {
                initialization: {
                    preferenceId: preferenceId
                },
            });
        };

        renderComponent();
    };
}}

cartBtn.addEventListener("click", displayCart);

//Delete product functions
const deleteCartProduct = (id) =>{
    const foundId = cart.findIndex((elemento) => elemento.id === id);
    // console.log(foundId);
    cart.splice(foundId, 1) //Elimina elementos del array mediante 2 parametros. El primero el indice y el segundo cuantos quiero eleminar
    displayCart() //Como modifico el carrito tengo que volver a refrescar el carrito para que aparezcan los cambios
    displayCartCounter();
}

const displayCartCounter = () => {
    const cartLength = cart.reduce((acc, el) => acc + el.quantity, 0);
    if(cart.length > 0){
        cartCounter.style.display = 'block';
        cartCounter.innerText = cartLength;
    }else{
        cartCounter.style.display = 'none';
    }
}