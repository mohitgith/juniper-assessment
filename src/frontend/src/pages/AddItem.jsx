import React, { useState } from 'react'
import ViewItems from './ViewItems'

export default function AddItem() {

    const [itemName, setItemName] = useState();
    const [itemSellingPrice, setItemSellingPrice] = useState();
    const [itemBuyingPrice, setItemBuyingPrice] = useState();

    const handleSubmit = () => {
        let data = {
            itemName: itemName,
            itemSellingPrice: itemSellingPrice,
            itemBuyingPrice: itemBuyingPrice
        };

        fetch("/api/item/", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }, body: JSON.stringify(data)
        })
            .then((response) => {
                if (response.status === 201) {
                    console.log("User Added.");
                }
                else if (response.status === 409) {
                    console.log("Already exist.");
                } else {
                    console.log(response.status);
                    throw new Error("Something went wrong.")
                }
            })
            .catch((error) => {
                console.error(error);
            })
    }

    return (
        <div>
            <div class="row">
                <div class="mx-auto col-10 col-md-8 col-lg-6">
                    <h1>Inventory Management System</h1>
                    <form>
                        <div class="mb-3">
                            <label for="item-name" class="form-label">Item Name</label>
                            <input type="text" class="form-control" id="item-name" value={itemName} onChange={(e) => setItemName(e.target.value)} />
                        </div>
                        <div class="mb-3">
                            <label for="item-selling-price" class="form-label">Item Selling Price</label>
                            <input type="text" class="form-control" id="item-selling-price" value={itemSellingPrice} onChange={(e) => setItemSellingPrice(e.target.value)} />
                        </div>
                        <div class="mb-3">
                            <label for="item-buying-price" class="form-label">Item Buying Price</label>
                            <input type="text" class="form-control" id="item-buying-price" value={itemBuyingPrice} onChange={(e) => setItemBuyingPrice(e.target.value)} />
                        </div>
                        <button type="submit" class="btn btn-primary" onSubmit={handleSubmit}>Submit</button>
                    </form>
                    <hr class="hr hr-blurry" />
                    <ViewItems />
                </div>
            </div>
        </div>
    )
}
