import React, { useState } from 'react'
import ViewItems from './ViewItems'

export default function AddItem() {

    const [itemName, setItemName] = useState("");
    const [itemSellingPrice, setItemSellingPrice] = useState(0.0);
    const [itemBuyingPrice, setItemBuyingPrice] = useState(0.0);

    const handleSubmit = () => {
        let data = {
            itemName: itemName,
            itemSellingPrice: itemSellingPrice,
            itemBuyingPrice: itemBuyingPrice
        };

        console.log(data);

        fetch("/app/item/", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }, body: JSON.stringify(data)
        })
            .then((response) => {
                if (response.status === 201) {
                    console.log("User Added.");
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
            <div className="row">
                <div className="mx-auto col-10 col-md-8 col-lg-6">
                    <h1>Inventory Management System</h1>
                    <form>
                        <div className="mb-3">
                            <label htmlFor="item-name" className="form-label">Item Name</label>
                            <input type="text" className="form-control" id="item-name" value={itemName} onChange={(e) => setItemName(e.target.value)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="item-selling-price" className="form-label">Item Selling Price</label>
                            <input type="text" className="form-control" id="item-selling-price" value={itemSellingPrice} onChange={(e) => setItemSellingPrice(e.target.value)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="item-buying-price" className="form-label">Item Buying Price</label>
                            <input type="text" className="form-control" id="item-buying-price" value={itemBuyingPrice} onChange={(e) => setItemBuyingPrice(e.target.value)} />
                        </div>
                        <button type="submit" className="btn btn-primary" onClick={handleSubmit}>Submit</button>
                    </form>
                    <hr className="hr hr-blurry" />
                    <ViewItems />
                </div>
            </div>
        </div>
    )
}
